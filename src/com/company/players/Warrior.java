package com.company.players;
import  java.util.Random;
import com.company.general.RPG_Game;

public class Warrior extends Hero {



    public Warrior(int health, int damage) {
        super(health, damage, SuperUdar.CRITICAL_DAMAGE);

    }


    @Override
    public void applySuperUdar(Boss boss, Hero[] heroes) {

        Random warr = new Random();
        int x = warr.nextInt(2) +1;
        this.setDamage(getDamage() * x);



    }
}

