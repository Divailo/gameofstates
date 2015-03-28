package Data.Enums;

import java.util.ArrayList;

import Data.Unit;

public enum Buildings {
	
	BARRACKS(new Unit(Units.WARRIOR), 100), CHURCH(new Unit(Units.MISSIONARY), 100), HALL(new Unit(Units.POPSTAR), 100), MARKET(new Unit(Units.MERCHANT), 100);
	
	private final int cost;
	private final Unit unit;
	public static final ArrayList<String> allBuildings = new ArrayList<String>();
	
	Buildings(Unit u, int cost){
		unit = u;
		this.cost = cost;
	}
	
	public Unit unit(){
		return unit;
	}
	
	public int cost(){
		return cost;
	}
}
