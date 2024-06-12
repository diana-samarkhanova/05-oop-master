package com.epam.knight.model;
import com.epam.knight.model.ammunition.Ammunition;
import com.epam.knight.model.ammunition.armor.Armor;
import com.epam.knight.model.ammunition.weapon.Weapon;
import java.util.Arrays;
import java.util.Comparator;

public class Knight {
    private static final SortByCost sortCost = new SortByCost();
    private static final SortByWeight sortWeight = new SortByWeight();

    private Ammunition[] ammunition;


    public Ammunition[] getAmmunition() {

        return ammunition;
    }

    /**
     * Add new ammunition element to knight
     * @param element that should be equipped to the knight
     */

    public Knight() {
        ammunition = new Ammunition[0];
    }

    public void equip(Ammunition element) {
        ammunition = Arrays.copyOf(ammunition, ammunition.length + 1);
        ammunition[ammunition.length - 1] = element;
    }

    public int calculateAmmunitionWeight() {
        return Arrays.stream(ammunition).mapToInt(Ammunition::getWeight).sum();
    }

    public int calculateAmmunitionCost() {
        return Arrays.stream(ammunition).mapToInt(Ammunition::getCost).sum();
    }

    public int calculateAmmunitionDamage() {
        return Arrays.stream(ammunition)
                .filter(a -> a instanceof Weapon)
                .mapToInt(a -> ((Weapon) a).getDamage())
                .sum();
    }

    public int calculateAmmunitionProtection() {
        return Arrays.stream(ammunition)
                .filter(a -> a instanceof Armor)
                .mapToInt(a -> ((Armor) a).getProtection())
                .sum();
    }
    public Ammunition[] sortByCost() {
        Ammunition[] sortObjects = ammunition.clone();
        Arrays.sort(sortObjects, sortCost);
        return sortObjects;
    }

    private static class SortByCost implements Comparator<Ammunition> {
        @Override
        public int compare(Ammunition object1, Ammunition object2) {
            return Integer.compare(object1.getCost(), object2.getCost());
        }
    }

    public Ammunition[] sortByWeight() {
        Ammunition[] sortAmmunition = ammunition.clone();
        Arrays.sort(sortAmmunition, sortWeight);
        return sortAmmunition;
    }

    private static class SortByWeight implements Comparator<Ammunition> {
        @Override
        public int compare(Ammunition object1, Ammunition object2) {
            return Integer.compare(object1.getWeight(), object2.getWeight());
        }
    }

    public Ammunition[] searchByCost(int minCost, int maxCost) {
        return Arrays.stream(ammunition)
                .filter(a -> a.getCost() >= minCost && a.getCost() <= maxCost)
                .toArray(Ammunition[]::new);
    }

    public Ammunition[] searchByWeight(int minWeight, int maxWeight) {
        return Arrays.stream(ammunition)
                .filter(a -> a.getWeight() >= minWeight && a.getWeight() <= maxWeight)
                .toArray(Ammunition[]::new);
    }

}