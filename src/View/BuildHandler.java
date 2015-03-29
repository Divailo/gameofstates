package View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import Data.City;
import Data.Buildings.Building;


/**
 * Created by Rosen on 29/03/2015.
 */
public class BuildHandler implements EventHandler<ActionEvent> {
	
    private City city;
    private String buildingName;
    private BuildingLabel label;
    private Stage root;
    
    public BuildHandler(Stage root, City city, BuildingLabel building){
        this.city = city;
        this.root = root;
        label = building;
        buildingName = building.getBuilding().toString();
    }    


    @Override
    public void handle(ActionEvent event) {
        for(Building b : city.getBuildings()){
            if(b.toString().toLowerCase().equals(buildingName.toLowerCase())){
                city.build(b);
                label.updateLabel();
                root.close();
            }
        }
//        System.out.println(city.getGold());
        System.out.println(city.printBuildings());
    }
}
