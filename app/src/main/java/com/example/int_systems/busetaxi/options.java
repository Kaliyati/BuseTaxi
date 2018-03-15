package com.example.int_systems.busetaxi;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class options extends AppCompatActivity implements View.OnClickListener {
    Button buttonRaider, buttonDriver;
    DatabaseClass myDb;
    String driverAccessID="1";
    String raiderAccessID="2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        buttonDriver =(Button) findViewById(R.id.btndriver);
        buttonRaider =(Button) findViewById(R.id.btnrider);

        buttonDriver.setOnClickListener(this);
        buttonRaider.setOnClickListener(this);

        myDb=new DatabaseClass(this);

    }

    @Override
    public void onClick(View view) {
        if (view ==buttonDriver){
            setDriver();

        }
        if (view== buttonRaider){

            setRider();
        }

    }

    private void setDriver() {
        boolean isInserted = myDb.createAccessLevel(
                driverAccessID.toString()

        );
        if(isInserted == true)
            Toast.makeText(options.this,"Profile successufully created",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(options.this,"An error occured", Toast.LENGTH_LONG).show();

    }
    //set the accoount type to raider

    private void setRider() {
        boolean isInserted = myDb.createAccessLevel(
                raiderAccessID.toString()

        );
        if(isInserted == true){
            Toast.makeText(options.this,"Profile successufully created",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(options.this,RiderMain.class);
            options.this.startActivity(intent);
        }

        else
            Toast.makeText(options.this,"An error occured", Toast.LENGTH_LONG).show();
    }


    //get user access level and automatically start the related activities

    }


