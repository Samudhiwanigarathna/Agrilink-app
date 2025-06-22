package com.s23010419.agrilink;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    Spinner spinnerRole, spinnerLanguage;
    EditText editEmail, editPassword;
    Button btnLogin, btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerRole = findViewById(R.id.spinnerRole);
        spinnerLanguage = findViewById(R.id.spinnerLanguage);
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignUp = findViewById(R.id.btnSignUp);

        // Set adapters from strings.xml
        ArrayAdapter<CharSequence> roleAdapter = ArrayAdapter.createFromResource(this,
                R.array.user_roles, android.R.layout.simple_spinner_item);
        roleAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRole.setAdapter(roleAdapter);

        ArrayAdapter<CharSequence> langAdapter = ArrayAdapter.createFromResource(this,
                R.array.languages, android.R.layout.simple_spinner_item);
        langAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLanguage.setAdapter(langAdapter);

        btnLogin.setOnClickListener(view -> {
            String role = spinnerRole.getSelectedItem().toString();
            if (role.equals("Farmer")) {
                startActivity(new Intent(this, FarmerDashboardActivity.class));
            } else {
                startActivity(new Intent(this, BuyerDashboardActivity.class));
            }
        });

        btnSignUp.setOnClickListener(view -> {
            Toast.makeText(this, "Signup Page Coming Soon", Toast.LENGTH_SHORT).show();
        });
    }
}
