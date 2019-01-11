package com.example.jack.security;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class UserProfile extends Fragment {


    DatabaseReference databaseReference,databaseDutyReport;
    TextView twName, twIC, twAddress,twEmail,twPhone;
    Button btnLogOut;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("username",Context.MODE_PRIVATE);
        final String user = sharedPreferences.getString("TEXT","");
        final String loginTime = sharedPreferences.getString("LoginTime","");
        databaseReference = FirebaseDatabase.getInstance().getReference("Security/SecurityInformation/"+user);
        databaseDutyReport = FirebaseDatabase.getInstance().getReference("Security/DutyReport/"+loginTime);
        btnLogOut =view.findViewById(R.id.btnLogOut);
        twName = view.findViewById(R.id.twName);
        twIC = view.findViewById(R.id.twIC);
        twEmail = view.findViewById(R.id.twEmail);
        twPhone = view.findViewById(R.id.twPhone);

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                Date today = Calendar.getInstance().getTime();
                DateFormat df2 = new SimpleDateFormat("hh:mm a");
                String checkOUTdate = df.format(today);
                String checkOUTtime = df2.format(today);
                databaseDutyReport.child("checkOutdate").setValue(checkOUTdate);
                databaseDutyReport.child("checkOuttime").setValue(checkOUTtime);
                SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor editor = settings.edit();
                editor.remove("username");
                editor.remove("LoginTime");
                Intent intent = new Intent(getActivity(),GuardInterface.class);
                getActivity().finish();
                startActivity(intent);
                Toast.makeText(getActivity(),"Successful Logout",Toast.LENGTH_LONG).show();
            }
        });
            databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                twName.setText(dataSnapshot.child("name").getValue().toString().trim());
                twIC.setText(dataSnapshot.child("ic").getValue().toString().trim());
                twEmail.setText(dataSnapshot.child("email").getValue().toString().trim());
                twPhone.setText(dataSnapshot.child("phone").getValue().toString().trim());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return view;
    }

}
