package com.example.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LocalCaseActivity extends AppCompatActivity {
    Button newsBtn,pharmacyBtn;
    TextView localTv;
    private String location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_case);

        newsBtn = findViewById(R.id.newsBtn);
        pharmacyBtn = findViewById(R.id.pharmacyBtn);
        localTv = findViewById(R.id.localTv);

        Intent intent = getIntent();
        location = intent.getExtras().getString("location");

        localTv.setText(location);

        newsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NewsActivity.class);

                intent.putExtra("location",location);
                startActivity(intent);
            }
        });

        pharmacyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ///수정필요
                Intent intent = new Intent(getApplicationContext(), LocalCaseActivity.class);

                intent.putExtra("location",location);
                startActivity(intent);
            }
        });

    }
}
