
package com.s23010419.agrilink;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class UserProfileActivity extends AppCompatActivity {

    private EditText nameField, emailField, phoneField;
    private Button editBtn, saveBtn;
    private TextView roleView;
    private ImageView profileImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        profileImage = findViewById(R.id.profileImage);
        nameField = findViewById(R.id.nameField);
        emailField = findViewById(R.id.emailField);
        phoneField = findViewById(R.id.phoneField);
        roleView = findViewById(R.id.roleView);
        editBtn = findViewById(R.id.editBtn);
        saveBtn = findViewById(R.id.saveBtn);

        editBtn.setOnClickListener(v -> enableEditing(true));
        saveBtn.setOnClickListener(v -> {
            enableEditing(false);
            
        });
    }

    private void enableEditing(boolean enable) {
        nameField.setEnabled(enable);
        emailField.setEnabled(enable);
        phoneField.setEnabled(enable);
    }
}
