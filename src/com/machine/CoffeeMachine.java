package com.machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int WATER_PER_SERVING = 200;
        final int MILK_PER_SERVING = 50;
        final int BEANS_PER_SERVING = 15;

        System.out.println("Write how many ml of water the coffee machine has:");
        int cupsFromWater = scanner.nextInt() / WATER_PER_SERVING;
        System.out.println("Write how many ml of milk the coffee machine has:");
        int cupsFromMilk = scanner.nextInt() / MILK_PER_SERVING;
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int cupsFromBeans = scanner.nextInt() / BEANS_PER_SERVING;

        int cupsInMachine = Math.min(cupsFromWater,
                Math.min(cupsFromMilk, cupsFromBeans));

        System.out.println("Write how many cups of coffee you will need:");
        int cupsNeeded = scanner.nextInt();

        if (cupsNeeded < cupsInMachine) {
            System.out.println(
                    String.format("Yes, I can make that amount of coffee"
                            + "(and even %d more than that)", cupsInMachine - cupsNeeded)
            );
        } else if (cupsNeeded > cupsInMachine) {
            System.out.println(
                    String.format("No, I can make only %d cup(s) of coffee", cupsInMachine)
            );
        } else {
            System.out.println("Yes, I can make that amount of coffee");
        }
    }
}
