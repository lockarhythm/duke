package com.lockarhythm.query.exit;

import com.lockarhythm.query.QueryRespondable;
import com.lockarhythm.query.QueryResult;

public class ExitResponder implements QueryRespondable {
  public QueryResult respondTo(String query) {
    if (query.equals("bye")) {
      return new QueryResult("Bye. Hope to see you again soon!", true);
    }
    return null;
  }
}
