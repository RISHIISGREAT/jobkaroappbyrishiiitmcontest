package com.mgstarlites.jobkaro;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Dashboard extends AppCompatActivity {

    LinearLayout Line1,Line2,Line3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Line1 = findViewById(R.id.line1);
        Line2 = findViewById(R.id.line2);
        Line3 = findViewById(R.id.line3);

        Line1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, Jobsnearme.class);
                startActivity(intent);
            }
        });

        Line2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, ResumeBuilder.class);
                startActivity(intent);
            }
        });




    }
}