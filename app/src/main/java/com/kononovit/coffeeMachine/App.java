package com.kononovit.coffeeMachine;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        CoffeeManager coffeeManager = new CoffeeManager(coffeeMachine, new Scanner(System.in));

        coffeeManager.run();
    }
}