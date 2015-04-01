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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import Controller.StartGameHandler;

public class LoginWindow extends Application {
	
	private Label playerNameLabel;
	private Stage primaryStage;
	private ComboBox<String> CityComboBox;
	private final Font buttonFont = Font.loadFont(getClass().getResourceAsStream("\\Styles\\gamecuben.TTF"), 12);
	
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		BorderPane layout = new BorderPane();
        Scene scene = new Scene(layout, 800,435);
    	scene.getStylesheets().add(getClass().getResource("\\Styles\\button.css").toExternalForm());
        GridPane form = generateCenterForm();
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
        ComboBox<String> MapComboBox = new ComboBox<String>();
        MapComboBox.setPrefSize(150, 20);
        MapComboBox.getItems().addAll("England");
        CityComboBox = new ComboBox<String>();
        CityComboBox.setPrefSize(150, 20);
        CityComboBox.getItems().addAll("London", "Manchester", "Birmingham");
        form.add(nameTF, 1, 0);
        form.add(MapComboBox, 1, 1);
        form.add(CityComboBox, 1, 2);
        
        return form;
	}
	
	private VBox generateRight(){
		//dynamic view that should update from the center data
		VBox east = new VBox(10);
		Label mapLabel = new Label("Map:");
		Image mapImage = new Image(getClass().getResource("..\\res\\EnglandMap.png").toExternalForm());
		ImageView actualImage = new ImageView(mapImage);
		playerNameLabel = new Label("Your name: \n" + "Lord ");
		actualImage.setFitWidth(150);
		actualImage.setFitHeight(220);
		CityStatsView csv = new CityStatsView();
		
		east.getChildren().addAll(mapLabel, actualImage, playerNameLabel, csv);
		return east;
	}
	
	private HBox generateBottom(){
		//Start and exit buttons
		HBox buttonGroup = new HBox(5);
		buttonGroup.setAlignment(Pos.CENTER);
		Button startButton = new Button("Start");
		startButton.setOnAction(new StartGameHandler(primaryStage, CityComboBox));
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
	
    public static void main(String[] args){
        launch(args);
    }


}
