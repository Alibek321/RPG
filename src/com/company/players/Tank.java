package com.company.players;

public class Tank extends Hero {


    public Tank(int health, int damage) {
        super(health, damage, SuperUdar.SAVA_DAMAGE_AND_REVERT);
    }

    @Override
    public void applySuperUdar(Boss boss, Hero[] heroes) {

    }
}
