package com.example.experthp.ajayelectro.Model;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.experthp.ajayelectro.R;

/**
 * Created by expert HP on 11/28/2015.
 */
public class Service1Fragment extends Fragment

    {

        public Service1Fragment(){}

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.service1fragment, container, false);

        return rootView;
    }
}
