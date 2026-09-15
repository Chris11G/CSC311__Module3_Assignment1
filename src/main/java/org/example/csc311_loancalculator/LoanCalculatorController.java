package org.example.csc311_loancalculator;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Controller class to handle event-driven calculations for LoanCalculator.
 */
public class LoanCalculatorController {

    @FXML
    private TextField interestRateField;

    @FXML
    private TextField yearsField;

    @FXML
    private TextField loanAmountField;

    @FXML
    private TextField monthlyPaymentField;

    @FXML
    private TextField totalPaymentField;

    /**
     * Responds to the button click event to compute loan payments.
     */
    @FXML
    private void handleCalculate() {
        try {
            // Read user inputs
            double annualInterestRate = Double.parseDouble(interestRateField.getText().trim());
            int numberOfYears = Integer.parseInt(yearsField.getText().trim());
            double loanAmount = Double.parseDouble(loanAmountField.getText().trim());

            // Compute monthly interest rate
            double monthlyInterestRate = annualInterestRate / 1200;

            // Calculate monthly payment formula
            double monthlyPayment = (loanAmount * monthlyInterestRate) /
                    (1 - (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));

            // Compute total payment
            double totalPayment = monthlyPayment * numberOfYears * 12;

            // Display formatted outputs
            monthlyPaymentField.setText(String.format("$%.2f", monthlyPayment));
            totalPaymentField.setText(String.format("$%.2f", totalPayment));

        } catch (NumberFormatException e) {
            monthlyPaymentField.setText("Invalid Input");
            totalPaymentField.setText("Invalid Input");
        }
    }
}