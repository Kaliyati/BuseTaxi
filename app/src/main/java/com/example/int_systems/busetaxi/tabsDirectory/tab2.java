package com.example.int_systems.busetaxi.tabsDirectory;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.int_systems.busetaxi.GoogleService;
import com.example.int_systems.busetaxi.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Int-Systems on 3/20/2018.
 */
public class tab2 extends Fragment {
    View view;
    Context globalContext;
    List<taxiVehicle> productList;

    //the recyclerview
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        globalContext = this.getActivity();

        view = inflater.inflate(R.layout.tab2,container,false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(globalContext));

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
        vehiclAdapter adapter = new vehiclAdapter(globalContext, productList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);






        return view;


    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
           Double latitude = Double.valueOf(intent.getStringExtra("latutide"));
          Double  longitude = Double.valueOf(intent.getStringExtra("longitude"));

            AsyncHttpClient client = new AsyncHttpClient();
            RequestParams params = new RequestParams();
            params.put("latitude", latitude);
            params.put("longitude", longitude);
            client.post("http://10.0.2.2/BuseTaxi/getTaxi.php", params, new TextHttpResponseHandler() {

                @Override
                public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

                }

                @Override
                public void onSuccess(int statusCode, Header[] headers, String responseString) {

                }
            });



        };


    };

    private void getService() {

        globalContext.registerReceiver(broadcastReceiver, new IntentFilter(GoogleService.str_receiver));
    }
}
