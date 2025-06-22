package com.s23010419.agrilink;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class StockManagementActivity extends AppCompatActivity {

    LinearLayout productListLayout;

    
    class Product {
        String name;
        int quantity;

        Product(String name, int quantity) {
            this.name = name;
            this.quantity = quantity;
        }
    }

    ArrayList<Product> stockList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_management);

        productListLayout = findViewById(R.id.productListLayout);

       
        stockList = new ArrayList<>();
        stockList.add(new Product("Coconut Oil", 20));
        stockList.add(new Product("Jaggery", 15));
        stockList.add(new Product("Dried Mango", 10));

        displayStock();
    }

    private void displayStock() {
        productListLayout.removeAllViews();

        for (int i = 0; i < stockList.size(); i++) {
            int index = i;
            Product product = stockList.get(i);

            LinearLayout itemLayout = new LinearLayout(this);
            itemLayout.setOrientation(LinearLayout.HORIZONTAL);
            itemLayout.setPadding(10, 10, 10, 10);
            itemLayout.setGravity(Gravity.CENTER_VERTICAL);

            TextView textView = new TextView(this);
            textView.setText(product.name + " - Qty: " + product.quantity);
            textView.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1));

            Button editBtn = new Button(this);
            editBtn.setText("Edit");
            editBtn.setOnClickListener(v -> showEditDialog(index));

            Button deleteBtn = new Button(this);
            deleteBtn.setText("Delete");
            deleteBtn.setOnClickListener(v -> {
                stockList.remove(index);
                displayStock();
            });

            itemLayout.addView(textView);
            itemLayout.addView(editBtn);
            itemLayout.addView(deleteBtn);

            productListLayout.addView(itemLayout);
        }
    }

    private void showEditDialog(int index) {
        Product product = stockList.get(index);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Edit Quantity for " + product.name);

        final EditText input = new EditText(this);
        input.setInputType(android.text.InputType.TYPE_CLASS_NUMBER);
        input.setHint("Enter new quantity");
        input.setText(String.valueOf(product.quantity));
        builder.setView(input);

        builder.setPositiveButton("Update", (dialog, which) -> {
            String value = input.getText().toString().trim();
            if (!value.isEmpty()) {
                product.quantity = Integer.parseInt(value);
                displayStock();
                Toast.makeText(this, "Updated!", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());

        builder.show();
    }
}
