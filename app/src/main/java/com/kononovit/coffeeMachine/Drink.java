package com.machine;

public enum Drink {
    ESPRESSO(250, 0, 16, 1, 4),
    LATTE(350, 75, 20, 1, 7),
    CAPPUCCINO(200, 100, 12, 1, 6);

    int water;
    int milk;
    int beans;
    int cups;
    int cost;

    Drink(int water, int milk, int beans, int cups, int cost) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.cost = cost;
    }

    public static Drink findByNumber(int number) {
        for (Drink drink : values()) {
            if (drink.ordinal() == number - 1) {
                return drink;
            }
        }
        return null;
    }
}
