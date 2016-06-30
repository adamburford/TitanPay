package com.titanpay.accounting.view;

import java.time.LocalDate;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.titanpay.accounting.MainApp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class PayrollSystemController {

	private MainApp mainApp;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button processButton;

    @FXML
    private Label dateLabel;

    @FXML
    public TextArea outputText;

    @FXML
    void initialize() {
        assert processButton != null : "fx:id=\"processButton\" was not injected: check your FXML file 'PayrollSystem.fxml'.";
        assert dateLabel != null : "fx:id=\"dateLabel\" was not injected: check your FXML file 'PayrollSystem.fxml'.";
        assert outputText != null : "fx:id=\"outputText\" was not injected: check your FXML file 'PayrollSystem.fxml'.";

        dateLabel.setText("Payroll Date: " + LocalDate.now().toString());
    }
    
    @FXML
    private void processPayroll() {
    	mainApp.processPayroll();
    		
    }
    
    public void setMainApp(MainApp mainApp) {
    	this.mainApp = mainApp;
    }
}
