package com.example.experthp.ajayelectro.Model;

/**
 * Created by expert HP on 11/28/2015.
 */
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.experthp.ajayelectro.R;

import java.util.ArrayList;
import java.util.List;


public class Home_Fragment extends Fragment {
   // Button dialog;
    //TextView txt1;
    Spinner Drop1;
    public Home_Fragment(){}


    TextView text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.home_fragment, container, false
        );
        text= (TextView) rootView.findViewById(R.id.txtLabel);
        text.setText("Home Fragment implementation is still pending");
        return rootView;

    }}

    /*@Override
    public void onActivityCreated (Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        //dialog=(Button)getActivity().findViewById(R.id.dialog1);
        //txt1=(TextView)getActivity().findViewById(R.id.txtLabel);
        Drop1=(Spinner)getActivity().findViewById(R.id.Dropdown);
        Drop1.setBackgroundResource(android.R.drawable.spinner_background);
        Drop1.setPopupBackgroundResource(android.R.drawable.spinner_dropdown_background);
        Drop1.setPrompt("Select one");
        Drop1.setOnItemSelectedListener(this);


        AlertDialog.Builder AltDialog=new AlertDialog.Builder(getActivity());
        AltDialog.setMessage("Are you sure to exit");
        AltDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Toast.makeText(getActivity(), "hello toast", Toast.LENGTH_LONG).show();
                getActivity().finish();
            }
        });
        AltDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //getActivity().finish();
                Toast.makeText(getActivity(), "go toast", Toast.LENGTH_LONG).show();
            }
        });
        //AlertDialog alt=AltDialog.create();
        //alt.show();


        List<String> items=new ArrayList<>();
        items.add("Machine1");
        items.add("Machine2");
        items.add("Machine3");
        items.add("Machine4");

        ArrayAdapter<String> Adptr=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,items);
        Adptr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Drop1.setAdapter(Adptr);




    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {

    }
}
*/







