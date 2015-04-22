package Model;

import com.esri.runtime.ArcGISRuntime;

import Data.State;
import View.StartGameWindow;

public class Application {

    public static State player;
	public static void main(String[] args) {



//		System.out.println("Choose base:");
//		Scanner sc = new Scanner(System.in);
//		String townName = sc.nextLine();
//		State homeTown = new State(townName, 2, 2, 2, 2);
//		homeTown.setGold(300);
//        City city = new City(homeTown);
//		Game g = new Game(city); // new game test
//        System.out.println(city);
//        GameWindow gw = new GameWindow();
//        gw.run(args);
		
		
        ArcGISRuntime.setClientID("Vnh6fG7jLeTAYeeE");
		//nakraq tree da e new Game(), koito da loadwa loginWindow
        StartGameWindow lw = new StartGameWindow();
        lw.run(args);

//		System.out.println("Your home is: " + g.getHome());
//		System.out.println("Your gold: " + homeTown.getGold());
//		Building b = new Building(Buildings.CHURCH);
//		city.build(b);
//		System.out.println("Your buildings: " + city.getBuildings());
//		city.trainUnit(new Unit(Units.MISSIONARY));
//		System.out.println("Your gold: " + homeTown.getGold());
//		city.build(b);
//		System.out.println("Your gold: " + homeTown.getGold());
//		sc.close();
	}

}
