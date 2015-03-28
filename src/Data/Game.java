package Data;


public class Game {
	
	private State home;
	
	public Game(State s){
		home = s;
	}
	
	public State getHome(){
		return home;
	}
	
}
