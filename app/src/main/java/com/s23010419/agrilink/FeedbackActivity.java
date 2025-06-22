package com.s23010419.agrilink;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FeedbackActivity extends AppCompatActivity {

    RatingBar ratingBar;
    EditText editTextFeedback;
    Button buttonSubmitFeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        ratingBar = findViewById(R.id.ratingBar);
        editTextFeedback = findViewById(R.id.editTextFeedback);
        buttonSubmitFeedback = findViewById(R.id.buttonSubmitFeedback);

        buttonSubmitFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float rating = ratingBar.getRating();
                String feedback = editTextFeedback.getText().toString().trim();

                if (feedback.isEmpty()) {
                    Toast.makeText(FeedbackActivity.this, "Please enter your feedback", Toast.LENGTH_SHORT).show();
                    return;
                }

               
                Toast.makeText(FeedbackActivity.this,
                        "Thanks for your feedback!\nRating: " + rating + "\nComment: " + feedback,
                        Toast.LENGTH_LONG).show();

             
                ratingBar.setRating(0);
                editTextFeedback.setText("");
            }
        });
    }
}
