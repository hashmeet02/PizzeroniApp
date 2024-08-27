package org.example.workshop2.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import org.example.workshop2.enums.CrustType;
import org.example.workshop2.enums.PizzaSize;
import org.example.workshop2.enums.Toppings;
import org.example.workshop2.models.Customer;
import org.example.workshop2.models.Order;
import org.example.workshop2.models.Pizza;
import org.example.workshop2.views.OrderView;

import java.util.ArrayList;
import java.util.List;

public class AppController {
    @FXML
    private Order order;
    private OrderView orderView;

    public void setOrder(Order order) {
        this.order=order;
    }

    public void setOrderView(OrderView orderView) {
        this.orderView = orderView;
    }

    @FXML
    private ToggleGroup sizeSelect;
    @FXML
    private RadioButton sizeS, sizeM, sizeL, sizeXL;

    @FXML
    private ToggleGroup crustSelect;
    @FXML
    private RadioButton crustNormal, crustThin, crustDeepDish;

    @FXML
    private CheckBox pineappleTop, extraCheeseTop,
            driedShrimpsTop, mushroomsTop, anchoviesTop,
            sunDriedTomatoesTop, daconTop, spinachTop,
            roastedGarlicTop, jalapenoTop, groundBeefTop,
            shreddedChickenTop, grilledChickenTop, pepperoniTop,
            hamTop, baconTop;

    @FXML
    private TextField custName, custPhone, pizzaQty;

    @FXML
    private TextArea orderInfo;

    @FXML
    private Button resetBtn, placeOrderBtn;

    @FXML
    private Label infoBox;

    //sets the size of pizza and displays the update message in the info box.
    public void setSize(ActionEvent event){
        Pizza pizza=order.getPizza();
        if (sizeS.isSelected()){
            pizza.setSize(PizzaSize.SMALL);
        }
        else if (sizeM.isSelected()){
            pizza.setSize(PizzaSize.MEDIUM);
        }
        else if (sizeL.isSelected()){
            pizza.setSize(PizzaSize.LARGE);
        }
        else if (sizeXL.isSelected()){
            pizza.setSize(PizzaSize.EXTRA_LARGE);
        }
        infoBox.setText("(i)- " +pizza.getSize()+" size is selected");
        generateOrderInfo();
    }

    //sets the crust of pizza and displays the update message in the info box.
    public void setCrust(ActionEvent event){
        Pizza pizza=order.getPizza();
        if (crustNormal.isSelected()){
            pizza.setCrust(CrustType.NORMAL);
        }
        else if (crustThin.isSelected()){
            pizza.setCrust(CrustType.THIN);
        }
        else if (crustDeepDish.isSelected()){
            pizza.setCrust(CrustType.DEEP_DISH);
        }
        infoBox.setText("(i)- " +pizza.getCrust()+" crust is selected");
        generateOrderInfo();
    }

    //calls the function to add or remove toppings as the user interacts with the checkbox.
    public void updateToppings(ActionEvent event){
        CheckBox checkbox= (CheckBox) event.getSource();
        String toppingName=checkbox.getText();
        boolean isSelected=checkbox.isSelected();

        Toppings topping= Toppings.valueOf(toppingName.toUpperCase().replace(" ", "_"));
        addOrRemoveToppings(topping, isSelected);
        generateOrderInfo();
    }

    //Adds and removes toppings from the list of toppings.
    public void addOrRemoveToppings(Toppings topping, boolean isSelected){
        Pizza pizza=order.getPizza();
        List<Toppings> currentTopppings=new ArrayList<>(pizza.getToppings());
        if(isSelected){
            if(!currentTopppings.contains(topping)){
                currentTopppings.add(topping);
                infoBox.setText("(i)- "+ topping.displayTopping() + " added");
            }
        }else {
            currentTopppings.remove(topping);
            infoBox.setText("(i)- "+ topping.displayTopping() + " removed");
        }
        pizza.setToppings(currentTopppings);
    }

    // updates the customer when the user enters the name.
    public void addCustomerName(ActionEvent event){
        Customer customer=order.getCustomer();
        customer.setName(custName.getText().trim().toString());
        infoBox.setText("(i)- name of customer is "+ customer.getName());
        generateOrderInfo();
    }

    // updates the customer phone when use renter the phone number.
    // It also checks if the number is 10 digits long and only contains digits
    public void addCustomerPhone(ActionEvent event){
        String phoneInput = custPhone.getText().trim();
        if (phoneInput.matches("\\d{10}")) {
            Customer customer = order.getCustomer();
            customer.setPhoneNumber(phoneInput);
            infoBox.setText("(i)- contact customer at " + customer.getPhoneNumber());
            generateOrderInfo();
        }else{
            custPhone.clear();
            infoBox.setText("(i)- Invalid Phone Number");
            System.err.println("Invalid Phone Number: Phone Number should only contain digits and be 10 digits long");
        }
    }

    // updates quantity of pizza as the text field is updated.
    public void addPizzaQty(ActionEvent event){
        try{
            int qty= Integer.parseInt(pizzaQty.getText().trim());
            order.setQuantity(qty);
            infoBox.setText("(i)- customer ordered " + order.getQuantity()+ " pizzas");
            generateOrderInfo();
        }catch (NumberFormatException e){
            order.setQuantity(1);
            infoBox.setText("(i)- Invalid input");
            System.err.println("Invalid input: Quantity must be an integer.");
        }
    }

    //this function updates the form to default settings
    public void clearForm(ActionEvent event){
        custName.clear();
        custPhone.clear();
        pizzaQty.clear();

        pineappleTop.setSelected(false);
        extraCheeseTop.setSelected(false);
        driedShrimpsTop.setSelected(false);
        mushroomsTop.setSelected(false);
        anchoviesTop.setSelected(false);
        sunDriedTomatoesTop.setSelected(false);
        daconTop.setSelected(false);
        spinachTop.setSelected(false);
        roastedGarlicTop.setSelected(false);
        jalapenoTop.setSelected(false);
        groundBeefTop.setSelected(false);
        shreddedChickenTop.setSelected(false);
        grilledChickenTop.setSelected(false);
        pepperoniTop.setSelected(false);
        hamTop.setSelected(false);
        baconTop.setSelected(false);

        sizeS.setSelected(true);
        crustNormal.setSelected(true);
        pizzaQty.setText("1");

        order=new Order();
        generateOrderInfo();
    }

    public void resetForm(ActionEvent event){
        clearForm(event);
        infoBox.setText("(i)- Form Reset");

    }

    // calls the displayOrderInfo function from the view class to update the text field.
    public void generateOrderInfo(){
        Customer customer=order.getCustomer();
        Pizza pizza=order.getPizza();
        String result=orderView.displayOrderInfo(customer.getName(), customer.getPhoneNumber(), pizza.getCrust().toString(), pizza.getSize().toString(), order.getQuantity(), order.getTotalPrice(), order.getTotalPriceWTax());
        orderInfo.setText(result);
    }

    //placeOrder function lets the user know that the order has been placed and clears the form.
    public void placeOrder(ActionEvent event){
        if(order.getCustomer().getName()== null || order.getCustomer().getPhoneNumber()== null ){
            infoBox.setText("(i)- Can't place order without Customer name and phone number");
            System.err.println("Can't place order without Customer name and phone number");
        }else{
            infoBox.setText("(i)- Order was successfully placed");
            this.clearForm(event);
        }
    }


}
