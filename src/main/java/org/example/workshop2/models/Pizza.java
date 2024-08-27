package org.example.workshop2.models;

import org.example.workshop2.enums.CrustType;
import org.example.workshop2.enums.PizzaSize;
import org.example.workshop2.enums.Toppings;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private PizzaSize size;
    private CrustType crust;
    private List<Toppings> toppings= new ArrayList<>();  //A list of toppings enum values.

    public Pizza(){
        this.size=PizzaSize.SMALL;      //By default, every pizza is going to be Small and have a Normal crust. No toppings.
        this.crust=CrustType.NORMAL;
    }

    public Pizza(PizzaSize size, CrustType crust, List<Toppings> toppings){
        this.size=size;
        this.crust=crust;
        this.toppings=toppings;
    }

    //returns a string value of size based on enum value.
    public String getSize() {
        String result="";
        switch (size){
            case SMALL -> result="Small";
            case MEDIUM -> result="Medium";
            case LARGE-> result="Large";
            case EXTRA_LARGE -> result="Extra-Large";
        }
        return result;
    }

    //size setter
    public void setSize(PizzaSize size) {
        this.size = size;
    }

    //returns a string value os crust based on enum value.
    public String getCrust() {
        String result="";
        switch (crust){
            case NORMAL -> result="Normal";
            case THIN -> result="Thin";
            case DEEP_DISH-> result="Deep-dish";
        }
        return result;
    }

    //Crust setter.
    public void setCrust(CrustType crust) {
        this.crust = crust;
    }

    //returns the list of topings
    public List<Toppings> getToppings() {
        return toppings;
    }

    //setter of toppings
    public void setToppings(List<Toppings> toppings) {
        this.toppings = toppings;
    }

    //It checks what toppings are present on the Pizza
    public double calculatePrice(){
        double price=size.getPrice();
        for(Toppings topping: toppings){
            price+=topping.getPrice();
        }
        return price;
    }
}

