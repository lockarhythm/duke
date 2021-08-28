package com.lockarhythm.query.addlist;

import com.lockarhythm.query.QueryRespondable;
import com.lockarhythm.query.QueryResult;
import com.lockarhythm.tasks.TaskList;

public class AddListResponder implements QueryRespondable {
  private TaskList list;

  public AddListResponder(TaskList list) {
    this.list = list;
  }

  public QueryResult respondTo(String query) {
    if (query.equals("list")) {
      return new QueryResult("Here are the tasks in your list:\n" + list.toString(), false);
    }
    // by default, adds the given query.
    list.add(query);
    return new QueryResult("added: " + query, false);
  }
}
