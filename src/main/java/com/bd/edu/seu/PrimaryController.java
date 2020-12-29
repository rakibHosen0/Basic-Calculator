package com.bd.edu.seu;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PrimaryController {
    double number1;
    double number2;
    String operation;


    @FXML
    private TextField displayField;
    public PrimaryController() {
        displayField = new TextField();
    }

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    @FXML
    private void handleAllClearAction(){
        displayField.setText("");
    }

    @FXML
    private  void handleDigitOperation(ActionEvent actionEvent){
       Button eventSource = (Button)  actionEvent.getSource();
       String digit = eventSource.getText();
       String oldText = displayField.getText();
       if(oldText.startsWith("0"))
           oldText = " ";
       if(!digit.equals(".") || (digit.equals(".") && !oldText.contains("."))){
           String newText = oldText + digit;
           displayField.setText(newText);
        }

    }

    @FXML
    private  void handelZeroOperation(){
        String oldText = displayField.getText();
        if(!oldText.startsWith("0")){
            String newText = oldText + "0";
            displayField.setText(newText);
        }
    }


    @FXML
    private  void handleOperation(ActionEvent actionEvent){
        String numberAsString = displayField.getText();
        number1 = Double.parseDouble(numberAsString);
        displayField.clear();
        operation = ((Button)  actionEvent.getSource()).getText();
    }
    @FXML
    private  void handleEqualOperation(){
        double result =0;
        String  numberAsString = displayField.getText();
        number2 = Double.parseDouble(numberAsString);
        switch (operation){
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "x":
                result = number1 * number2;
                break;
            case "/":
                result = number1 / number2;
                break;
        }
        displayField.setText("" +result);
    }

}
