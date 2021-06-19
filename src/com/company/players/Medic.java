package com.company.players;

public class Medic extends Hero {

    private int healPoints;

    public Medic(int health, int damage, int healPoints) {
        super(health, damage, SuperUdar.HEAL);
        this.healPoints = healPoints;
    }

    public int getHealPoints() {
        return healPoints;
    }

    public void setHealPoints(int healPoints) {
        this.healPoints = healPoints;
    }

    @Override
    public void applySuperUdar(Boss boss, Hero[] heroes) {

        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i] != this && this.getHealth() > 0 && heroes[i].getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() + healPoints);
            }

        }
    }
}
