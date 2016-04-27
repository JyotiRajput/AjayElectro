package com.example.experthp.ajayelectro.Model;

import android.app.Fragment;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.experthp.ajayelectro.Adapter.ProductGridAdapter;
import com.example.experthp.ajayelectro.R;

import java.util.ArrayList;

/**
 * Created by expert HP on 27/04/2016.
 */
public class Graphtec_CAT1_Fragment extends Fragment {

        GridView grid;
        private String[] GridTitles;
        private String[] GridPrice;
        private TypedArray GridIcons;
        private ProductGridAdapter productGridadapter;
        private ArrayList<GridProductIMG> gridItem;

        public Graphtec_CAT1_Fragment() {
    }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.graphtec_cat1_fragment, container, false);
        grid = (GridView) rootView.findViewById(R.id.gridview);
        GridTitles = getResources().getStringArray(R.array.graphtec_cat1_name);
        GridPrice = getResources().getStringArray(R.array.grid_price);
        GridIcons = getResources().obtainTypedArray(R.array.graphtec_cat1_icon);

        //Log.d("hello", GridTitles[1]);
        gridItem = new ArrayList<GridProductIMG>();
        gridItem.add(new GridProductIMG(GridIcons.getResourceId(0, -1), GridTitles[0], GridPrice[0]));
        gridItem.add(new GridProductIMG(GridIcons.getResourceId(1, -1), GridTitles[1], GridPrice[1]));
        gridItem.add(new GridProductIMG(GridIcons.getResourceId(2, -1), GridTitles[2], GridPrice[2]));
        gridItem.add(new GridProductIMG(GridIcons.getResourceId(3, -1), GridTitles[3], GridPrice[3]));
        gridItem.add(new GridProductIMG(GridIcons.getResourceId(4, -1), GridTitles[4], GridPrice[4]));
        GridIcons.recycle();
        productGridadapter = new ProductGridAdapter(getActivity(), gridItem);


        //GridView gridview = (GridView) rootView.findViewById(R.id.gridview);
        grid.setAdapter(productGridadapter);

        return rootView;

    }

    }
