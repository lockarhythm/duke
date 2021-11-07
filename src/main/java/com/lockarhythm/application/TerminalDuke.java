package com.lockarhythm.application;

import com.lockarhythm.query.SimpleQueryInterpreter;
import com.lockarhythm.storage.Storage;
import com.lockarhythm.tasks.Task;
import com.lockarhythm.tasks.TaskList;
import com.lockarhythm.ui.TerminalUI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * TerminalDuke is the entrypoint of the Terminal UI application of Duke.
 */
final class TerminalDuke extends Application {
  static Path path = Paths.get(".", "tasks.json");
  static Storage<Task> storage;
  static TaskList taskList;

  public static void main(String[] args) {
    initStorage();
    loadTaskList();
    run(
        new TerminalUI(),
        new SimpleQueryInterpreter(taskList),
        storage,
        taskList
    );
  }

  private static void initStorage() {
    storage = new Storage<Task>(path.toString());
  }

  private static void loadTaskList() {
    ArrayList<Task> list = storage.load(Task.class);
    TaskList taskList = new TaskList(list);
  }
}
