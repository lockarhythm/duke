package com.lockarhythm.storage;


import com.google.gson.GsonBuilder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;

public class Storage<T> {
  // TODO: read from init
  private String filePath;

  public Storage(String filePath) {
    this.filePath = filePath;
  }

  public PersistentArrayList<T> load(Class<T> type) {
    String content;
    try {
      content = Files.readString(Path.of(filePath), StandardCharsets.UTF_8);
    } catch (IOException e) {
      //content = "[]"; // empty list
      return new PersistentArrayList<T>();
    }
    Gson gson = new Gson();
    //Type typeOfT = new TypeToken<T>(){}.getType();
    Type typeOfT = TypeToken.getParameterized(PersistentArrayList.class, type).getType();
    return gson.fromJson(content, typeOfT);
  }

  public void overwrite(Serializable item) {
    try {
      FileOutputStream fo = new FileOutputStream(filePath);

      Gson gson = new GsonBuilder().setPrettyPrinting().create();

      String js = gson.toJson(item);
      fo.write(js.getBytes());

    } catch (IOException e) {
      // TODO: handle
      System.out.print(e);
    }
  }
}
