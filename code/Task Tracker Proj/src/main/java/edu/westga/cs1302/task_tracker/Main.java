package edu.westga.cs1302.task_tracker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Entry point for the program
 *
 * @author CS 1302
 * @version Fall 2025
 */
public class Main extends Application {
  private static final String WINDOW_TITLE = "JavaFX Starter Sample";
  private static final String GUI_RESOURCE = "views/MainWindow.fxml";

  /**
   * JavaFX entry point.
   *
   * @precondition none
   * @postcondition none
   *
   * @throws IOException
   */
  @Override
  public void start(Stage primaryStage) throws IOException {
    Parent parent = FXMLLoader.load(getClass().getResource(Main.GUI_RESOURCE));
    Scene scene = new Scene(parent);
    primaryStage.setTitle(WINDOW_TITLE);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  /**
   * Primary Java entry point.
   *
   * @precondition none
   * @postcondition none
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    Main.launch(args);
  }
  
}