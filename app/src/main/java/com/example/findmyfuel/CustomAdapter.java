package com.example.findmyfuel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private ArrayList<userlist> userlist;
    private RecyclerViewClicklistener listener;


    public CustomAdapter(ArrayList<userlist> userlist , RecyclerViewClicklistener listener) {
        this.userlist = userlist;
        this.listener = listener;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView nameText;

        public MyViewHolder(final View itemView) {
            super(itemView);
            this.nameText = itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(itemView,getAdapterPosition());
        }
    }
    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fuel_record_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        String name = userlist.get(position).getUsername();
        holder.nameText.setText(name);
    }

    @Override
    public int getItemCount() {
        return userlist.size();
    }

    public interface RecyclerViewClicklistener{
        void onClick(View V,int position);
    }
}
