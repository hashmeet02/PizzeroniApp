package org.example.workshop2.enums;

//How to use enums with values- https://www.baeldung.com/java-enum-values
public enum PizzaSize {
    SMALL(7.00),
    MEDIUM(10.00),
    LARGE(13.00),
    EXTRA_LARGE(15.00);

    private final double price;

    //Constructor for enum that stores the price.
    PizzaSize(double price){
        this.price=price;
    }

    // getter for price stored in enum types.
    public double getPrice(){
        return this.price;
    }
}
