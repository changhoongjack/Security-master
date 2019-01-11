package com.example.jack.security;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.EventLog;
import android.view.View;

public class VerifyClass extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);
    }
    public void VerifyGuest(View view)
    {
        Intent intent = new Intent(this,SecurityVerify.class);
        startActivity(intent);
    }
    public void VerifyEvent(View view)
    {
        Intent intent = new Intent(this,EventVerify.class);
        startActivity(intent);
    }
}
