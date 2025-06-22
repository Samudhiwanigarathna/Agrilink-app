package com.s23010419.agrilink;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;

public class ProductDetailActivity extends Activity {

    TextView productName, sellerInfo, priceStock, sensorStatus, productDescription;
    Button btnAddToCart, btnMessage, btnTrackDelivery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        // Initialize UI components
        productName = findViewById(R.id.productName);
        sellerInfo = findViewById(R.id.sellerInfo);
        priceStock = findViewById(R.id.priceStock);
        sensorStatus = findViewById(R.id.sensorStatus);
        productDescription = findViewById(R.id.productDescription);

        btnAddToCart = findViewById(R.id.btnAddToCart);
        btnMessage = findViewById(R.id.btnMessage);
        btnTrackDelivery = findViewById(R.id.btnTrackDelivery);

        // Click Listeners
        btnAddToCart.setOnClickListener(v ->
                Toast.makeText(this, "Added to cart", Toast.LENGTH_SHORT).show());

        btnMessage.setOnClickListener(v ->
                Toast.makeText(this, "Messaging seller...", Toast.LENGTH_SHORT).show());

        btnTrackDelivery.setOnClickListener(v ->
                Toast.makeText(this, "Opening map for delivery timeline...", Toast.LENGTH_SHORT).show());
    }
}
