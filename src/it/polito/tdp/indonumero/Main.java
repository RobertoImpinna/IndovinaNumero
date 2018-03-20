package it.polito.tdp.indonumero;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//RICORDA 
			//Il controller lo crea la scena ed il main se lo prede grazie al loader.
			//il modello è creato dal main che lo passa al controller.
			
			
			//fare il loader
			FXMLLoader loader = new FXMLLoader(getClass().getResource("IndoNumero.fxml"));
			BorderPane root = (BorderPane)loader.load();
			
			//fare la scena
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			//fare un oggetto di tipo modello
			Model model = new Model();
			
			//Prendo il controller dal loader ( perche il controller è creato dalla scena).
			//Al controlle gli setto il suo modello con quello che ho appena crato nel main
			((IndoNumeroController)loader.getController()).setModel(model);
			
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
