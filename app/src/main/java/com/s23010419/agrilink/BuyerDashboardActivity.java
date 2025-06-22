package com.s23010419.agrilink;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BuyerDashboardActivity extends Activity {

    EditText inputSearch;
    Button btnFilterPrice, btnFilterCategory, btnFilterRating;
    ListView listViewProducts;
    ArrayList<String> products;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer_dashboard);

        inputSearch = findViewById(R.id.inputSearch);
        btnFilterPrice = findViewById(R.id.btnFilterPrice);
        btnFilterCategory = findViewById(R.id.btnFilterCategory);
        btnFilterRating = findViewById(R.id.btnFilterRating);
        listViewProducts = findViewById(R.id.listViewProducts);

        // Sample product data
        products = new ArrayList<>();
        products.add("Coconut Oil - LKR 500");
        products.add("Mango Pickle - LKR 300");
        products.add("Jaggery Pack - LKR 250");
        products.add("Dried Chilies - LKR 200");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, products);
        listViewProducts.setAdapter(adapter);

        inputSearch.setOnEditorActionListener((v, actionId, event) -> {
            String query = inputSearch.getText().toString().toLowerCase();
            ArrayList<String> filtered = new ArrayList<>();
            for (String item : products) {
                if (item.toLowerCase().contains(query)) {
                    filtered.add(item);
                }
            }
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, filtered);
            listViewProducts.setAdapter(adapter);
            return true;
        });

        btnFilterPrice.setOnClickListener(v -> {
            Collections.sort(products); // Simple mock sort
            adapter.notifyDataSetChanged();
        });

        btnFilterCategory.setOnClickListener(v -> {
            Toast.makeText(this, "Category filter coming soon!", Toast.LENGTH_SHORT).show();
        });

        btnFilterRating.setOnClickListener(v -> {
            Toast.makeText(this, "Rating filter coming soon!", Toast.LENGTH_SHORT).show();
        });
    }
}
