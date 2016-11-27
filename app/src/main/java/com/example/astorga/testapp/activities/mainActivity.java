package com.example.astorga.testapp.activities;


import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.astorga.testapp.fragments.*;

import com.example.astorga.testapp.R;


public class mainActivity extends AppCompatActivity implements InputFragment.FromInputToMain,NumberFragment.OnFragmentInteractionListener {

    public static final String  TAG = "mainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void sendNumber(String number) {
        Log.e(this.TAG, "Se recibio el numero : " + number);
        NumberFragment numberFragment = (NumberFragment)getSupportFragmentManager().findFragmentById(R.id.fragment_number);
        if(null != numberFragment  && numberFragment.isInLayout())
        {
            //numberFragment;
            numberFragment.iniciarProceso(number);
        }
        else
        {
            throw new NullPointerException();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
