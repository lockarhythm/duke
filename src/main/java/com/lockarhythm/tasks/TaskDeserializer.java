package com.lockarhythm.tasks;

import com.google.gson.*;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Technique credit to https://www.baeldung.com/gson-list
 */
public class TaskDeserializer implements JsonDeserializer<Task> {
    private String taskTypeElementName;
    private Gson gson;
    private Map<String, Class<? extends Task>> taskTypeRegistry;

    public TaskDeserializer(String taskTypeElementName) {
        this.gson = new GsonBuilder()
          .registerTypeAdapter(LocalDateTime.class, new GsonLocalDateTime())
          .registerTypeAdapter(LocalDate.class, new GsonLocalDate())
          .create();

        this.taskTypeElementName = taskTypeElementName;
        this.taskTypeRegistry = new HashMap<>();

        this.registerTaskType("DEADLINE", DeadlineTask.class);
        this.registerTaskType("TODO", TodoTask.class);
        this.registerTaskType("EVENT", EventTask.class);
    }

    public void registerTaskType(String taskTypeName, Class<? extends Task> taskType) {
        taskTypeRegistry.put(taskTypeName, taskType);
    }

    public Task deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
        JsonObject taskObject = json.getAsJsonObject();
        JsonElement taskTypeElement = taskObject.get(taskTypeElementName);

        Class<? extends Task> taskType = taskTypeRegistry.get(taskTypeElement.getAsString());
        return gson.fromJson(taskObject, taskType);
    }
}

class GsonLocalDate implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {

    @Override
    public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        String ldtString = jsonElement.getAsString();
        return LocalDate.parse(ldtString,DateTimeFormatter.ISO_LOCAL_DATE);
    }

    @Override
    public JsonElement serialize(LocalDate localDate, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(localDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
    }
}

class GsonLocalDateTime implements JsonSerializer<LocalDateTime>, JsonDeserializer<LocalDateTime> {

    @Override
    public LocalDateTime deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        String ldtString = jsonElement.getAsString();
        return LocalDateTime.parse(ldtString,DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    @Override
    public JsonElement serialize(LocalDateTime localDateTime, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }
}
