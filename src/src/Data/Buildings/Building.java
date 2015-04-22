package Data.Buildings;

import Data.Unit;
import Data.Enums.Buildings;


public class Building {
	
	private int level, cost;
	private String name;
	private Unit unit;
	
	public Building(Buildings b){
		this.name = b.name();
		unit = b.unit();
		cost = b.cost();
		level = 0;
	}
	
	public void upgrade(){
		level++;
		cost += 50;
	}
	
	public int getPotentialCost(){
		return cost;
	}
	
	public Unit getUnit(){
		return unit;
	}
	
	public int getLevel(){
		return level;
	}
	
	public int getCost(){
		return cost;
	}
	
	public String toString(){
		return name;
	}
	
}
