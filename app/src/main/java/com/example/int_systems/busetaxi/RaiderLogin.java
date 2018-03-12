package com.example.int_systems.busetaxi;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.*;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class RaiderLogin extends AppCompatActivity implements View.OnClickListener {


    // CONNECTION_TIMEOUT and READ_TIMEOUT are in milliseconds

   TextView txt2;
    private EditText etEmail;
    private EditText etPassword;
    Button btnSignin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raider_login);

        // Get Reference to variables
        etEmail = (EditText) findViewById(R.id.etemail);
        etPassword = (EditText) findViewById(R.id.etpassword);
         txt2 = (TextView) findViewById(R.id.textViewSignin);

        btnSignin = (Button) findViewById(R.id.btn_login);
        btnSignin.setOnClickListener(this);
         txt2.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        if (view==btnSignin){

            Signin();
        }
        if (view==txt2){
            Intent intent = new Intent(RaiderLogin.this,RaiderRegistration.class);
            RaiderLogin.this.startActivity(intent);
        }
    }

    private void Signin() {

        String email =etEmail.getText().toString();
        String password = etPassword.getText().toString();

        if (email.contentEquals("") || password.contentEquals("")){
            Toast.makeText(RaiderLogin.this,"Fill in all the Feilds", Toast.LENGTH_LONG).show();

        }
        else{
            //Initialising progress dialog
            final ProgressDialog progressDialog= new ProgressDialog(RaiderLogin.this);

            progressDialog.setTitle("Signing in");
            progressDialog.setMessage("Please wait");
            progressDialog.setCancelable(true);
            progressDialog.show();

            AsyncHttpClient client = new AsyncHttpClient();
            RequestParams params = new RequestParams();
            params.put("Email", email);
            params.put("Password",password);
            client.post("http://10.0.2.2/BuseTaxi/login.php", params, new TextHttpResponseHandler() {
                @Override
                public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                    progressDialog.dismiss();
                    Toast.makeText(RaiderLogin.this,"Login Failed",Toast.LENGTH_LONG);

                }

                @Override
                public void onSuccess(int statusCode, Header[] headers, String result) {

                    Toast.makeText(RaiderLogin.this, "Successfull", Toast.LENGTH_LONG).show();

                    progressDialog.dismiss();
                    if(result.equalsIgnoreCase("true"))
                    {
                /* Here launching another activity when login successful. If you persist login state
                use sharedPreferences of Android. and logout button to clear sharedPreferences.
                 */

                    }else // If username and password does not match display a error message
                        if (result.equalsIgnoreCase("false"))
                            Toast.makeText(RaiderLogin.this, "Invalid email or password", Toast.LENGTH_LONG).show();
                        else if (result.equalsIgnoreCase("exception") || result.equalsIgnoreCase("unsuccessful")) {

                            Toast.makeText(RaiderLogin.this, "OOPs! Something went wrong. Connection Problem.", Toast.LENGTH_LONG).show();

                        }

                }
            });
            }
        }

    }




