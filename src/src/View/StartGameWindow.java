package View;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import Controller.StartGameHandler;

public class StartGameWindow extends Application {
	
	private Label playerNameLabel;
	private Stage primaryStage;
	private ComboBox<String> CityComboBox;
	private ComboBox<String> MapComboBox;
	private ImageView mapImage;
	private final Font f =Font.loadFont(getClass().getResourceAsStream("/res/Styles/gamecuben.TTF"), 12);
	
	private GridPane form;
	
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		BorderPane layout = new BorderPane();
		BackgroundImage bgI = new BackgroundImage(new Image(getClass().getResourceAsStream("/res/background.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true ));
		layout.setBackground(new Background(bgI));
        primaryStage.setResizable(false);
        Scene scene = new Scene(layout, 800,435);
    	scene.getStylesheets().add("res/Styles/StartGameStyle.css");
    	
        form = generateCenterForm();
        form.setAlignment(Pos.CENTER);
        VBox review = generateRight();
        HBox buttons = generateBottom();
        layout.setCenter(form);
        layout.setRight(review);
        layout.setBottom(buttons);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Game of States");
        primaryStage.show();	
	}
	
	private GridPane generateCenterForm(){
		//The main part
        GridPane form = new GridPane();
        form.setHgap(10);
        form.setVgap(25);
        Label nameLabel = new Label("Name:");
        Label MapLabel = new Label("Map:");
        Label CityLabel = new Label("City:");
        form.add(nameLabel, 0, 0);
        form.add(MapLabel, 0, 1);
        form.add(CityLabel, 0, 2);
        TextField nameTF = new TextField();
        //change the value of the label with the name
        nameTF.textProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> observable,
					String oldValue, String newValue) {
				playerNameLabel.setText("Your name: \n" + "Lord "+ nameTF.getText());
			}
		});
        MapComboBox = new ComboBox<String>();
        MapComboBox.setPrefSize(150, 20);
        MapComboBox.getItems().addAll("Europe", "World");
        MapComboBox.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				mapImage.setImage(new Image(getClass().getResourceAsStream("/res/"+MapComboBox.getSelectionModel().getSelectedItem()+"Map.png")));
				setCityComboItems(MapComboBox.getSelectionModel().getSelectedItem());		
				
			}        	
        });
        CityComboBox = new ComboBox<String>();
        CityComboBox.setPrefSize(150, 20);
        form.add(nameTF, 1, 0);
        form.add(MapComboBox, 1, 1);
        form.add(CityComboBox, 1, 2);
        
        return form;
	}
	
	private VBox generateRight(){
		//dynamic view that should update from the center data
		VBox east = new VBox(10);
		Label mapLabel = new Label("Map:");
		//mapImage will dynamically update from the combobox
		mapImage = new ImageView();
		playerNameLabel = new Label("Your name: \n" + "Lord ");
		mapImage.setFitWidth(150);
		mapImage.setFitHeight(220);
		CityStatsView csv = new CityStatsView();
		
		east.getChildren().addAll(mapLabel, mapImage, playerNameLabel, csv);
		return east;
	}
	
	private HBox generateBottom(){
		//Start and exit buttons
		HBox buttonGroup = new HBox(5);
		buttonGroup.setAlignment(Pos.CENTER);
		Button startButton = new Button("Start");
		startButton.setOnAction(new StartGameHandler(primaryStage, CityComboBox, MapComboBox));
		Button exitButton = new Button("Exit");
		//exit on close
		exitButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.exit(1);
			}
		});
		
		buttonGroup.getChildren().addAll(startButton, exitButton);
		return buttonGroup;
	}
	
	public void run(String[] args){
		launch(args);
	}
	
	private void setCityComboItems(String map){
		CityComboBox.getItems().clear();
		if(map.equals("Europe")){
	        CityComboBox.getItems().addAll("UK", "Germany", "Bulgaria", "Spain");
		}
		else if(map.equals("World")){
	        CityComboBox.getItems().addAll("UK", "Germany", "Bulgaria", "Spain", "USA", "China");
		}
	}
	
}
