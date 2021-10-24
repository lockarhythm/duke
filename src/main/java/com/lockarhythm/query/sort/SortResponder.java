package com.lockarhythm.query.sort;

import com.lockarhythm.query.RegexQueryInterpreter;
import com.lockarhythm.query.Result;
import com.lockarhythm.tasks.TaskList;

public class SortResponder extends RegexQueryInterpreter {
  private TaskList list;

  public SortResponder(TaskList list) {
    this.list = list;
  }

  protected String commandRegex() {
    return "^sort$";
  }

  public Result onMatch(String[] groups) {
    list.sortByTaskDate();
    return new Result("Ok! I have sorted the tasks by date!");
  }
}
