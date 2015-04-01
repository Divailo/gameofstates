package View;

import javafx.scene.control.Label;
import Data.Buildings.Building;

public class BuildingLabel extends Label {
	
	private Building building;
	
	public BuildingLabel(Building b){
		super(b.toString() + " ( Level " + b.getLevel() + " )");
		building = b;
	}
	
	public void updateLabel(){
//		System.out.println(building.getLevel());
		System.out.println(building);
		this.setText(building.toString() + " ( Level " + building.getLevel() + " )");
	}
	
	public Building getBuilding(){
		return building;
	}

}
