package com.machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int water = 400;
        int milk = 540;
        int beans = 120;
        int money = 550;
        int disposableCups = 9;

        String action;

        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            action = scanner.nextLine();

            switch (action) {
                case "remaining":
                    System.out.printf("\nThe coffee machine has:\n"
                                    + "%d ml of water\n"
                                    + "%d ml of milk\n"
                                    + "%d g of coffee beans\n"
                                    + "%d disposable cups\n"
                                    + "$%d of money\n%n",
                            water,
                            milk,
                            beans,
                            disposableCups,
                            money
                    );
                    break;
                case "buy":
                    System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    String operation = scanner.nextLine();
                    if (operation.equals("1")) {
                        if (water - 250 < 0) {
                            System.out.println("Sorry, not enough water!\n");
                        } else if (beans - 16 < 0) {
                            System.out.println("Sorry, not enough beans!\n");
                        } else if (disposableCups - 1 < 0) {
                            System.out.println("Sorry, not enough disposable cups!\n");
                        } else {
                            System.out.println("I have enough resources, making you a coffee!\n");
                            water -= 250;
                            beans -= 16;
                            disposableCups -= 1;
                            money += 4;
                        }
                    } else if (operation.equals("2")) {
                        if (water - 350 < 0) {
                            System.out.println("Sorry, not enough water!\n");
                        } else if (milk - 75 < 0) {
                            System.out.println("Sorry, not enough milk!\n");
                        } else if (beans - 20 < 0) {
                            System.out.println("Sorry, not enough beans!\n");
                        } else if (disposableCups - 1 < 0) {
                            System.out.println("Sorry, not enough disposable cups!\n");
                        } else {
                            System.out.println("I have enough resources, making you a coffee!\n");
                            water -= 350;
                            milk -= 75;
                            beans -= 20;
                            disposableCups -= 1;
                            money += 7;
                        }
                    } else if (operation.equals("3")) {
                        if (water - 200 < 0) {
                            System.out.println("Sorry, not enough water!\n");
                        } else if (milk - 100 < 0) {
                            System.out.println("Sorry, not enough milk!\n");
                        } else if (beans - 12 < 0) {
                            System.out.println("Sorry, not enough beans!\n");
                        } else if (disposableCups - 1 < 0) {
                            System.out.println("Sorry, not enough disposable cups!\n");
                        } else {
                            System.out.println("I have enough resources, making you a coffee!\n");
                            water -= 200;
                            milk -= 100;
                            beans -= 12;
                            disposableCups -= 1;
                            money += 6;
                        }
                    } else {
                        continue;
                    }
                    break;
                case "fill":
                    System.out.println("Write how many ml of water you want to add:");
                    water += scanner.nextInt();
                    System.out.println("Write how many ml of milk you want to add:");
                    milk += scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans you want to add:");
                    beans += scanner.nextInt();
                    System.out.println("Write how many disposable cups of coffee you want to add:");
                    disposableCups += scanner.nextInt();
                    break;
                case "take":
                    System.out.println("I gave you $" + money + "\n");
                    money = 0;
                    break;
            }
        } while (!action.equals("exit"));
    }
}
