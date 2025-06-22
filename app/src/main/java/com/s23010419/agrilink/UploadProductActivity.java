package com.s23010419.agrilink;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.app.Activity;
import android.widget.Toast;

public class UploadProductActivity extends Activity {

    EditText inputProductName, inputProductDesc, inputProductCategory, inputProductPrice, inputProductQty;
    TextView txtSensorStatus;
    Button btnUploadImage, btnSaveProduct, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_product);

        inputProductName = findViewById(R.id.inputProductName);
        inputProductDesc = findViewById(R.id.inputProductDesc);
        inputProductCategory = findViewById(R.id.inputProductCategory);
        inputProductPrice = findViewById(R.id.inputProductPrice);
        inputProductQty = findViewById(R.id.inputProductQty);
        txtSensorStatus = findViewById(R.id.txtSensorStatus);

        btnUploadImage = findViewById(R.id.btnUploadImage);
        btnSaveProduct = findViewById(R.id.btnSaveProduct);
        btnCancel = findViewById(R.id.btnCancel);

        btnUploadImage.setOnClickListener(v -> {
           
            Toast.makeText(this, "Image upload coming soon!", Toast.LENGTH_SHORT).show();
        });

        btnSaveProduct.setOnClickListener(v -> {
            String name = inputProductName.getText().toString();
            String price = inputProductPrice.getText().toString();

            if (name.isEmpty() || price.isEmpty()) {
                Toast.makeText(this, "Please fill in required fields.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Product Saved!", Toast.LENGTH_SHORT).show();
                finish(); 
            }
        });

        btnCancel.setOnClickListener(v -> finish());
    }
}
