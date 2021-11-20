package com.example.tutorial_9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button msms,mcall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        msms = findViewById(R.id.btnmovesms);
        mcall = findViewById(R.id.btnmovecall);

        msms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent is = new Intent(getApplicationContext(),sms.class);
                startActivity(is);
            }
        });

        mcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ic = new Intent(getApplicationContext(),call.class);
                startActivity(ic);
            }
        });

    }
}