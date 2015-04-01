package Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import View.GameWindow;

public class StartGameHandler implements EventHandler<ActionEvent> {
	
	//Take e dobre zasega, no po-kysno 6te trqbwa da polzwame Game class-a, kojto da syzdawa igra i da prawi ta6aci
	private Stage root;
	private ComboBox<String> listOfCities;
	
	public StartGameHandler(Stage root, ComboBox<String> listOfCities){
		this.root = root;
		this.listOfCities = listOfCities;
	}

	@Override
	public void handle(ActionEvent arg0) {
		GameWindow gw = new GameWindow(listOfCities.getSelectionModel().getSelectedItem());
		root.close();
	}
	

}
