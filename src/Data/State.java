package Data;

public class State {
	
	private int military, culture, faith, economy;
	
	public State(int mil, int cul, int fai, int eco){
		military = mil;	culture = cul;	faith = fai;	economy = eco;
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

}
