package com.company.players;

public class Magic extends Hero {

    private static int multiplyDamage = 5;

    public Magic(int health, int damage) {
        super(health, damage, SuperUdar.BOOST);

    }

    @Override
    public void applySuperUdar(Boss boss, Hero[] heroes) {
        if (this.getHealth() < 0) {
            this.setDamage(0);
        } else {
            for (int i = 0; i < heroes.length; i++) {
                if (heroes[i].getHealth() > 0) {
                    heroes[i].setDamage(heroes[i].getDamage() + multiplyDamage);
                }
            }
        }
    }
}
