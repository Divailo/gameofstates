package View;

import Data.State;
import javafx.event.EventHandler;

import java.awt.event.ActionEvent;

/**
 * Created by Rosen on 29/03/2015.
 */
public class BuildHandler implements EventHandler<ActionEvent> {
    State state;
    City city;
    public BuildHandler(State state, City city){
        this.state = state; this.city = city;
    }


    @Override
    public void handle(ActionEvent event) {
        
    }
}
