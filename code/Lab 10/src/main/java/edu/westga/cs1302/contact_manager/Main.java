package edu.westga.cs1302.contact_manager;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 * Main extends the JavaFX Application class to build the GUI and
 * start program execution.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class Main extends Application {

	private static final String WINDOW_TITLE = "Contact Manager";
	private static final String MAIN_WINDOW_FXML = "view/MainWindow.fxml";

	/** JavaFX Launch process
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param primaryStage reference for the initial window of the application
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane pane = this.loadGui();
			Scene scene = new Scene(pane);
			primaryStage.setScene(scene);
			primaryStage.setTitle(WINDOW_TITLE);
			primaryStage.show();
		} catch (IllegalStateException | IOException anException) {
			anException.printStackTrace();
		}
	}

	private Pane loadGui() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource(MAIN_WINDOW_FXML));
		return (Pane) loader.load();
	}

	/**
	 * Launches the application.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
