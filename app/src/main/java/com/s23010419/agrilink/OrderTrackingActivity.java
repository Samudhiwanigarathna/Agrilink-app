package com.s23010419.agrilink;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OrderTrackingActivity extends AppCompatActivity {

    TextView tvOrderId, tvOrderStatus;
    ListView listTimeline;
    WebView mapWebView; // Replaces static ImageView

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_tracking);

        tvOrderId = findViewById(R.id.tvOrderId);
        tvOrderStatus = findViewById(R.id.tvOrderStatus);
        listTimeline = findViewById(R.id.listTimeline);
        mapWebView = findViewById(R.id.mapWebView); // WebView for map

        // Set Order ID and status
        tvOrderId.setText("Order ID: #AG12345");
        tvOrderStatus.setText("Status: Out for Delivery");

        // Sample delivery steps
        String[] deliverySteps = {
                "Confirmed",
                "Packed at Warehouse",
                "Dispatched from Farm",
                "Out for Delivery",
                "Expected to Arrive Today"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, deliverySteps
        );

        listTimeline.setAdapter(adapter);

        // Setup WebView for map (can use a static or dynamic map link)
        mapWebView.setWebViewClient(new WebViewClient());
        mapWebView.getSettings().setJavaScriptEnabled(true);

        // Sample map showing a delivery path (customize with delivery coordinates)
        mapWebView.loadUrl("https://www.google.com/maps/d/embed?mid=1fYdJ1q5J9BzOtL8HVJ_1nRZqktkq2-Xa"); // Replace with your tracking link if needed
    }
}
