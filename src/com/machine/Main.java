package com.machine;

import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
       CoffeeMachine coffeeMachine = new CoffeeMachine();
       CoffeeManager coffeeManager = new CoffeeManager(coffeeMachine, new Scanner(System.in));

       coffeeManager.run();
   }
}
