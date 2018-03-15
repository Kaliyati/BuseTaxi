package com.example.int_systems.busetaxi;

import android.Manifest;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

public class MyIntentService extends IntentService {
    LocationManager locationManager;


    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        for (int i=0; i<=5; i++){
            Log.v("Timer","Count"+ i);
        }try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000);

        }
        catch (InterruptedException e) {
            e.printStackTrace();
        } ;
//        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            return;
//        }
//        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//        if (location != null) {
//            double latti = location.getLatitude();
//            double longi = location.getLongitude();
//            System.out.println("+++++++++++++++++++++++");
//            System.out.println(latti);
//
//
//        }
//        else {
//            System.out.println("--------------------------------------------------");
//        }
    }

}



