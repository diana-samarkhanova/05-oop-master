package com.epam.knight.model.ammunition.weapon;


public class Sword implements Weapon {
    private final int damage;
    private final int weight;
    private final int cost;

    public Sword(int damage, int weight, int cost) {
        this.damage = damage;
        this.weight = weight;
        this.cost = cost;
    }

    @Override
    public String toString() {

        return "Sword{damage=" + damage + ", weight=" + weight + ", cost=" + cost + "}";
    }

    public int getDamage() {
        return damage;
    }

    public int getWeight() {
        return weight;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public int damage() {
        return 0;
    }
}
