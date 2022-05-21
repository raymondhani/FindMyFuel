package com.example.findmyfuel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FuelRecords extends AppCompatActivity {
    private ArrayList<userlist> userslist;
    private RecyclerView recyclerView;
    private CustomAdapter.RecyclerViewClicklistener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fuel_records);
        recyclerView = findViewById(R.id.fuel_recycler);
        userslist = new ArrayList<>();
        setUerInfo();
        setAdaptor();
    }

    private void setAdaptor() {
        setOnClickListener();
        CustomAdapter adapter = new CustomAdapter(userslist,listener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setOnClickListener() {
        listener = new CustomAdapter.RecyclerViewClicklistener() {
            @Override
            public void onClick(View V, int position) {
                Intent intent = new Intent(getApplicationContext(),ViewFuelRecord.class);
                intent.putExtra("username",userslist.get(position).getUsername());
                startActivity(intent);
            }
        };
    }

    private void setUerInfo() {
        userslist.add(new userlist("John"));
        userslist.add(new userlist("Raymond"));
        userslist.add(new userlist("Michael"));
        userslist.add(new userlist("karim"));
        userslist.add(new userlist("Michael"));
        userslist.add(new userlist("Michael"));
        userslist.add(new userlist("Michael"));
        userslist.add(new userlist("Michael"));
        userslist.add(new userlist("Michael"));
        userslist.add(new userlist("Michael"));
        userslist.add(new userlist("Michael"));
        userslist.add(new userlist("Michael"));
        userslist.add(new userlist("Michael"));
        userslist.add(new userlist("Michael"));


    }
    public void addFloatingButton(View V){
        Intent intent = new Intent(FuelRecords.this,addFuelRecords.class);
        startActivity(intent);
    }
}