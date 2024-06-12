package com.epam.knight.controller;

import com.epam.knight.model.Knight;
import com.epam.knight.model.ammunition.armor.Helmet;
import com.epam.knight.model.ammunition.weapon.Sword;

public class KnightGenerator {

    /**
     * Use it to quickly generate knight
     * @return knight
     */
    public static Knight generateKnight() {
        Knight knight = new Knight();
        Helmet helmet = new Helmet(30, 10, 20);
        Sword sword = new Sword(10, 20, 30);
        knight.equip(helmet);
        knight.equip(sword);
        return knight;
    }

}
