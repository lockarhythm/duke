package com.lockarhythm.application;

import com.lockarhythm.query.SimpleQueryInterpreter;
import com.lockarhythm.storage.PersistentArrayList;
import com.lockarhythm.storage.Storage;
import com.lockarhythm.tasks.Task;
import com.lockarhythm.tasks.TaskList;
import com.lockarhythm.ui.TerminalUI;

final class TerminalDuke extends Application {
  public static void main(String[] args) {
    Storage storage = new Storage<Task>("/tmp/hello.txt");
    PersistentArrayList<Task> list = storage.load(Task.class);
    list.setStorage(storage);
    run(new TerminalUI(), new SimpleQueryInterpreter(new TaskList(list)));
  }
}
