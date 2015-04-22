package Data;

public class State {
	
	private int military, culture, faith, economy, gold;
	private String name;


	public State(String name, int mil, int cul, int fai, int eco){
		this.name = name;
		military = mil; culture = cul;	faith = fai; economy = eco;
		gold = 200;
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
	
	public int getGold(){
		return gold;
	}

	public String toString(){
		return name;
	}

}
