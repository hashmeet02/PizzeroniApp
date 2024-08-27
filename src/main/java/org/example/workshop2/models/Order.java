package org.example.workshop2.models;

// Order class that stores the details of Pizza, customer, quantity of pizzas ordered, total price with and without tax.
public class Order {
    private Pizza pizza;
    private Customer customer;
    private int quantity;
    private double totalPrice;
    private double totalPriceWTax;

    //default constructor. quantity set to 1 by default.
    public Order() {
        this.pizza = new Pizza();
        this.customer = new Customer();
        this.quantity = 1;
    }

    // argument constructor
    public Order(Pizza pizza, Customer customer, int quantity) {
        this.pizza = pizza;
        this.customer = customer;
        this.quantity = quantity;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // calculates total price and rounds them off 2 nearest 2 digits.
    public double getTotalPrice() {
        calculateTotalPrice();
        return Math.round(totalPrice*100)/100.0;  //rounding to 2 decimal places. https://stackoverflow.com/questions/11701399/round-up-to-2-decimal-places-in-java
    }

    public void calculateTotalPrice() {
        this.totalPrice = this.pizza.calculatePrice() * quantity;  // multiples price by quantity
    }

    public double getTotalPriceWTax() {
        calculateTotalPriceWTax();
        return Math.round(totalPriceWTax*100)/100.0;   //total price with tax rounded off by 2 places.
    }

    public void calculateTotalPriceWTax() {
        this.totalPriceWTax = totalPrice + (totalPrice*0.13);   // calculates total prices with tax,
    }
}
