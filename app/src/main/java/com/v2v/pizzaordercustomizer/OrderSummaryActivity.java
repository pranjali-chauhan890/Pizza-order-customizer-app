package com.v2v.pizzaordercustomizer;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class OrderSummaryActivity extends AppCompatActivity {

        TextView tvSummary;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_order_summary);

            tvSummary = findViewById(R.id.tvSummary);

            String name = getIntent().getStringExtra("name");
            String size = getIntent().getStringExtra("size");
            String quantity = getIntent().getStringExtra("quantity");
            String toppings = getIntent().getStringExtra("toppings");

            String summary = "Order Summary:\n\nName: " + name +
                    "\nSize x Quantity: " + size + " x " + quantity +
                    "\nToppings: " + toppings + "\n\nThank you for your order!";

            tvSummary.setText(summary);
        }
    }

