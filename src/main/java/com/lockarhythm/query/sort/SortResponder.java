package com.lockarhythm.query.sort;

import com.lockarhythm.query.RegexQueryInterpreter;
import com.lockarhythm.query.Result;
import com.lockarhythm.tasks.TaskList;

public class SortResponder extends RegexQueryInterpreter {
  private final static boolean DEFAULT_SORT_ORDER = true;

  private TaskList list;

  public SortResponder(TaskList list) {
    this.list = list;
  }

  protected String commandRegex() {
    return "^sort by (date|done)( desc| asc)?$";
  }

  public Result onMatch(String[] groups) {
    String sortKey = groups[1];
    boolean isAscending = parseIsAscending(groups[2]);

    TaskList sortedList = sortBy(sortKey, isAscending);

    return new Result(String.format("Ok! I have sorted the tasks by %s in %s order!\n%s", sortKey, isAscending ? "ascending" : "descending", sortedList));
  }

  private boolean parseIsAscending(String value) {
    if (value == null) {
      return DEFAULT_SORT_ORDER;
    }
    String s = value.trim();
    if (s.equals("desc")) {
      return false;
    } else if (s.equals("asc")) {
      return true;
    } else {
      return DEFAULT_SORT_ORDER;
    }
  }

  /**
   * Sorts by the `sortKey` in the order given by `isAscending`.
   */
  private TaskList sortBy(String sortKey, boolean isAscending) {
    switch(sortKey) {
      case "done":
        return list.sortByDone(isAscending);
      case "date":
        return list.sortByTaskDate(isAscending);
      default:
    };
    return list.sortByTaskDate(isAscending);
  }
}