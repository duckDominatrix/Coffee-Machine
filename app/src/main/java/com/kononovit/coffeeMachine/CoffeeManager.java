package com.kononovit.coffeeMachine;

import java.util.Scanner;

public class CoffeeManager {
    Scanner command;
    CoffeeMachine coffeeMachine;

    public CoffeeManager(CoffeeMachine coffeeMachine, Scanner scanner) {
        this.coffeeMachine = coffeeMachine;
        this.command = scanner;
    }

    void run() {
        String action;
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            action = command.nextLine();
            switch (action) {
                case "buy":
                    this.buy(action);
                    break;
                case "fill":
                    this.fill(action);
                    break;
                case "take":
                    this.take(action);
                    break;
                case "remaining":
                    this.remaining(action);
                    break;
                default:
                    this.exit(action);
                    return;
            }
        }
    }

    void buy(String action) {
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String coffeeNumber = command.nextLine();

        if (coffeeNumber.equals("back")) {
            return;
        }

        coffeeMachine.process(action);
        String coffeeStatus = coffeeMachine.getStatus(coffeeNumber);
        this.printCoffeeStatus(coffeeStatus);
        coffeeMachine.process(coffeeNumber);
    }

    void printCoffeeStatus(String status) {
        switch (status) {
            case "water":
                System.out.println("Sorry, not enough water!");
                break;
            case "milk":
                System.out.println("Sorry, not enough milk!");
                break;
            case "beans":
                System.out.println("Sorry, not enough coffee beans!");
                break;
            case "cups":
                System.out.println("Sorry, not enough disposable cups!");
                break;
            default:
                System.out.println("I have enough resources, making you a coffee!");
                break;
        }
        System.out.println();
    }

    void fill(String action) {
        coffeeMachine.process(action);
        System.out.println();

        System.out.println("Write how many ml of water you want to add:");
        coffeeMachine.process(command.nextLine());

        System.out.println("Write how many ml of milk you want to add:");
        coffeeMachine.process(command.nextLine());

        System.out.println("Write how many grams of coffee beans you want to add:");
        coffeeMachine.process(command.nextLine());

        System.out.println("Write how many disposable cups of coffee you want to add:");
        coffeeMachine.process(command.nextLine());

        System.out.println();
    }

    void take(String action) {
        System.out.println("I gave you $" + coffeeMachine.getStatus("money") + "\n");
        coffeeMachine.process(action);
    }

    void remaining(String action) {
        coffeeMachine.process(action);
        System.out.println();
        System.out.printf("The coffee machine has:\n"
                        + "%s ml of water\n"
                        + "%s ml of milk\n"
                        + "%s g of coffee beans\n"
                        + "%s disposable cups\n"
                        + "$%s of money\n",
                coffeeMachine.getStatus("water"),
                coffeeMachine.getStatus("milk"),
                coffeeMachine.getStatus("beans"),
                coffeeMachine.getStatus("cups"),
                coffeeMachine.getStatus("money")
                );
        System.out.println();
    }

    void exit(String action) {
        coffeeMachine.process(action);
    }
}
