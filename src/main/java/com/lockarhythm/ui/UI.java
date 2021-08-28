package com.lockarhythm.ui;

import com.lockarhythm.query.QueryResult;

public interface UI {
  public String nextLine();

  public boolean hasNext();

  public void print(String... strings);

  public void print(QueryResult res);
}
