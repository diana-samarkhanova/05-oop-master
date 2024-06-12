package com.epam.knight.view;
import com.epam.knight.controller.Controller;
import com.epam.knight.model.Knight;
import com.epam.knight.model.ammunition.Ammunition;
import com.epam.knight.model.ammunition.armor.Helmet;
import com.epam.knight.model.ammunition.weapon.Sword;

import java.util.Scanner;

public class ConsoleView {
    private final Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    public void showMenu(Knight knight, Controller controller) {
        int choice;
        do {
            System.out.println("\nMain menu:");
            System.out.println("1. Print knight stats");
            System.out.println("2. Show ammunition");
            System.out.println("3. Equip ammunition");
            System.out.println("4. Sort ammunition");
            System.out.println("5. Search ammunition");
            System.out.println("6. Exit");
            System.out.print("Choose option: \n");

            choice = controller.getNumberFromUser(1, 6);

            switch (choice) {
                case 1:
                    printKnightStats(knight);
                    break;
                case 2:
                    showAmmunition(knight.getAmmunition());
                    break;
                case 3:
                    equipAmmunition(knight, controller);
                    break;
                case 4:
                    sortAmmunition(knight, controller);
                    break;
                case 5:
                    searchAmmunition(knight, controller);
                    break;
                case 6:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 6);
    }

    private void printKnightStats(Knight knight) {
        System.out.println("Ammunition cost: " + knight.calculateAmmunitionCost());
        System.out.println("Ammunition weight: " + knight.calculateAmmunitionWeight());
        System.out.println("Ammunition damage: " + knight.calculateAmmunitionDamage());
        System.out.println("Ammunition protection: " + knight.calculateAmmunitionProtection());
    }
    private void showAmmunition(Ammunition[] ammunition) {
        if (ammunition.length == 0) {
            System.out.println("Knight has no ammunition equipped.");
        } else {
            for (Ammunition item : ammunition) {
                System.out.println(item);
            }
        }
    }
    private Sword addSword(Controller controller) {
        System.out.print("Input sword weight: ");
        int weight = scanner.nextInt();
        System.out.print("Input sword cost: ");
        int cost = scanner.nextInt();
        System.out.print("Input sword damage: ");
        int damage = scanner.nextInt();
        scanner.nextLine();
        return new Sword(damage, weight, cost);

    }
    private Helmet addHelmet(Controller controller) {
        System.out.println("Input helmet weight");
        int weight = scanner.nextInt();
        System.out.println("Input helmet cost");
        int cost = scanner.nextInt();
        System.out.println("Input helmet damage");
        int damage = scanner.nextInt();
        scanner.nextLine();
        return new Helmet(damage, weight, cost);
    }
    private void equipAmmunition(Knight knight, Controller controller) {
        System.out.println("\nWhat kind of ammunition do you want to equip?");
        System.out.println("1. Sword");
        System.out.println("2. Helmet");
        System.out.print("Choose option: \n");

        int choiceEquip = controller.getNumberFromUser(1, 2);
        switch (choiceEquip) {
            case 1:
                Sword newSword = addSword(controller);
                knight.equip(newSword);
                break;
            case 2:
                Helmet newHelmet = addHelmet(controller);
                knight.equip(newHelmet);
                break;
            default:
                System.out.println("Invalid option.");
        }
    }
    private void sortAmmunition(Knight knight, Controller controller) {
        System.out.println("\nChoose sort type:");
        System.out.println("1. Cost");
        System.out.println("2. Weight");
        System.out.print("Choose option: \n");

        int sortChoice = controller.getNumberFromUser(1, 2);

        if(sortChoice==1){
            showAmmunitionOnScreen(knight.sortByCost());
        } else if (sortChoice == 2) {
            showAmmunitionOnScreen(knight.sortByWeight());
        }
    }
    private void searchAmmunition(Knight knight, Controller controller) {
        System.out.println("\nChoose search field:");
        System.out.println("1. Cost");
        System.out.println("2. Weight");
        System.out.print("Choose option: \n");

        int searchChoice = controller.getNumberFromUser(1, 2);

        if (searchChoice == 1){
            System.out.print("Input minimum cost: ");
            int minCost = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Input maximum cost: ");
            int maxCost = scanner.nextInt();
            scanner.nextLine();

            showAmmunitionOnScreen(knight.searchByCost(minCost, maxCost));
        } else if (searchChoice==2) {
            System.out.print("Input minimum weight: ");
            int minWeight = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Input maximum weight: ");
            int maxWeight = scanner.nextInt();
            scanner.nextLine();

            showAmmunitionOnScreen(knight.searchByWeight(minWeight, maxWeight));

        } else{
            System.out.println("No ammunition found in the specified range.");
        }

    }


    private void showAmmunitionOnScreen(Ammunition[] ammunition) {
        if (ammunition == null || ammunition.length == 0) {
            System.out.println("Ammunition not found");
        } else {
            for (Ammunition oneAmmunition : ammunition) {
                System.out.println(oneAmmunition);
            }
        }
    }

}
