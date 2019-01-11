package com.example.jack.security;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class INrecords extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.in_records);

    }
    public void ViewContractorRecords(View view)
    {
        Intent intent = new Intent(this,ContractorRecords.class);
        startActivity(intent);
    }
    public void ViewGuestRecords(View view)

    {
        Intent intent = new Intent(this,GuestINRecords.class);
        startActivity(intent);
    }
}
