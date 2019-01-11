package com.example.jack.security;

import android.app.ProgressDialog;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SecurityVerify extends AppCompatActivity {

    //    public static final int CONNECTION_TIMEOUT=10000;
//    public static final int READ_TIMEOUT=15000;
    private EditText PIN;
    TextView result;
    TextView guestn, car, ic;
    Button pinsearch,btnChkIN;
    private ProgressDialog pd;
    String number;
    private RequestQueue mQueue;
    String guestName,guestIC,guestCar;
    DatabaseReference databaseReference;

    //private TextView checkTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_verify);

        databaseReference = FirebaseDatabase.getInstance().getReference("Security/GuestIN");
        btnChkIN = findViewById(R.id.btnChkIN);
        pinsearch = (Button) findViewById(R.id.btnVerify);
        guestn = (TextView) findViewById(R.id.guestn);
        car = (TextView) findViewById(R.id.car);
        ic = (TextView) findViewById(R.id.ic);
        mQueue = Volley.newRequestQueue(this);
        PIN = (EditText) findViewById(R.id.PINinput);
        pd = new ProgressDialog(SecurityVerify.this);
        pd.setMessage("loading");
        pd.setCancelable(false);
        pd.setCanceledOnTouchOutside(false);

        pinsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number = PIN.getText().toString().trim();
                if(number.isEmpty())
                {
                    Toast.makeText(SecurityVerify.this,"Please Enter PIN",Toast.LENGTH_LONG).show();
                }
                else {
                    jsonParse();
                }
            }

        });
        btnChkIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(guestn.getText().toString().isEmpty()||car.getText().toString().isEmpty()||ic.getText().toString().isEmpty())
                {
                    Toast.makeText(SecurityVerify.this,"Please Verify Guest details",Toast.LENGTH_LONG).show();
                }
                else
                    {
                        SharedPreferences sharedPreferences = getSharedPreferences("username",Context.MODE_PRIVATE);
                        String user = sharedPreferences.getString("TEXT","");
                        String dataID = databaseReference.push().getKey();
                        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                        Date today = Calendar.getInstance().getTime();
                        DateFormat df2 = new SimpleDateFormat("hh:mm a");
                        String INdate = df.format(today);
                        String INtime = df2.format(today);
                    GuestDetails guestDetails = new GuestDetails(guestName, guestIC, guestCar,INtime,INdate,user);
                    databaseReference.child(dataID).setValue(guestDetails);
                    Toast.makeText(SecurityVerify.this,"Successfully Verified",Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });
    }
    private void jsonParse()
    {
        String url = "https://projecttc.000webhostapp.com/PINVerification.php?otp=" + number;

        pd.show();

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,url,null, new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject response){
                try {

                    pd.hide();
                    JSONArray jsonArray = response.getJSONArray("Guest");

                    for(int i = 0; i < jsonArray.length(); i++){
                        JSONObject Guest = jsonArray.getJSONObject(i);

                       guestName = Guest.getString("guest_name");
                        guestCar = Guest.getString("car_plate");
                        guestIC = Guest.getString("guest_ic");

                        guestn.setText(guestName.toString());
                        car.setText(guestCar.toString());
                        ic.setText(guestIC.toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                error.printStackTrace();
                Toast.makeText(SecurityVerify.this, "Incorrect PIN", Toast.LENGTH_LONG).show();

                pd.hide();
            }
        });
            mQueue.add(request);
    }
}