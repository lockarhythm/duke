package com.lockarhythm.query.exit;

import com.lockarhythm.query.QueryRespondable;
import com.lockarhythm.query.Result;

public class ExitResponder implements QueryRespondable {
  public Result respondTo(String query) {
    if (query.equals("bye")) {
      return new Result("Bye. Hope to see you again soon!", true);
    }
    return null;
  }
}
