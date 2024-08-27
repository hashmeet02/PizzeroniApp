/**********************************************
 Workshop 2
 Course:APD-545 - Semester- 5
 Last Name: Saini
 First Name: Hashmeet Singh
 ID: 153070214
 Section: NAA
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Signature
 Date: February 9th 2024
 **********************************************/

package org.example.workshop2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.workshop2.controllers.AppController;
import org.example.workshop2.models.Customer;
import org.example.workshop2.models.Order;
import org.example.workshop2.models.Pizza;
import org.example.workshop2.views.OrderView;

import java.io.IOException;

public class PizzeroniApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PizzeroniApp.class.getResource("view/pizzeroni-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 706, 597);
        AppController controller = fxmlLoader.getController();
        initializeController(controller);
        stage.setTitle("Pizzeroni App!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /* defined initializeController method that instantiates the required pizza customer and order objects, orderView
    and passes them to the controller.
     */
    private void initializeController(AppController controller) {
        Pizza pizza = new Pizza();
        Customer customer = new Customer();
        Order order = new Order(pizza, customer, 1);
        OrderView orderView = new OrderView();

        controller.setOrder(order);
        controller.setOrderView(orderView);
        controller.generateOrderInfo();
    }
    public static void main(String[] args) { launch(); }
}