package com.company.general;

import com.company.players.*;

import java.util.Random;

public class RPG_Game {
    public static Random random =new Random();

    public static void start() {
        Boss boss = new Boss(1000, 50);
        Warrior warrior = new Warrior(150, 10 );
        Tank tank = new Tank(150, 60);
        Magic magic = new Magic(150, 10);
        Medic medic = new Medic(200, 5, 15);
        Medic youngMedic = new Medic(200, 8, 10);

        Hero[] heroes = {warrior, tank, magic, medic, youngMedic};

        printStatistic(boss, heroes);

        while (!isFinished(boss, heroes)) {
            round(boss, heroes);
        }

    }

    private static void printStatistic(Boss boss, Hero[] heroes) {
        System.out.println("____________________________");
        System.out.println("Boss health: " + boss.getHealth() + " ,damage: [" + boss.getDamage() + "]");
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getClass().getSimpleName() + " health: "
                    + heroes[i].getHealth() + " ,damage: [" + heroes[i].getDamage() + "]");
        }
        System.out.println("____________________________");

    }

    private static void round(Boss boss, Hero[] heroes) {
        bossHit(boss, heroes);
        heroesHit(boss, heroes);
        heroesApplySuperAbilities(boss, heroes);
        printStatistic(boss, heroes);
    }

    private static boolean isFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!");
            return true;
        }
        boolean allHeroesDied = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDied = false;
                break;
            }
        }
        if (allHeroesDied) {
            System.out.println("Boss won!");
        }
        return allHeroesDied;
    }

    private static void bossHit(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }
        }
    }

    private static void heroesHit(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (boss.getHealth() > 0 && heroes[i].getHealth() > 0 &&
                    SuperUdar.CRITICAL_DAMAGE != heroes[i].getUdar()) {
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
            }

        }
    }

    private static void heroesApplySuperAbilities(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            heroes[i].applySuperUdar(boss, heroes);

        }
    }

}
