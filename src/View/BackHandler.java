package View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;


/**
 * Created by Rosen on 29/03/2015.
 */
public class BackHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent event) {
        Button source = (Button) event.getSource();
        FlowPane bottomLayout = (FlowPane) source.getParent();
        bottomLayout.getChildren().clear();

        Button build = new Button();
        build.setText("Build");
        build.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                Button[] buildButtons = new Button[5];
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
        train.setText("Train");

        Button move = new Button();
        move.setText("Move unit");
        Button selectCity = new Button("Select City");
        Button selectUnit = new Button("Select Unit");
        Button endTurn = new Button("End Turn");
        bottomLayout.getChildren().addAll(build,train,move,selectCity,selectUnit, endTurn);
    }
}
