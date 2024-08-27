package org.example.workshop2.views;

public class OrderView {
    /*displayOrderInfo function is called whenever changes are made to the Pizza model.
    This function displays the orderInfo to the user in the text area.
     */

    public String displayOrderInfo(String custName, String custPhone, String pizzaType, String pizzaSize, int quantity, double totalBeforeTax, double totalAfterTax){
        String result="Customer Name: " + (custName==null ? "---" : custName)+          /*Ternary- https://www.geeksforgeeks.org/java-ternary-operator-with-examples/*/
                "\n\nCustomer Phone: " + (custPhone==null ? "---" : custPhone)+
                "\n\nPizza Type: " + pizzaType+
                "\n\nPizza Size: " + pizzaSize+
                "\n\nQuantity: " + quantity+
                "\n\nTotal before tax: " +totalBeforeTax+
                "\n\nTotal to be paid: "+ totalAfterTax;
        return result;
    }
}