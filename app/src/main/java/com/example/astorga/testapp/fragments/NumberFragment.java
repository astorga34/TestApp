package com.example.astorga.testapp.fragments;

import android.content.AsyncQueryHandler;
import android.content.Context;
import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.astorga.testapp.R;
import com.example.astorga.testapp.classes.AsyncClass;
import com.example.astorga.testapp.classes.HandlerNumber;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NumberFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link NumberFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NumberFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final String  TAG = "Number Fragment";
    private View frag;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public NumberFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NumberFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NumberFragment newInstance(String param1, String param2) {
        NumberFragment fragment = new NumberFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragment = inflater.inflate(R.layout.fragment_number, container, false) ;
        frag = fragment;
        return fragment;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void iniciarProceso(String number)
    {
        Log.e(TAG,"Llego la llamada de iniciarProceso con parametro : " + number);
        TextView txt= (TextView)frag.findViewById(R.id.lblNumero);
        txt.setText("Numero");
        AsyncClass task = new AsyncClass(this.frag);
        task.execute(number);
    }

   /* public void iniciarProceso(String number)
    {
        Log.e(TAG,"Llego la llamada de iniciarProceso con parametro : " + number);
        TextView txt= (TextView)frag.findViewById(R.id.lblNumero);
        txt.setText("Numero");
        final String number_th = number;
        final HandlerNumber HN = new HandlerNumber(this.frag);

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run(){
                for(char cs: number_th.toCharArray())
                {
                    try{
                        Character ax = cs;
                        Message msg = new Message();
                        msg.obj = ax;
                        HN.mHandler.sendMessage(msg);
                        Thread.sleep(5000);
                    }
                    catch (Exception e){
                        Log.e(TAG,"Ocurrión un error dentro del ciclo",e);
                    }
                }
            }
        });
    }
    */


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
