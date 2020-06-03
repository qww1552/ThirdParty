package com.example.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startBtn = (Button)findViewById(R.id.startBtn);
        startBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) { //지역 설정 버튼 누르면 activity_sub 클래스로 화면 전환
                Intent intent = new Intent(getApplicationContext(), activity_sub.class);
                startActivity(intent);
            }
        });
    }
}
