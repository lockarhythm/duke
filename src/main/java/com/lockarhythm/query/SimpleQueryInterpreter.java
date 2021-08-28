package com.lockarhythm.query;

import com.lockarhythm.responders.QueryRespondable;
import com.lockarhythm.responders.Response;
import com.lockarhythm.responders.addlist.AddListResponder;
import com.lockarhythm.responders.exit.ExitResponder;
import com.lockarhythm.responders.markasdone.MarkAsDoneResponder;
import com.lockarhythm.tasks.TaskList;

/** SimpleQueryInterpreter finds the first QueryRespondable that responds a non-null response. */
public class SimpleQueryInterpreter implements QueryInterpreter {
  static QueryRespondable[] responders;

  public SimpleQueryInterpreter(TaskList list) {
    QueryRespondable[] res = {
      new ExitResponder(), new MarkAsDoneResponder(list), new AddListResponder(list),
    };
    responders = res;
  }

  public Response interpret(String query) {
    Response res = null;
    for (QueryRespondable responder : responders) {
      res = responder.respondTo(query);
      if (res != null) {
        return res;
      }
    }
    return res;
  }
}
