package com.s23010419.agrilink;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class FarmerDashboardActivity extends AppCompatActivity {

    Button btnUploadProduct, btnViewOrders, btnManageStock, btnNotifications;
    TextView txtStock, txtOrders, txtEarnings, txtSmartAlerts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_dashboard);

        btnUploadProduct = findViewById(R.id.btnUploadProduct);
        btnViewOrders = findViewById(R.id.btnViewOrders);
        btnManageStock = findViewById(R.id.btnManageStock);
        btnNotifications = findViewById(R.id.btnNotifications);

        txtStock = findViewById(R.id.txtStock);
        txtOrders = findViewById(R.id.txtOrders);
        txtEarnings = findViewById(R.id.txtEarnings);
        txtSmartAlerts = findViewById(R.id.txtSmartAlerts);

        // Simulate and show rain sensor status
        simulateRainSensor();

        btnUploadProduct.setOnClickListener(v -> {
            startActivity(new Intent(this, UploadProductActivity.class));
        });

        btnViewOrders.setOnClickListener(v -> {
            startActivity(new Intent(this, OrderHistoryActivity.class));
        });

        btnManageStock.setOnClickListener(v -> {
            // Future: Start ManageStockActivity
        });

        btnNotifications.setOnClickListener(v -> {
            // Future: Open NotificationsActivity
        });
    }

    private void simulateRainSensor() {
        // Simulate sensor data
        boolean isRaining = new Random().nextBoolean(); // Random true/false

        if (isRaining) {
            txtSmartAlerts.setText("🌧️ Rain detected by sensor! Please store goods in dry area.");
            txtSmartAlerts.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
        } else {
            txtSmartAlerts.setText("✅ No rain detected. Storage conditions are normal.");
            txtSmartAlerts.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
        }
    }
}
