package com.example.int_systems.busetaxi;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Toast;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class RiderMain extends AppCompatActivity  {

    String panic = "TRUE";
    private ProgressDialog progress;
    AsyncHttpClient client = new AsyncHttpClient();
    RequestParams params = new RequestParams();

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rider_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                open();
            }

        });
    }

    public void open(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle(R.string.alert_tiltle);
        alertDialogBuilder.setIcon(R.drawable.ic_error_alert);
        alertDialogBuilder.setMessage(R.string.decision);
        alertDialogBuilder.setPositiveButton(R.string.positive_button,
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                      sendPanic();


                    }

                    private void sendPanic() {

                        params.put("panic", panic);
                        client.post("http://10.0.2.2/BuseTaxi/panic.php", params, new TextHttpResponseHandler() {
                            @Override
                            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

                                Toast.makeText(RiderMain.this, "Emergency Contacted ", Toast.LENGTH_SHORT).show();


                                //   negative();
                            }

                            @Override
                            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                                // return responseString;
                                Toast.makeText(RiderMain.this, "Emergency Contacted ", Toast.LENGTH_SHORT).show();

                            }


                        });
                    }
                });
        alertDialogBuilder.setNegativeButton(R.string.negative_button,
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(RiderMain.this,"Panic Button Deactivated",Toast.LENGTH_LONG).show();

                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }


}
