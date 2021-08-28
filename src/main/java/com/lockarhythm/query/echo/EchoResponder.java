package com.lockarhythm.query.echo;

import com.lockarhythm.query.QueryRespondable;
import com.lockarhythm.query.Result;

public class EchoResponder implements QueryRespondable {
  public Result respondTo(String query) {
    return new Result(query, false);
  }
}
