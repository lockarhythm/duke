package com.lockarhythm.tasks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class TaskList {
  private ArrayList<Task> list;

  public TaskList() {
    this.list = new ArrayList<Task>();
  }

  public TaskList(ArrayList<Task> list) {
    this.list = list;
  }

  public int size() {
    return list.size();
  }

  public TodoTask addTodoTask(String description) {
    TodoTask task = new TodoTask(description);
    list.add(task);
    return task;
  }

  public DeadlineTask addDeadlineTask(String description, String by) {
    DeadlineTask task = new DeadlineTask(description, by);
    list.add(task);
    return task;
  }

  public EventTask addEventTask(String description, String at) {
    EventTask task = new EventTask(description, at);
    list.add(task);
    return task;
  }

  public Task markAsDone(int index) {
    Task t = list.get(index);
    t.setDone(true);
    return t;
  }

  public Task deleteTask(int index) {
    return list.remove(index);
  }

  public void sortByTaskDate() {
    Collections.sort(list, (a, b) -> TaskDate.compare(a.getTaskDate(), b.getTaskDate()));
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    int i = 1;
    for (i = 0; i < list.size(); i++) {
      s.append(i + 1);
      s.append(".");
      s.append(list.get(i));
      s.append("\n");
    }
    return s.toString();
  }
}
