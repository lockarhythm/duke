package com.lockarhythm.ui;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class JavaFXUI extends Application {

  @Override
  public void start(Stage stage) {
    // String javaVersion = System.getProperty("java.version");
    // String javafxVersion = System.getProperty("javafx.version");
    // Label l =
    //    new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
    // Scene scene = new Scene(new StackPane(l), 640, 480);

    stage.setTitle("Duke");
    stage.setMinHeight(600.0);
    stage.setMinWidth(400.0);

    // stage.setScene(scene);

    // stage.show();

    try {
      FXMLLoader fxmlLoader = new FXMLLoader(JavaFXUI.class.getResource("/view/MainWindow.fxml"));
      AnchorPane ap = fxmlLoader.load();
      Scene scene = new Scene(ap);
      stage.setScene(scene);
      // fxmlLoader.<MainWindow>getController().setDuke(duke);
      stage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
