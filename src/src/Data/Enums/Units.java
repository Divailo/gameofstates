package Data.Enums;

public enum Units {
	
	WARRIOR(50), POPSTAR(50), MISSIONARY(50), MERCHANT(50);
	
	private final int cost;
	
	Units(int cost){
		this.cost = cost;
	}
	
	public int cost(){
		return cost;
	}

}
