package com.lockarhythm.query.echo;

import com.lockarhythm.query.QueryRespondable;
import com.lockarhythm.query.QueryResult;

public class EchoResponder implements QueryRespondable {
  public QueryResult respondTo(String query) {
    return new QueryResult(query, false);
  }
}
