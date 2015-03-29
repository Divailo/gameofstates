package View;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


/**
 * Created by Rosen on 29/03/2015.
 */
public class GameWindow extends Application {
	
	private final Font buttonFont = Font.loadFont(getClass().getResourceAsStream("\\Styles\\gamecuben.TTF"), 12);


    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane layout = new BorderPane();

        Scene scene = new Scene(layout, 800,700);
    	scene.getStylesheets().add(getClass().getResource("\\Styles\\button.css").toExternalForm());
    	
        primaryStage.setScene(scene);
        primaryStage.show();


        Image image = new Image(getClass().getResource("..\\res\\EnglandMap.png").toExternalForm());
        ImageView map = new ImageView(image);
        map.setFitHeight(650);
        map.setFitWidth(800);
        layout.setCenter(map);

        Button build = new Button();
        build.setText("Build");
        build.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                Button back = new Button("<- Back");
                back.setOnAction(new BackHandler());
                

                Button barracks = new Button("Barracks");
                Button church = new Button("Church");
                Button hall = new Button("Hall");
                Button market = new Button("Market");
                
                Button source = (Button) event.getSource();
                FlowPane bottomLayout = (FlowPane) source.getParent();
                bottomLayout.getChildren().clear();
                bottomLayout.getChildren().addAll(back, barracks, church, hall, market);

            }
        });


        Button train = new Button();
        train.setText("Train"); // Train Listener
//        train.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                Button source = (Button) event.getSource();
//                FlowPane bottomLayout = (FlowPane) source.getParent();
//                bottomLayout.getChildren().clear();
//
//                Button back = new Button("<- Back");
//                back.setOnAction(new BackHandler);
//                bottomLayout.getChildren().add(back);
//                Button[] trainButtons = new Button[state.getSelectedCity.getBuildings.size()];
//                for(Building b : state.getSelectedCity.getBuildings){
//                    if(b.getLevel()>0){
//                        Button unit = new Button(b.getUnit().getName());
//                        bottomLayout.getChildren().add(unit);
//                    }
//                }
//            }
//        });


        Button move = new Button();
        move.setText("Move unit");

        Button selectCity = new Button("Select City");
        Button selectUnit = new Button("Select Unit");
        Button endTurn = new Button("End Turn");
        

        FlowPane bottomLayout = new FlowPane();
        bottomLayout.setAlignment(Pos.CENTER);
        bottomLayout.getChildren().addAll(build, train, move, selectCity,selectUnit,endTurn);
        layout.setBottom(bottomLayout);

    }


    public static void main(String[] args){
        launch(args);
    }
}
