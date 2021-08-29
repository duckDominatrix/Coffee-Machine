package com.machine;

public class CoffeeMachine {
    int water;
    int milk;
    int beans;
    int cups;
    int money;

    State state;

    public CoffeeMachine() {
        this.water = 400;
        this.milk = 540;
        this.beans = 120;
        this.cups = 9;
        this.money = 550;
        this.state = State.RUNNING;
    }

    public void process(String command) {
        switch (command) {
            case "buy":
                this.setState(State.BUY);
                break;
            case "fill":
                this.setState(State.FILL_WATER);
                break;
            case "take":
                this.setState(State.TAKE);
                this.processSecond(command);
                break;
            case "remaining":
                this.setState(State.REMAINING);
                this.processSecond(command);
                break;
            case "exit":
                this.setState(State.OFF);
                break;
            default:
                this.processSecond(command);
        }
    }

    public void processSecond(String command) {
        switch (this.state) {
            case BUY:
                this.makeCoffee(command);
                this.setState(State.RUNNING);
                break;
            case FILL_WATER:
            case FILL_MILK:
            case FILL_BEANS:
                this.fill(command);
                break;
            case FILL_CUPS:
                this.fill(command);
                this.setState(State.RUNNING);
                break;
            case TAKE:
                this.takeMoney();
                this.setState(State.RUNNING);
                break;
            case REMAINING:
                this.setState(State.RUNNING);
                break;
        }
    }



    private void setState(State newState) { this.state = newState; }

    private void makeCoffee(String coffeeNumber) {
        Drink coffee = Drink.findByNumber(
                Integer.parseInt(coffeeNumber)
        );

        if (this.getCoffeeStatus(coffeeNumber).equals("ok")) {
            this.water -= coffee.water;
            this.milk -= coffee.milk;
            this.beans -= coffee.beans;
            this.cups -= coffee.cups;
            this.money += coffee.cost;
        }
    }

    private void fill(String value) {
        switch (this.state) {
            case FILL_WATER:
                this.water += Integer.parseInt(value);
                this.setState(State.FILL_MILK);
                break;
            case FILL_MILK:
                this.milk += Integer.parseInt(value);
                this.setState(State.FILL_BEANS);
                break;
            case FILL_BEANS:
                this.beans += Integer.parseInt(value);
                this.setState(State.FILL_CUPS);
                break;
            case FILL_CUPS:
                this.cups += Integer.parseInt(value);
                break;
        }
    }

    private void takeMoney() {
        this.money = 0;
    }

    public String getStatus(String command) {
        switch (this.state) {
            case BUY:
                return this.getCoffeeStatus(command);
            case RUNNING:
                return this.getRemainingStatus(command);
            default:
                return "";

        }
    }

    private String getCoffeeStatus(String coffeeNumber) {
        Drink coffee = Drink.findByNumber(
                Integer.parseInt(coffeeNumber)
        );

        if (this.water - coffee.water < 0) {
            return "water";
        }
        if (this.milk - coffee.milk < 0) {
            return "milk";
        }
        if (this.beans - coffee.beans < 0) {
            return "beans";
        }
        if (this.cups - coffee.cups < 0) {
            return "beans";
        }
        return "ok";
    }

    private String getRemainingStatus(String recourse) {
        switch (recourse) {
            case "water":
                return String.valueOf(this.water);
            case "milk":
                return String.valueOf(this.milk);
            case "beans":
                return String.valueOf(this.beans);
            case "cups":
                return String.valueOf(this.cups);
            case "money":
                return String.valueOf(this.money);
            default:
                return "";
        }
    }
}
