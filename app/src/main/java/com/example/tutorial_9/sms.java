package com.example.tutorial_9;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sms extends AppCompatActivity {

    EditText num,sms;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        num = findViewById(R.id.txtphone);
        sms = findViewById(R.id.txtmsg);
        send = findViewById(R.id.btnsendsms);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(sms.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED){
                    sendMessage();
                }
                else
                {
                    ActivityCompat.requestPermissions(sms.this,new String[]{Manifest.permission.SEND_SMS},100);
                }
            }
        });
    }

    private void sendMessage() {
        String sPhone = num.getText().toString().trim();
        String sSms = sms.getText().toString().trim();
        if(!sPhone.equals("") && !sSms.equals("")){
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(sPhone,null,sSms,null,null);
            Toast.makeText(getApplicationContext(),"SMS Send Successfully...!",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Enter All Value...!",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 100 && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            sendMessage();
        }
        else {
            Toast.makeText(getApplicationContext(),"Permissions Denied...!",Toast.LENGTH_SHORT).show();
        }
    }
}