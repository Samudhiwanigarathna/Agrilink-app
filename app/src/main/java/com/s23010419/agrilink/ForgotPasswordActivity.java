package com.s23010419.agrilink;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotPasswordActivity extends AppCompatActivity {

    EditText emailOrPhoneInput;
    Button resetPasswordButton;
    TextView backToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        emailOrPhoneInput = findViewById(R.id.emailOrPhoneInput);
        resetPasswordButton = findViewById(R.id.resetPasswordButton);
        backToLogin = findViewById(R.id.backToLogin);

        resetPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = emailOrPhoneInput.getText().toString().trim();

                if (input.isEmpty()) {
                    Toast.makeText(ForgotPasswordActivity.this, "Please enter your email or phone number", Toast.LENGTH_SHORT).show();
                } else {
                    // Simulated reset logic
                    Toast.makeText(ForgotPasswordActivity.this, "Password reset link sent to " + input, Toast.LENGTH_LONG).show();

                    // Optionally redirect to Login
                    Intent intent = new Intent(ForgotPasswordActivity.this, ForgotPasswordActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        backToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ForgotPasswordActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
