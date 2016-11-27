package com.example.astorga.testapp.classes;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.astorga.testapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASTORGA on 26/11/2016.
 */

public class AsyncClass extends AsyncTask<String, Character, Void> {
    private View frag;
    private static final String TAG = "AsyncClass";
    public AsyncClass(View frag) {
        super();
        this.frag = frag;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Toast.makeText(frag.getContext(),"El proceso de deletro termino", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onProgressUpdate(Character... values) {
        Character c = values[0];
        TextView txt= (TextView)frag.findViewById(R.id.lblNumero);
        txt.setText(c.toString());
    }

    @Override
    protected void onCancelled(Void aVoid) {
        super.onCancelled(aVoid);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    @Override
    protected Void doInBackground(String... strings) {
        if(strings.length == 1)
        {
            String ax = strings[0];
            for(Character c: ax.toCharArray())
            {
                Log.i(TAG,"Se mando la letra: " + c.toString());
                publishProgress(c);

                try{
                    Thread.sleep(1000);
                }
                catch (Exception e){
                    Log.e(TAG,"Ocurrión un error dentro del ciclo",e);
                }
            }
        }
        return null;
    }
}
