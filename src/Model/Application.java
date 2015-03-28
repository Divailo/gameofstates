package Model;

import java.util.Scanner;

import Data.Game;
import Data.State;
import Data.Unit;
import Data.Buildings.Building;
import Data.Enums.Buildings;
import Data.Enums.Units;

public class Application {

	public static void main(String[] args) {
		System.out.println("Choose base:");
		Scanner sc = new Scanner(System.in);
		String townName = sc.nextLine();
		State homeTown = new State(townName, 2, 2, 2, 2);
		homeTown.setGold(300);
		Game g = new Game(homeTown);
		System.out.println("Your home is: " + g.getHome());
		System.out.println("Your gold: " + homeTown.getGold());
		Building b = new Building(Buildings.CHURCH);
		homeTown.build(b);
		System.out.println("Your buildings: " + homeTown.getBuildings());
		homeTown.trainUnit(new Unit(Units.MISSIONARY));
		System.out.println("Your gold: " + homeTown.getGold());
		homeTown.build(b);
		System.out.println("Your gold: " + homeTown.getGold());
		sc.close();
	}

}
