package com.machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        System.out.println("Write how many cups of coffee you will need:");

        Scanner scanner = new Scanner(System.in);
        int cups = scanner.nextInt();

        final int WATER_PER_SERVING = 200;
        final int MILK_PER_SERVING = 50;
        final int BEANS_PER_SERVING = 15;

        int waterTotal = cups * WATER_PER_SERVING;
        int milkTotal = cups * MILK_PER_SERVING;
        int beansTotal = cups * BEANS_PER_SERVING;

        String resultMessage = String.format(
            "For %d cups of coffee you will need:\n"
                + "%d ml of water\n"
                + "%d ml of milk\n"
                + "%d g of coffee beans",
            cups,
            waterTotal,
            milkTotal,
            beansTotal
        );

        System.out.println(resultMessage);
    }
}
