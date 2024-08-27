package org.example.workshop2.enums;

//How to use enums with values- https://www.baeldung.com/java-enum-values
public enum Toppings {
    PINEAPPLE(1.10),
    EXTRA_CHEESE(1.10),
    DRIED_SHRIMPS(1.10),
    MUSHROOMS(1.10),
    ANCHOVIES(1.10),
    SUN_DRIED_TOMATOES(1.10),
    DACON(1.10),
    SPINACH(1.10),
    ROASTED_GARLIC(1.10),
    JALAPENO(1.10),
    GROUND_BEEF(2.15),
    SHREDDED_CHICKEN(2.15),
    GRILLED_CHICKEN(2.15),
    PEPPERONI(2.15),
    HAM(2.15),
    BACON(2.15);

    private final double price;

    Toppings(double price){
        this.price=price;
    }

    // gets price associated with each enum.
    public double getPrice() {
        return this.price;
    }

    // general method to display the enums as a formatted string.
    public String displayTopping(){
        String name=this.name().replace('_', ' ').toLowerCase();
        return name.substring(0,1).toUpperCase()+name.substring(1);
    }
}
