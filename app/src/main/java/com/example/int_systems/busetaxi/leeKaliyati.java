package com.example.int_systems.busetaxi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.int_systems.busetaxi.tabsDirectory.taxiVehicle;
import com.example.int_systems.busetaxi.tabsDirectory.vehiclAdapter;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class leeKaliyati extends AppCompatActivity {
    //a list to store all the products
    List<taxiVehicle> productList;

    //the recyclerview
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lee_kaliyati);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        productList = new ArrayList<>();


        //adding some items to our list
        productList.add(
                new taxiVehicle(
                        1,
                        "Toyota ipsum - (1978 Sierra)",
                        "can carry 28 passangers",
                        2.3,
                        "AED 3902",
                        R.drawable.ipsum));

        productList.add(
                new taxiVehicle(
                        1,
                        "Honda fit (Release date 2001)",
                        "Certified to carry passangers ",
                        4.3,
                        "AAC 2346",
                        R.drawable.fit));

        productList.add(
                new taxiVehicle(
                        1,
                        "Toyota Raum (2007 version(White ))",
                        "ceritified to carry 5 passengers",
                        4.3,
                        "AFM 3476",
                        R.drawable.raumm));

        //creating recyclerview adapter
        vehiclAdapter adapter = new vehiclAdapter(this, productList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);



    }
}

