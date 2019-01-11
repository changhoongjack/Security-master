package com.example.jack.security;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class GuestAdapter extends RecyclerView.Adapter<GuestAdapter.myViewHolder> {

    Context context;
    ArrayList<GuestDetails> guestDetails;
    private OnItemClickListener mListener;

    public interface OnItemClickListener
    {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener)
    {
        mListener = listener;
    }

    public GuestAdapter(Context c, ArrayList<GuestDetails> b)
    {
        context=c;
        guestDetails = b;
    }
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new myViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_guest_in,viewGroup,false),mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int i) {
        holder.textViewDateTime.setText(guestDetails.get(i).getINdate()+" "+guestDetails.get(i).getINtime());
        holder.textViewGuard.setText(guestDetails.get(i).getSecurity());
        holder.textViewPlate.setText(guestDetails.get(i).getGuestCar());
        holder.textViewName.setText(guestDetails.get(i).getGuestName());
        holder.textViewIC.setText(guestDetails.get(i).getGuestIC());
    }

    @Override
    public int getItemCount() {

        return guestDetails.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        TextView textViewIC,textViewName,textViewPlate,textViewAddress,textViewGuard,textViewDateTime;
        public myViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            textViewIC=itemView.findViewById(R.id.textViewIC2);
            textViewName = itemView.findViewById(R.id.textViewName2);
            textViewPlate=itemView.findViewById(R.id.textViewPlate2);
            textViewGuard = itemView.findViewById(R.id.textViewGuard2);
            textViewDateTime = itemView.findViewById(R.id.checkINtime2);
        }
    }
}
