package Data.Buildings;

public class Building {
	
	private int level;
	private String name;
	
	public Building(String name){
		this.name = name;
		level = 0;
	}
	
	public int getLevel(){
		return level;
	}
	
	public void upgrade(){
		level++;
	}
	
	public String toString(){
		return name + " Level "+ level;
	}

}
