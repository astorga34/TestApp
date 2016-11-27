package com.example.astorga.testapp.classes;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.astorga.testapp.R;

/**
 * Created by ASTORGA on 26/11/2016.
 */

public class HandlerNumber {
    private View frag;
    private static final String TAG = "HandlerNumber";
    public HandlerNumber(View frag)
    {
        this.frag = frag;
    }
    public  Handler mHandler= new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message inputMessage) {
            if(inputMessage.obj != null)
            {
                if(inputMessage.obj instanceof Character)
                {
                    Character c = (Character) inputMessage.obj;
                    TextView txt= (TextView)frag.findViewById(R.id.lblNumero);
                    txt.setText(c.toString());
                    Log.i(TAG,"Se mostro la letra: " + c.toString());
                }
            }
        }
    };
}
