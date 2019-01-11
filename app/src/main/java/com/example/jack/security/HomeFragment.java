package com.example.jack.security;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HomeFragment extends Fragment {
    Button btnRegister,btnInOut,btnVerify,btnDutyRecord;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        btnRegister = (Button) view.findViewById(R.id.btnRegister);
        btnInOut = (Button) view.findViewById(R.id.btnINOUT);
        btnVerify=view.findViewById(R.id.btnCheckPin);
        btnDutyRecord = view.findViewById(R.id.btnDutyRecord);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ContractorRegister.class);
                startActivity(intent);
            }
        });

        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),VerifyClass.class);
                startActivity(intent);
            }
        });
        btnInOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),INrecords.class);
                startActivity(intent);
            }
        });

        btnDutyRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),DutyReport.class);
                startActivity(intent);
            }
        });

        return view;

    }

}
