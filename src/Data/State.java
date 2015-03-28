package Data;

import java.util.ArrayList;

import Data.Buildings.Building;

public class State {
	
	private int military, culture, faith, economy, gold;
	private String name;
    private ArrayList<Building> buildings;
	
	public State(String name, int mil, int cul, int fai, int eco){
		this.name = name;
        buildings = new ArrayList<Building>();
		military = mil; culture = cul;	faith = fai; economy = eco;
		gold = 200;
	}

    public void build(Building building){
    	if(isThereSufficientGold(building.getPotentialCost())){
	    	if(buildings.contains(building)){
	    		System.out.println(building + " upgraded successfully to " + (building.getLevel()+1) + " !It costed " + building.getCost() + " gold");
	    	}
	    	else{
	    		System.out.println(building + " constructed! It costed "+ building.getCost()+ " gold");
	    		buildings.add(building);
	    	}
    	gold -= building.getCost();
	    building.upgrade();
    	}
    	else{
    		System.out.println("Not enough gold");
    	}
    }

    public void trainUnit(Unit unit){
    	for(Building built : buildings){
    		if(built.getUnit().equals(unit)){
    			int goldSpent = unit.getCost();
    			gold -= goldSpent;
    			System.out.println(goldSpent + " gold spent");
    			System.out.println("Unit: "+unit+" trained successfully!");
    			return;
    		}
    	}
    	System.out.println("The building is not built yet.");
    }
    
    public boolean isThereSufficientGold(int cost){
    	return (gold - cost) >= 0;
    }
    
    public void setGold(int gold){
    	this.gold = gold;
    }


	//getting shit methods
	public String getName(){
		return name;
	}
	
	public int getMilitary(){
		return military;
	}
	
	public int getCulture(){
		return culture;
	}
	
	public int getFaith(){
		return faith;
	}
	
	public int getEconomy(){
		return economy;
	}

	public ArrayList<Building> getBuildings(){
        return buildings;
    }
	
	public int getGold(){
		return gold;
	}

	public String toString(){
		return name;
	}

}
