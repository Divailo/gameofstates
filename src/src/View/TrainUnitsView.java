package View;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Controller.BackHandler;
import Data.City;

public class TrainUnitsView extends BorderPane {
	
	//trqbwa da e BorderPane, centera 6te e HBox
	//Bottom 6te e Cancel button?
	
	private City currentCity;
	private HBox unitsPanels;
	
	public TrainUnitsView(City c){
		currentCity = c;
		unitsPanels = new HBox();
		Stage stage = new Stage();
		//da naprawq metod? koito da sloji ne6tata w hboxa
		ImageView warriorImage = new ImageView(new Image(getClass().getResourceAsStream("/res/warriorBW.jpg")));
		warriorImage.setId("warrior");
		ImageView prophetImage = new ImageView(new Image(getClass().getResourceAsStream("/res/prophetBW.jpg")));
		prophetImage.setId("prophet");
		ImageView popImage = new ImageView(new Image(getClass().getResourceAsStream("/res/popstarBW.jpg")));
		popImage.setId("popstar");
		ImageView merchantImage = new ImageView(new Image(getClass().getResourceAsStream("/res/merchantBW.jpg")));
		merchantImage.setId("merchant");
		generateBox(warriorImage, "Train General");
		generateBox(prophetImage, "Train Prophet");
		generateBox(popImage, "Train Pop Star");
		generateBox(merchantImage, "Train Bussinessman");
		this.setCenter(unitsPanels);
		generateBackButton(stage);
		stage.setTitle("Train Units");
		Scene unitsScene = new Scene(this, 605,500);
		unitsScene.getStylesheets().add("res/Styles/UnitsTabStyle.css");
		stage.setScene(unitsScene);
		stage.show();
	}
	
	private void generateBox(ImageView iv, String l){
		VBox box = new VBox();
		iv.setFitHeight(450); iv.setFitWidth(150);
		box.getChildren().add(iv);
		box.getChildren().add(new Label(l));
		unitsPanels.getChildren().add(box);
	}
	
	private void generateBackButton(Stage stage){
		//back button
        Button backButton = new Button("< Back");
        BorderPane.setAlignment(backButton, Pos.BOTTOM_CENTER);
        backButton.setOnAction(new BackHandler(stage));
        this.setBottom(backButton);
	}
	
}
