package com.example.findmyfuel;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewFuelRecord extends AppCompatActivity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_fuel_record);
        TextView nameTxt = findViewById(R.id.fuel_km);
        String Username = "UserName Not set";
        Bundle extras = getIntent().getExtras();
        if(extras !=  null){
            Username = extras.getString("username");
        }

        nameTxt.setText(Username);

    }
}
