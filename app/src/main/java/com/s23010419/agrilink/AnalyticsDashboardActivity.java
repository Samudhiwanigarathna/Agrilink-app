package com.s23010419.agrilink;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class AnalyticsDashboardActivity extends Activity {

    TextView tvIncome, tvDeliveryTime, tvSatisfaction;
    ListView listTopProducts;
    ImageView imgSalesChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analytics_dashboard);

        tvIncome = findViewById(R.id.tvIncome);
        tvDeliveryTime = findViewById(R.id.tvDeliveryTime);
        tvSatisfaction = findViewById(R.id.tvSatisfaction);
        listTopProducts = findViewById(R.id.listTopProducts);
        imgSalesChart = findViewById(R.id.imgSalesChart);

       
        String[] topProducts = {"Coconut Oil", "Dried Mango", "Organic Jaggery", "Spice Mix", "Pickled Chilies"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, topProducts
        );

        listTopProducts.setAdapter(adapter);
    }
}
