package View;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Created by Rosen on 29/03/2015.
 */
public class GameWindow extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane layout = new BorderPane();

        Scene scene = new Scene(layout, 800,600);

        primaryStage.setScene(scene);
        primaryStage.show();


        Image image = new Image(getClass().getResource("..\\res\\uk_map.gif").toExternalForm());
        ImageView map = new ImageView(image);
        layout.setCenter(map);

        Button hey = new Button();
        hey.setText("click me");

        FlowPane bottomLayout = new FlowPane();
        bottomLayout.setAlignment(Pos.CENTER);
        bottomLayout.getChildren().add(hey);
        layout.setBottom(bottomLayout);

    }


    public static void main(String[] args){
        launch(args);
    }
}
