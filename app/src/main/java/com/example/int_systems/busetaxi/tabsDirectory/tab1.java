package com.example.int_systems.busetaxi.tabsDirectory;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.int_systems.busetaxi.GoogleService;
import com.example.int_systems.busetaxi.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

/**
 * Created by Int-Systems on 3/20/2018.
 */
public class tab1 extends Fragment implements OnMapReadyCallback {
    protected static final  String Tag ="tab1";
    private Context globalContext = null;
    public View view;
    Geocoder geocoder;
    Double latitude,longitude;
    TextView tv_latitude, tv_longitude, tv_address,tv_area,tv_locality;
    Button btn_start;
    GoogleMap map;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        view = inflater.inflate(R.layout.tab1,container,false);


        btn_start = (Button) view. findViewById(R.id.btn_start);
        //tv_address = (TextView)view.  findViewById(R.id.tv_address);
        tv_latitude = (TextView) view.  findViewById(R.id.tv_latitude);
        tv_longitude = (TextView) view.  findViewById(R.id.tv_longitude);
        //tv_area = (TextView) view. findViewById(R.id.tv_area);
       // tv_locality = (TextView) view. findViewById(R.id.tv_locality);
        globalContext = this.getActivity();

     //   registerReceiver(broadcastReceiver, new IntentFilter(GoogleService.str_receiver));

        getService();
        return view;

    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            latitude = Double.valueOf(intent.getStringExtra("latutide"));
            longitude = Double.valueOf(intent.getStringExtra("longitude"));


            tv_latitude.setText(latitude+"");
            tv_longitude.setText(longitude+"");


        }


    };

    private void getService() {

            globalContext.registerReceiver(broadcastReceiver, new IntentFilter(GoogleService.str_receiver));
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        map.addMarker(new MarkerOptions()
                .position(new LatLng(0, 0))
                .title("Marker"));

    }
}
