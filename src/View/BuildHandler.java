package View;

import Data.Buildings.Building;
import Data.City;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;


/**
 * Created by Rosen on 29/03/2015.
 */
public class BuildHandler implements EventHandler<ActionEvent> {
    City city;

    public BuildHandler(City city){
        this.city = city;
    }


    @Override
    public void handle(ActionEvent event) {
        Button source = (Button) event.getSource();
        for(Building b : city.getBuildings()){
            if(b.toString().toLowerCase().equals(source.getText().toLowerCase())){
                city.build(b);
            }
        }
//        System.out.println(city.getGold());
        System.out.println(city.printBuildings());
    }
}
