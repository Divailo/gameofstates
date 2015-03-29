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

                Button back = new Button("< Back");
                back.setOnAction(new BackHandler());

                Button barracks = new Button("Barracks");
                barracks.setOnAction(new BuildHandler(GameWindow.selectedCity));
                Button church = new Button("Church");
                church.setOnAction(new BuildHandler(GameWindow.selectedCity));
                Button hall = new Button("Hall");
                hall.setOnAction(new BuildHandler(GameWindow.selectedCity));
                Button market = new Button("Market");
                market.setOnAction(new BuildHandler(GameWindow.selectedCity));

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
