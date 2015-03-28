package Data;

public class State {
	
	private int military, culture, faith, economy;
	private String name;
	
	public State(String name, int mil, int cul, int fai, int eco){
		this.name = name;
		military = mil; culture = cul;	faith = fai; economy = eco;
	}
	
	public void fight(State other){
		
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
	
	public String toString(){
		return name;
	}

}
