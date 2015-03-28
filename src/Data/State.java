package Data;

import Data.Buildings.Building;

import java.util.ArrayList;

public class State {
	
	private int military, culture, faith, economy;
	private String name;
    private ArrayList<Building> buildings;
	
	public State(String name, int mil, int cul, int fai, int eco){
		this.name = name;
        buildings = new ArrayList<Building>();
		military = mil; culture = cul;	faith = fai; economy = eco;
	}
	
	public void fight(State other){
		
	}

    public void build(Building building){
        buildings.add(building);
    }

    public void trainUnit(Unit unit){

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

	public String toString(){
		return name;
	}


    public static void main(String[] args){
        State germany = new State("Germany", 1,1,1,1);
        System.out.println(germany.getBuildings());
        germany.build(new Building("Barracks"));
        System.out.println(germany.getBuildings());
    }

}
