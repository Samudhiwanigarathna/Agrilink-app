package com.s23010419.agrilink;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class SettingsNotificationsActivity extends Activity {

    Spinner spinnerLanguage;
    CheckBox chkOrderUpdates, chkSensorAlerts, chkMarketChanges;
    Button btnSaveSettings;
    ListView listNotifications;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_notifications);

        spinnerLanguage = findViewById(R.id.spinnerLanguage);
        chkOrderUpdates = findViewById(R.id.chkOrderUpdates);
        chkSensorAlerts = findViewById(R.id.chkSensorAlerts);
        chkMarketChanges = findViewById(R.id.chkMarketChanges);
        btnSaveSettings = findViewById(R.id.btnSaveSettings);
        listNotifications = findViewById(R.id.listNotifications);

        // Languages
        String[] languages = {"English", "සිංහල", "தமிழ்"};
        ArrayAdapter<String> langAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, languages);
        spinnerLanguage.setAdapter(langAdapter);

        // Notifications list
        String[] sampleNotifications = {
                "🚚 Order #1023 delivered successfully.",
                "⚠️ Temperature Alert: Stock room over 30°C!",
                "📈 Dried mango market price increased 10%."
        };
        ArrayAdapter<String> notifAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, sampleNotifications);
        listNotifications.setAdapter(notifAdapter);

        btnSaveSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SettingsNotificationsActivity.this,
                        "Settings saved successfully!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
