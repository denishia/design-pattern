package com.banking.decorator;

public class Main {
    public static void main(String[] args) {

        // Plain Margherita — no toppings
        Pizza pizza1 = new Margherita();
        print(pizza1);

        // Margherita + Extra Cheese + Jalapenos
        Pizza pizza2 = new Margherita();
        pizza2 = new ExtraCheese(pizza2);
        pizza2 = new Jalapenos(pizza2);
        print(pizza2);

        // FarmHouse + Extra Cheese + Mushrooms + Jalapenos
        Pizza pizza3 = new FarmHouse();
        pizza3 = new ExtraCheese(pizza3);
        pizza3 = new Mushrooms(pizza3);
        pizza3 = new Jalapenos(pizza3);
        print(pizza3);
    }

    private static void print(Pizza pizza) {
        System.out.println(pizza.getDescription() + "  =>  $" + pizza.getPrice());
    }
}
