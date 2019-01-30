package kr.co.infopub.chapter.s102;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
public class Main extends Application {
 @Override
 public void start(Stage primaryStage) {
	try {
		primaryStage.setTitle("Billboard Accordian");
		BorderPane root = (BorderPane)FXMLLoader.load(
				     getClass().getResource("BillboardAccordianFx.fxml"));
		Scene scene = new Scene(root,1200,800);
		scene.getStylesheets().add(
				getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	} catch(Exception e) {
		e.printStackTrace();
	}
 }
 public static void main(String[] args) {
	launch(args);
 }
}
