package Data;

import java.util.Random;

import Data.Enums.Units;


public class Unit {

    private int power, cost;
    private String name;

    public Unit(Units unit){
        this.name = unit.name();
        this.cost = unit.cost();
        power = 10;
    }
    
    public void fight(Object otherObject){
        if(otherObject instanceof Unit){
            Unit otherUnit = (Unit) otherObject;
            Random random = new Random();
            int powerOne = random.nextInt(this.power);
            int powerTwo = random.nextInt(otherUnit.power);
            if(powerOne>=powerTwo){
                System.out.println(name + " wins");
            }
            else{
                System.out.println(otherUnit.name + " wins");
            }
        }
    }
    
    public boolean equals(Unit otherUnit){
    	return this.getName().equals(otherUnit.getName());
    }
    
    public String getName(){
    	return name;
    }
    
    public int getCost(){
    	return cost;
    }
    
    public String toString(){
    	return name;
    }
    
}
