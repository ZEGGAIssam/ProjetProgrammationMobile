package com.github.issamzeggai.listechampions.Modele;

import java.io.Serializable;

public class Stats implements Serializable {
    private float hp;
    private float mp;
    private float movespeed;
    private float armor;
    private float attackdamage;

    public float getMovespeed() {
        return movespeed;
    }

    public float getArmor() {
        return armor;
    }

    public float getAttackdamage() {
        return attackdamage;
    }

    public float getAttackrange() {
        return attackrange;
    }

    private float attackrange;



    public float getHp() {
        return hp;
    }

    public float getMp() {
        return mp;
    }
}