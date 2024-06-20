package com.example.gomes;
/*
Define a class called Employee with the attributes name, empID,
        designation, basicPay, DA, HRA, PF, LIC, netSalary.
        DA is 40% of basicPay, HRA is 15% of basicPay,
        PF is 12% of basicPay. Display all the employee information
        in a JavaFX application.
*/


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
class Employee{
    String name,designation;
    double basicPay,Da,HRA,PF,netSalary;
    final int LIC = 20;
    int empID;
    Employee(String name,String designation,int empID,double basicPay){
        this.name = name;
        this.designation = designation;
        this.empID = empID;
        this.basicPay = basicPay;
        Da = basicPay*0.4;
        PF = basicPay*0.12;
        HRA = basicPay*0.15;
    }
}
public class lab11q4 extends Application {
    public void start(Stage stage){
        GridPane root = new GridPane();
        Scene scene = new Scene(root,500,500);
        stage.setScene(scene);
        TextField name = new TextField("Name");
        TextField designation = new TextField("Designation");
        TextField emp = new TextField("empID");
        TextField basicpay = new TextField("basic Pay");
        Button btn = new Button("Enter Details");
        root.add(name,0,0);
        root.add(designation,0,1);
        root.add(emp,0,2);
        root.add(basicpay,0,3);
        root.add(btn,1,1);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Employee em = new Employee(name.getText(),designation.getText(),Integer.parseInt(emp.getText()),Double.parseDouble(basicpay.getText()));
                Label label = new Label("The Net Salary Is "+String.valueOf(em.basicPay+em.PF+em.Da-em.LIC+em.HRA));
                root.add(label,2,2);
            }
        });
        stage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}
