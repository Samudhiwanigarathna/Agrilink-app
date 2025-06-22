package com.s23010419.agrilink;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class OrderHistoryActivity extends AppCompatActivity {

    LinearLayout orderHistoryLayout;

    class Order {
        String orderId;
        String productName;
        int quantity;
        String date;
        String status;

        Order(String orderId, String productName, int quantity, String date, String status) {
            this.orderId = orderId;
            this.productName = productName;
            this.quantity = quantity;
            this.date = date;
            this.status = status;
        }
    }

    ArrayList<Order> orderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);

        orderHistoryLayout = findViewById(R.id.orderHistoryLayout);

        // Dummy orders (Replace with database or API later)
        orderList = new ArrayList<>();
        orderList.add(new Order("ORD001", "Coconut Oil", 2, "2025-06-01", "Delivered"));
        orderList.add(new Order("ORD002", "Jaggery", 5, "2025-06-10", "Pending"));
        orderList.add(new Order("ORD003", "Dried Mango", 1, "2025-06-12", "Shipped"));

        showOrderHistory();
    }

    private void showOrderHistory() {
        for (Order order : orderList) {
            LinearLayout card = new LinearLayout(this);
            card.setOrientation(LinearLayout.VERTICAL);
            card.setPadding(24, 16, 24, 16);
            card.setBackgroundResource(android.R.drawable.dialog_holo_light_frame);
            card.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            card.setGravity(Gravity.START);
            card.setPadding(16, 16, 16, 16);

            TextView id = new TextView(this);
            id.setText("Order ID: " + order.orderId);

            TextView product = new TextView(this);
            product.setText("Product: " + order.productName);

            TextView qty = new TextView(this);
            qty.setText("Quantity: " + order.quantity);

            TextView date = new TextView(this);
            date.setText("Date: " + order.date);

            TextView status = new TextView(this);
            status.setText("Status: " + order.status);
            status.setTextColor(getResources().getColor(android.R.color.holo_green_dark));

            card.addView(id);
            card.addView(product);
            card.addView(qty);
            card.addView(date);
            card.addView(status);

            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            lp.setMargins(0, 0, 0, 24);

            orderHistoryLayout.addView(card, lp);
        }
    }
}
