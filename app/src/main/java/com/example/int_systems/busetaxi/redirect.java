package com.example.int_systems.busetaxi;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class redirect extends AppCompatActivity {
    DatabaseClass myDb;
    String driverAccessID="1";
    String raiderAccessID="2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redirect);
        myDb=new DatabaseClass(this);


        Cursor res = myDb.getAccessID();
        res.moveToFirst();

        if(res.getCount() == 0) {
            // show message
            Toast.makeText(redirect.this,"no profile found",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(redirect.this,options.class);
            redirect.this.startActivity(intent);
            return;
        }

        //if id is 1 its means the user is a raider;
      else{
            String id =res.getString(0);
            if (id== raiderAccessID){

                Intent intent = new Intent(redirect.this,RaiderMainActivity.class);
                redirect.this.startActivity(intent);

            }

            else {

                Intent intent = new Intent(redirect.this,RaiderMainActivity.class);
                redirect.this.startActivity(intent);
            }
        }


    }


}



