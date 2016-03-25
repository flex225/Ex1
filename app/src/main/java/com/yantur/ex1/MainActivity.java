package com.yantur.ex1;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_share).setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                String number = ((EditText) findViewById(R.id.number)).getText().toString();
                Uri phoneNumber = Uri.parse("smsto:"+number);
                Intent intent = new Intent(Intent.ACTION_SENDTO,phoneNumber);
                intent.putExtra("sms_body", ((EditText) findViewById(R.id.body)).getText().toString());
                startActivity(intent);
            }
        });


    }
}
