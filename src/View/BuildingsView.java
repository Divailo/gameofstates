package View;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import Data.City;
import Data.Buildings.Building;

public class BuildingsView extends GridPane {
	
	private City currentCity;
	
	public BuildingsView(City c){
		currentCity = c;
		Image image = new Image(getClass().getResource("..\\res\\EnglandMap.jpg").toExternalForm());
		String label1 = "Barracks ( Level ";
		String label2 = "Church ( Level ";
		String label3 = "Hall ( Level ";
		String label4 = "Market (Level ";
		generateBox(image, currentCity.getBuildings().get(0) , 0,0);
		generateBox(image, currentCity.getBuildings().get(1), 0,1);
		generateBox(image, currentCity.getBuildings().get(2), 1,0);
		generateBox(image, currentCity.getBuildings().get(3), 1,1);
		Stage stage = new Stage();
        stage.setTitle("Buildings");
        Scene buildingScene = new Scene(this,450,480);
        stage.setScene(buildingScene);
        stage.show();
	}
	
	private void generateBox(Image image, Building b, int r, int c){
		BorderPane bp = new BorderPane();
		BuildingLabel l = new BuildingLabel(b);
		bp.setAlignment(l ,Pos.CENTER);
		bp.setPadding(new Insets(10,10,10,10));
		ImageView iv = new ImageView(image);
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
				Scene scene = new Scene(VBoxBuilder.create().children(new Text("Are you sure you want to build " + l.getText() + "?"), HBoxBuilder.create().children(yesButton,noButton).alignment(Pos.CENTER).prefWidth(50).prefHeight(50).padding(new Insets(5)).build()).
					    alignment(Pos.CENTER).padding(new Insets(5)).build());
				
				dialogStage.setScene(scene);
				dialogStage.setResizable(false);
				dialogStage.show();
			}
		});
		iv.setFitHeight(200);
		iv.setFitWidth(200);
		bp.setCenter(iv);
		bp.setBottom(l);
		this.add(bp, c, r);
	}

}
