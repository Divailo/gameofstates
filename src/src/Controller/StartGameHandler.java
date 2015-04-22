package Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import View.GameWindow;

public class StartGameHandler implements EventHandler<ActionEvent> {
	
	//Take e dobre zasega, no po-kysno 6te trqbwa da polzwame Game class-a, kojto da syzdawa igra i da prawi magic
	private Stage root;
	private ComboBox<String> listOfCities;
	private ComboBox<String> listOfMaps;
	
	public StartGameHandler(Stage root, ComboBox<String> listOfCities, ComboBox<String> listOfMaps){
		this.root = root;
		this.listOfCities = listOfCities;
		this.listOfMaps = listOfMaps;
	}

	@Override
	public void handle(ActionEvent arg0) {
		if(listOfCities.getSelectionModel().getSelectedItem()!=null){
			GameWindow gw = new GameWindow(listOfCities.getSelectionModel().getSelectedItem(), listOfMaps.getSelectionModel().getSelectedItem());
			root.close();
		}
		else{
			System.out.println("Need to select game settings");
		}
	}
	

}
