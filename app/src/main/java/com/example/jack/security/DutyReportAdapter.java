package com.example.jack.security;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class DutyReportAdapter extends RecyclerView.Adapter<DutyReportAdapter.myViewHolder> {

    Context context;
    ArrayList<DutyReportDetails> dutyReportDetails;
    private OnItemClickListener mListener;

    public interface OnItemClickListener
    {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener)
    {
        mListener = listener;
    }

    public DutyReportAdapter(Context c, ArrayList<DutyReportDetails> b)
    {
        context=c;
        dutyReportDetails = b;
    }
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new myViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_dutyreport,viewGroup,false),mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int i) {
        holder.textViewSecurity.setText(dutyReportDetails.get(i).getSecurity());
        holder.checkIN.setText(dutyReportDetails.get(i).getCheckINdate()+" "+dutyReportDetails.get(i).getCheckINtime());
        holder.checkOUT.setText(dutyReportDetails.get(i).getCheckOutdate()+" "+dutyReportDetails.get(i).getCheckOuttime());
    }

    @Override
    public int getItemCount() {

        return dutyReportDetails.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        TextView textViewSecurity,checkIN,checkOUT;
        public myViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            textViewSecurity = itemView.findViewById(R.id.textViewSecurity);
            checkIN = itemView.findViewById(R.id.textViewName2);
            checkOUT = itemView.findViewById(R.id.textViewIC2);
        }
    }
}
