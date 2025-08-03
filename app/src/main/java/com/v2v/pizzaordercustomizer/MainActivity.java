package com.v2v.pizzaordercustomizer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName, etQuantity;
    RadioGroup sizeGroup;
    CheckBox cbCheese, cbOlives, cbBellPepper, cbMushrooms;
    Button btnOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etQuantity = findViewById(R.id.etQuantity);
        sizeGroup = findViewById(R.id.sizeGroup);
        cbCheese = findViewById(R.id.cbCheese);
        cbOlives = findViewById(R.id.cbOlives);
        cbBellPepper = findViewById(R.id.cbBellPepper);
        cbMushrooms = findViewById(R.id.cbMushrooms);
        btnOrder = findViewById(R.id.btnOrder);

        btnOrder.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();
            String quantity = etQuantity.getText().toString().trim();
            String size = "";

            int selectedSizeId = sizeGroup.getCheckedRadioButtonId();
            if (selectedSizeId != -1) {
                RadioButton selected = findViewById(selectedSizeId);
                size = selected.getText().toString();
            }

            StringBuilder toppings = new StringBuilder();
            if (cbCheese.isChecked()) toppings.append("Extra Cheese, ");
            if (cbOlives.isChecked()) toppings.append("Olives, ");
            if (cbBellPepper.isChecked()) toppings.append("Bell Peppers, ");
            if (cbMushrooms.isChecked()) toppings.append("Mushrooms, ");

            if (toppings.length() > 0)
                toppings.setLength(toppings.length() - 2); // remove last comma

            Intent intent = new Intent(MainActivity.this, com.v2v.pizzaordercustomizer.OrderSummaryActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("size", size);
            intent.putExtra("quantity", quantity);
            intent.putExtra("toppings", toppings.toString());
            startActivity(intent);
        });
    }
}