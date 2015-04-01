package View;

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
import Data.City;
import Data.State;

public class GameWindow extends BorderPane {
	
	private final Font buttonFont = Font.loadFont(getClass().getResourceAsStream("\\Styles\\gamecuben.TTF"), 12);
	
    private City selectedCity;
    
    public GameWindow(String townName){
        Model.Application.player = new State(townName,4,4,4,4);
        Model.Application.player.setGold(400);
        selectedCity = new City(Model.Application.player);
    	generateGUI();
    }
    
    private void generateGUI(){
       	Scene scene = new Scene(this, 800,700);
    	scene.getStylesheets().add(getClass().getResource("\\Styles\\button.css").toExternalForm());
    	
		Stage primaryStage = new Stage();	
        primaryStage.setScene(scene);
        primaryStage.show();


        Image image = new Image(getClass().getResource("..\\res\\EnglandMap.png").toExternalForm());
        
        ImageView map = new ImageView(image);
        map.setFitHeight(650);
        map.setFitWidth(800);
        this.setCenter(map);

        Button build = new Button();
        build.setText("Build");
        build.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
            	BuildingsView bp = new BuildingsView(selectedCity);
//                System.out.println(selectedCity);
//                Button source = (Button) event.getSource();
//                FlowPane bottomLayout = (FlowPane) source.getParent();
//                bottomLayout.getChildren().clear();
//
//
//                Button back = new Button("<- Back");
//                back.setOnAction(new BackHandler());
//                
//
//                Button barracks = new Button("Barracks");
//                barracks.setOnAction(new BuildHandler(selectedCity));
//                Button church = new Button("Church");
//                church.setOnAction(new BuildHandler(selectedCity));
//                Button hall = new Button("Hall");
//                hall.setOnAction(new BuildHandler(selectedCity));
//                Button market = new Button("Market");
//                market.setOnAction(new BuildHandler(selectedCity));
//
//                bottomLayout.getChildren().addAll(back, barracks, church, hall, market);

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
        this.setBottom(bottomLayout);
    }
    /**

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose base:");
        String townName = sc.nextLine();
        Model.Application.player = new State(townName,4,4,4,4);
        Model.Application.player.setGold(400);
        selectedCity = new City(Model.Application.player);

        BorderPane layout = new BorderPane();

        Scene scene = new Scene(this, 800,700);
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
            	BuildingsView bp = new BuildingsView(selectedCity);
//                System.out.println(selectedCity);
//                Button source = (Button) event.getSource();
//                FlowPane bottomLayout = (FlowPane) source.getParent();
//                bottomLayout.getChildren().clear();
//
//
//                Button back = new Button("<- Back");
//                back.setOnAction(new BackHandler());
//                
//
//                Button barracks = new Button("Barracks");
//                barracks.setOnAction(new BuildHandler(selectedCity));
//                Button church = new Button("Church");
//                church.setOnAction(new BuildHandler(selectedCity));
//                Button hall = new Button("Hall");
//                hall.setOnAction(new BuildHandler(selectedCity));
//                Button market = new Button("Market");
//                market.setOnAction(new BuildHandler(selectedCity));
//
//                bottomLayout.getChildren().addAll(back, barracks, church, hall, market);

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
    */

//    public void run(String[] args){
//        launch(args);
//    }

}
