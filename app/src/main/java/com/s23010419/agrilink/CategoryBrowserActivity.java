package com.s23010419.agrilink;

import android.icu.util.ULocale;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CategoryBrowserActivity extends AppCompatActivity {

    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;
    private List<ULocale.Category> categoryList;
    private ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_browser);

        // Initialize views
        categoryRecyclerView = findViewById(R.id.categoryRecyclerView);
        backButton = findViewById(R.id.backButton);

        // Back button click
        backButton.setOnClickListener(v -> finish());

        // Setup RecyclerView
        categoryList = getCategoryData();
        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecyclerView.setLayoutManager(new GridLayoutManager(this, 2)); // 2 columns
        categoryRecyclerView.setAdapter(categoryAdapter);

    }

    private List<ULocale.Category> getCategoryData() {
        return java.util.Collections.emptyList();
    }
}
