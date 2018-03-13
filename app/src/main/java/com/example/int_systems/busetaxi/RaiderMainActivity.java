package com.example.int_systems.busetaxi;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.int_systems.busetaxi.*;

public class RaiderMainActivity extends AppCompatActivity {
    static final int REQUEST_LOCATION = 1;
    LocationManager locationManager;
    boolean GpsStatus ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raider_main);

        GPSStatus();

        if(GpsStatus == true)
        {
            System.out.println("GPS ENABLED");
        }else
        {
          System.out.println("GPS NOT ENABLED");
        }
       Intent intent1 = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        startActivity(intent1);
    }

    public void GPSStatus(){
        GpsStatus = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

    }




}



