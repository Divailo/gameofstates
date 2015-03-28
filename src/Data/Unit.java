package Data;

import java.util.Random;

public class Unit {
    private int power;
    private String name;



    public Unit(String name){
        this.name = name;
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


    public static void main(String[] args){
        Unit unit = new Unit("pesho");
        unit.fight(new Unit("gosho"));
    }
}
