package Data;

import Data.Buildings.Building;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;

public class City {

    private ArrayList<Building> buildings;
    private State owner;
    
    public City(State ownerState){
    	owner = ownerState;
    	buildings = new ArrayList<Building>();
    }
    
    public void build(Building building){
    	if(owner.isThereSufficientGold(building.getPotentialCost())){
	    	if(buildings.contains(building)){
	    		System.out.println(building + " upgraded successfully to " + (building.getLevel()+1) + " !It costed " + building.getCost() + " gold");
	    	}
	    	else{
	    		System.out.println(building + " constructed! It costed "+ building.getCost()+ " gold");
	    		buildings.add(building);
	    	}
	    int gold = this.getGold();
    	owner.setGold(gold - building.getCost());
	    building.upgrade();
    	}
    	else{
            Stage dialog = new Stage();
            dialog.initStyle(StageStyle.UTILITY);
            VBox layout = new VBox();
            layout.getChildren().addAll(new Label("Not enough minerals"));
            Scene scene = new Scene(layout,250, 250);
            dialog.setScene(scene);
            dialog.show();

        }
    }

    public void trainUnit(Unit unit){
    	int gold = owner.getGold();
    	for(Building built : buildings){
    		if(built.getUnit().equals(unit)){
    			int goldSpent = unit.getCost();
    			owner.setGold(gold - goldSpent);
    			System.out.println(goldSpent + " gold spent");
    			System.out.println("Unit: "+unit+" trained successfully!");
    			return;
    		}
    	}
    	System.out.println("The building is not built yet.");
    }
    
    public int getGold(){
    	return owner.getGold();
    }
    
	public ArrayList<Building> getBuildings(){
        return buildings;
    }

}
