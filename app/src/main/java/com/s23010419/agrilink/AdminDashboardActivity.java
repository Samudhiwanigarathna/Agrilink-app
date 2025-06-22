package com.s23010419.agrilink;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class AdminDashboardActivity extends AppCompatActivity {

    Button btnManageUsers, btnViewOrders, btnInventoryStatus, btnUserReports;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        btnManageUsers = findViewById(R.id.btnManageUsers);
        btnViewOrders = findViewById(R.id.btnViewOrders);
        btnInventoryStatus = findViewById(R.id.btnInventoryStatus);
        btnUserReports = findViewById(R.id.btnUserReports);

        btnManageUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to ManageUsersActivity
                Intent intent = new Intent(AdminDashboardActivity.this, ManageUsersActivity.class);
                startActivity(intent);
            }
        });

        btnViewOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to ViewAllOrdersActivity
                Intent intent = new Intent(AdminDashboardActivity.this, ViewAllOrdersActivity.class);
                startActivity(intent);
            }
        });

        btnInventoryStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Navigate to InventoryStatusActivity
                Intent intent = new Intent(AdminDashboardActivity.this, InventoryStatusActivity.class);
                startActivity(intent);
            }
        });

        btnUserReports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Navigate to UserReportsActivity
                Intent intent = new Intent(AdminDashboardActivity.this, UserReportsActivity.class);
                startActivity(intent);
            }
        });
    }
}
