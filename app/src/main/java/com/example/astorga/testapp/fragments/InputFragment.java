package com.example.astorga.testapp.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.astorga.testapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * Use the {@link InputFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InputFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final String  TAG = "Input Fragment";
    private FromInputToMain mActivity;
    private View frag;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public InputFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InpuFragmen.
     */
    // TODO: Rename and change types and number of parameters
    public static InputFragment newInstance(String param1, String param2) {
        InputFragment fragment = new InputFragment();
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

        View fragment = inflater.inflate(R.layout.fragment_inpu, container, false) ;
        //Creamos aqui el evento
        Button button = (Button) fragment.findViewById(R.id.btn_generar);
        frag = fragment;
        button.setOnClickListener(clickEvent);
        return fragment;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FromInputToMain)
        {
            mActivity = (FromInputToMain)context;
        }
        else
        {
            throw new ClassCastException();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mActivity = null;
    }

    private View.OnClickListener clickEvent = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //Creamos aqui el evento
            EditText txtBox = (EditText) frag.findViewById(R.id.txtNumber);
            String resultado = "";
            resultado = txtBox.getText().toString();
            Log.e(TAG,"Se genero el evento del boton de generar del fragmento InputFragment con valor: " + resultado);
            if(mActivity != null)
            {
                if(resultado != null && !resultado.equals(""))
                {
                    mActivity.sendNumber(resultado);
                }
                else
                {
                    Toast.makeText(getActivity(),"Debe introducir un numero, por favor", Toast.LENGTH_LONG).show();
                }

            }
            else
            {
                throw  new NullPointerException();
            }
        }
    };

    public interface FromInputToMain{
        public void sendNumber(String number);
    }
}
