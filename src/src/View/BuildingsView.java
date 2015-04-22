package View;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import Controller.BackHandler;
import Controller.BuildHandler;
import Data.City;
import Data.Buildings.Building;

public class BuildingsView extends BorderPane {
	
	private City currentCity;
	private GridPane buildingsPane;
	
	public BuildingsView(City c){
		currentCity = c;
		ImageView barracksImage = new ImageView(new Image(getClass().getResourceAsStream("/res/barracks.jpg")));
		barracksImage.setId("barracks");
		ImageView churchImage = new ImageView(new Image(getClass().getResourceAsStream("/res/church.jpg")));
		churchImage.setId("church");
		ImageView hallImage = new ImageView(new Image(getClass().getResourceAsStream("/res/hall.jpg")));
		hallImage.setId("hall");
		ImageView marketImage = new ImageView(new Image(getClass().getResourceAsStream("/res/market.jpg")));
		marketImage.setId("market");
		Stage stage = new Stage();
		buildingsPane = new GridPane();
		generateBox(barracksImage, currentCity.getBuildings().get(0) , 0,0);
		generateBox(churchImage, currentCity.getBuildings().get(1), 0,1);
		generateBox(hallImage, currentCity.getBuildings().get(2), 1,0);
		generateBox(marketImage, currentCity.getBuildings().get(3), 1,1);
		this.setCenter(buildingsPane);
		generateBackButton(stage);
        stage.setTitle("Buildings");
        Scene buildingScene = new Scene(this,450,510);
        buildingScene.getStylesheets().add("res/Styles/BuildingTabStyle.css");
        stage.setScene(buildingScene);
        stage.show();
	}
	
	private void generateBox(ImageView iv, Building b, int r, int c){
		BorderPane bp = new BorderPane();
		BuildingLabel l = new BuildingLabel(b);
		BorderPane.setAlignment(l ,Pos.CENTER);
		bp.setPadding(new Insets(10,10,10,10));
		iv.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>() {
			@Override
			public void handle(Event event) {
				Stage dialogStage = new Stage();
				dialogStage.initModality(Modality.WINDOW_MODAL);
				Button yesButton = new Button("Yes!");
				Button noButton = new Button("No!");
				yesButton.setOnAction(new BuildHandler(dialogStage, currentCity, l));
				noButton.setOnAction(new EventHandler<ActionEvent>() {			
					@Override
					public void handle(ActionEvent event) {
						dialogStage.close();
					}
				});
				
				//dialog properties
				VBox vb = new VBox();
				vb.setAlignment(Pos.CENTER);
				vb.setPadding(new Insets(5));
				HBox hb = new HBox();
				hb.getChildren().addAll(yesButton, noButton);
				hb.setAlignment(Pos.CENTER);
				hb.setPrefWidth(50);		hb.setPrefHeight(50);
				hb.setPadding(new Insets(5));
				vb.getChildren().addAll(new Text("Are you sure you want to build " + l.getText() + "?"), hb);
				Scene scene = new Scene(vb);
				
				
				dialogStage.setScene(scene);
				dialogStage.setResizable(false);
				dialogStage.show();
			}
		});
		iv.setFitHeight(200);
		iv.setFitWidth(200);
		bp.setCenter(iv);
		bp.setBottom(l);
		buildingsPane.add(bp, c, r);
	}
	
	private void generateBackButton(Stage stage){
		//back button
        Button backButton = new Button("< Back");
        BorderPane.setAlignment(backButton, Pos.BOTTOM_CENTER);
        backButton.setOnAction(new BackHandler(stage));
        this.setBottom(backButton);
	}

}
