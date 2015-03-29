package View;

import Data.Buildings.Building;
import Data.City;
import Data.Enums.Buildings;
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
        String name = source.getText().toUpperCase();
        Buildings enumValue = Buildings.valueOf(name);
        Building building = new Building(enumValue);
        System.out.println(city.getGold());
        city.build(building);
    }
}
