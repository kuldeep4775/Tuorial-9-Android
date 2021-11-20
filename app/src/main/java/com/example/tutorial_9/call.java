package com.example.tutorial_9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class call extends AppCompatActivity {

    EditText cnum;
    Button call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        cnum = findViewById(R.id.txtcphone);
        call = findViewById(R.id.btncall);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = cnum.getText().toString();
                if(phone.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Enter number...!",Toast.LENGTH_SHORT).show();
                }
                else{
                    String s = "tel:"+phone;
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse(s));
                    startActivity(intent);
                }
            }
        });
    }
}