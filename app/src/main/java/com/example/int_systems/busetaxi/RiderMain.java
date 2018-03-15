package com.example.int_systems.busetaxi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class RiderMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rider_main);
        Intent intent =new Intent(this,MyIntentService.class);
        startService(intent);


    }
}
