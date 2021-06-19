package com.company.players;

public abstract class Hero extends GameEntity implements HavingSuperUdar{

    private SuperUdar udar;

    public SuperUdar getUdar() {
        return udar;
    }

    public Hero(int health, int damage, SuperUdar udar) {
        super(health, damage);
        this.udar=udar;
    }

}
