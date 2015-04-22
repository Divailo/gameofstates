package View;

import java.awt.BorderLayout;

import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Data.City;
import Data.State;

public class GameWindow extends BorderPane {
	
	private final Font buttonFont = Font.loadFont(getClass().getResourceAsStream("/res/Styles/gamecuben.TTF"), 12);
	
    private City selectedCity;
    private String selectedMap;
    private Map map;
    private Stage primaryStage;
    
    public GameWindow(String townName, String selectedMap){
        Model.Application.player = new State(townName,4,4,4,4);
        Model.Application.player.setGold(400);
        selectedCity = new City(Model.Application.player);
        this.selectedMap = selectedMap;
    	generateGUI();
    }
    
//    private BorderPane generateFXMap(){
//     	final FXMap jMap = new FXMap();
// 	    
// 	    // create the graphics layer to which the features will be added
// 	    final GraphicsLayer graphicsLayer = new GraphicsLayer();
// 	    jMap.getLayerList().add(graphicsLayer);
//
// 	    BorderPane bp = new BorderPane();
//    	bp.setCenter(jMap);
//	    try {
//		      // create an instance of the parser
//		      GeoJsonParser geoJsonParser = new GeoJsonParser();
//		      
//		      // provide the symbology for the features
//		      CompositeSymbol symbol = new CompositeSymbol();
//		      symbol.add(new SimpleFillSymbol(new Color(0, 255, 0, 70)));
//		      symbol.add(new SimpleLineSymbol(Color.BLACK, 2));
//		      geoJsonParser.setSymbol(symbol).setOutSpatialReference(jMap.getSpatialReference());
//		      
//		      // parse geojson data   
//		      File data = new File("src\\res\\countries.geo.json");
//		      List<Feature> features = geoJsonParser.parseFeatures(data);
//		      
//		      // add parsed features to a layer
//		      for (Feature f : features) {
//		       graphicsLayer.addGraphic(new Graphic(f.getGeometry(), f.getSymbol(), f.getAttributes()));
//		      }
//		    } catch (Exception ex) {
//		      throw new RuntimeException(ex);
//		    }
//    	
//    	return bp;
//    }
    
    private void generateGUI() {
       	Scene scene = new Scene(this, 800,700);
    	scene.getStylesheets().add("res/Styles/GameWindowStyle.css");
    	
		primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.show();


        final SwingNode swingNode = new SwingNode();
        createSwingContent(swingNode);
        swingNode.resize(800, 700);
//        this.setCenter(map.getMap());
        this.setCenter(swingNode);
        
        
//        Image image = new Image(new File("src\\res\\EnglandMap.png").toURI().toURL().toExternalForm());
//        
//        ImageView map = new ImageView(image);
//        map.setFitHeight(650);
//        map.setFitWidth(800);
//        this.setCenter(map);

        Button build = new Button();
        build.setText("Build");
        build.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
            	BuildingsView bp = new BuildingsView(selectedCity);
            }
        });


        Button train = new Button();
        train.setText("Train"); 
        train.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
            	TrainUnitsView tuv = new TrainUnitsView(selectedCity);
            }
        });

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
    
    private void createSwingContent(final SwingNode swingNode) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	map = new Map(primaryStage, selectedMap);
				JPanel appWindow = map.createWindow();
				appWindow.add(map.createUI(), BorderLayout.CENTER);
                swingNode.setContent(appWindow);

            }
        });
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
