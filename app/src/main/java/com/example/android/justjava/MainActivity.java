package com.example.android.justjava;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        CheckBox whippedCreamCheckbox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        Boolean hasWhippedCream = whippedCreamCheckbox.isChecked();

        int price = calculatePrice();
        String priceMessage = createOrderSummary(price, hasWhippedCream);
        displayMessage(priceMessage);



    }


    /**
     * This method is called when the + button is clicked
     */
    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the - button is clicked
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        displayQuantity(quantity);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }



    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /**
     * Calculates the price of the order based on the current quantity.
     *
     * @return the price
     */
    private int calculatePrice() {

        return quantity * 5;

    }

    private String createOrderSummary(int price, boolean hasWhippedCream) {
        String priceMessage = "Name: Kaptain Kunal";
        priceMessage += "\nAdd whipped cream? " + hasWhippedCream;
        priceMessage += "\nQuantity: " + quantity + "\nTotal: $" + price + "\nThank You!";
        return priceMessage;


    }


}