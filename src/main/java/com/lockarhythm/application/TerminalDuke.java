package com.lockarhythm.application;

import com.lockarhythm.query.SimpleQueryInterpreter;
import com.lockarhythm.tasks.TaskList;
import com.lockarhythm.tasks.Task;
import com.lockarhythm.ui.TerminalUI;
import com.lockarhythm.storage.PersistentArrayList;
import com.lockarhythm.storage.Storage;
import java.util.ArrayList;

final class TerminalDuke extends Application {
  public static void main(String[] args) {
    Storage storage = new Storage<Task>("/tmp/duke.json");
    //PersistentArrayList<Task> list = storage.load(Task.class);
    ArrayList<Task> list = storage.load(Task.class);
    storage.registerList(list);
    run(new TerminalUI(), new SimpleQueryInterpreter(new TaskList(list)), storage);
  }
}
