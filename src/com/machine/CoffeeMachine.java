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

        System.out.println(
                String.format("The coffee machine has:\n"
                            + "%d ml of water\n"
                            + "%d ml of milk\n"
                            + "%d g of coffee beans\n"
                            + "%d disposable cups\n"
                            + "$%d of money\n",
                    water,
                    milk,
                    beans,
                    disposableCups,
                    money)
        );

        System.out.println("Write action (buy, fill, take):");
        String action = scanner.nextLine();

        switch (action) {
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                int operation = scanner.nextInt();
                if (operation == 1) {
                    water -= 250;
                    beans -= 16;
                    disposableCups -= 1;
                    money += 4;
                } else if (operation == 2) {
                    water -= 350;
                    milk -= 75;
                    beans -= 20;
                    disposableCups -= 1;
                    money += 7;
                } else {
                    water -= 200;
                    milk -= 100;
                    beans -= 12;
                    disposableCups -= 1;
                    money += 6;
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

        System.out.println(
                String.format("The coffee machine has:\n"
                                + "%d ml of water\n"
                                + "%d ml of milk\n"
                                + "%d g of coffee beans\n"
                                + "%d disposable cups\n"
                                + "$%d of money\n",
                        water,
                        milk,
                        beans,
                        disposableCups,
                        money)
        );
    }
}
