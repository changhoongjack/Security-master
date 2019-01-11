package com.example.jack.security;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ContractorAdapter extends RecyclerView.Adapter<ContractorAdapter.myViewHolder> {

    Context context;
    ArrayList<ContractorDetails> contractorDetails;
    private OnItemClickListener mListener;

    public interface OnItemClickListener
    {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener)
    {
        mListener = listener;
    }

    public ContractorAdapter(Context c, ArrayList<ContractorDetails> b)
    {
        context=c;
        contractorDetails = b;
    }
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new myViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_contractor,viewGroup,false),mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int i) {
        holder.textViewDateTime.setText(contractorDetails.get(i).getINdate()+" "+contractorDetails.get(i).getINtime());
        holder.textViewGuard.setText(contractorDetails.get(i).getGuardID());
        holder.textViewCompany.setText(contractorDetails.get(i).getCompany());
        holder.textViewAddress.setText(contractorDetails.get(i).getAddress());
        holder.textViewName.setText(contractorDetails.get(i).getContractorName());
        holder.textViewIC.setText(contractorDetails.get(i).getContractorIC());
    }

    @Override
    public int getItemCount() {

        return contractorDetails.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        TextView textViewIC,textViewName,textViewCompany,textViewAddress,textViewGuard,textViewDateTime;
        public myViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            textViewIC=itemView.findViewById(R.id.textViewIC2);
            textViewAddress=itemView.findViewById(R.id.textViewAddress);
            textViewName = itemView.findViewById(R.id.textViewName2);
            textViewCompany=itemView.findViewById(R.id.textViewSecurity);
            textViewGuard = itemView.findViewById(R.id.textViewGuard);
            textViewDateTime = itemView.findViewById(R.id.checkINtime2);
        }
    }
}
