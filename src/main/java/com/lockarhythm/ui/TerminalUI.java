package com.lockarhythm.ui;

import java.util.Arrays;
import java.util.Scanner;
import com.lockarhythm.responders.Response;

public class TerminalUI implements UI {
  private static Scanner in = new Scanner(System.in);

  public String nextLine() {
    return in.nextLine();
  }

  public boolean hasNext() {
    return in.hasNext();
  }

  public void print(String... strings) {
    System.out.println("\t____________________________________________________________");
    for (String s : strings) {
      s = Arrays.stream(s.split("\n")).map(x -> "\t" + x).reduce("", (x, y) -> x + y + "\n");
      System.out.println(s);
    }
    System.out.println("\t____________________________________________________________\n");
  }

  public void print(Response res) {
    print(res.getText());
  }
}