package com.example.jack.security;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ContractorRegister extends AppCompatActivity {
    EditText editTextIC;
    EditText editTextName;
    EditText editTextCompany;
    EditText editTextAddress;
    DatabaseReference databaseSecurity;
    String security;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contractor_registration);
        SharedPreferences sharedPreferences = getSharedPreferences("username",Context.MODE_PRIVATE);
        security = sharedPreferences.getString("TEXT","");
        databaseSecurity = FirebaseDatabase.getInstance().getReference("Security");
        editTextIC = findViewById(R.id.editTextIC);
        editTextName = findViewById(R.id.editTextName);
        editTextCompany = findViewById(R.id.editTextCompany);
        editTextAddress = findViewById(R.id.editTextAddress);

    }
    public void saveRecords(View view)
    {
        String name = editTextName.getText().toString().trim();
        String ic = editTextIC.getText().toString().trim();
        String company = editTextCompany.getText().toString().trim();
        String address = editTextAddress.getText().toString().trim();
        if(name.isEmpty()||ic.isEmpty()||address.isEmpty()||company.isEmpty())
        {
            Toast.makeText(this,"Please fill in all the details",Toast.LENGTH_LONG).show();
        }
        else
        {
            String dataID = databaseSecurity.push().getKey();
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            Date today = Calendar.getInstance().getTime();
            DateFormat df2 = new SimpleDateFormat("hh:mm a");
            String INdate = df.format(today);
            String INtime = df2.format(today);
            ContractorDetails details = new ContractorDetails(dataID,INdate,INtime,name,ic,company,address,security);
            databaseSecurity.child("ContractorIN").child(dataID).setValue(details);
            Toast.makeText(this,"Saved",Toast.LENGTH_LONG).show();
            finish();
        }
    }
}
