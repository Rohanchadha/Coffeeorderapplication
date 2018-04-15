package com.example.android.coffeeorderapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int quantity = 2;
    int pricePerCup = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String priceMessage = printOrderSummary();
        displayMessage(priceMessage);
    }

    private String printOrderSummary(){
        String name = "Rohan Chadha";
        String priceMessage ="Your name: " + name +
                            "\nQuantity: " + quantity +
                            "\nTotal Price: " + calculatePrice(quantity,pricePerCup) +
                            "\nThank You :)";

        return priceMessage;
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    public void increment(View view){
        quantity=quantity+1;
        displayQuantity(quantity);
    }


    public void decrement(View view){
        quantity = quantity-1;

        if(quantity<0)
            quantity=0;
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
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    private int calculatePrice(int quantity, int pricePerCup) {
        int price = quantity * pricePerCup;
        return price;
    }
}
