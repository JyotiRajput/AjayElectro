package com.example.experthp.ajayelectro.Model;

import android.app.Fragment;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.experthp.ajayelectro.Adapter.ProductGridAdapter;
import com.example.experthp.ajayelectro.R;

import java.util.ArrayList;

/**
 * Created by expert HP on 11/28/2015.
 */
public class Product1Fragment extends Fragment

{
    GridView grid;
    private String[] GridTitles;
    private String[] GridPrice;
    private TypedArray GridIcons;
    private ProductGridAdapter productGridadapter;
    private ArrayList<GridProductIMG> gridItem;

    public Product1Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.product1fragment, container, false);
        grid = (GridView) rootView.findViewById(R.id.gridview);
        GridTitles = getResources().getStringArray(R.array.nav_drawer_items);
        GridPrice = getResources().getStringArray(R.array.grid_price);
        GridIcons = getResources().obtainTypedArray(R.array.nav_drawer_icons);

        Log.d("hello",GridTitles[1]);
        gridItem = new ArrayList<GridProductIMG>();

        gridItem.add(new GridProductIMG(GridIcons.getResourceId(0, -1), GridTitles[0], GridPrice[0]));// Find People
        gridItem.add(new GridProductIMG(GridIcons.getResourceId(1, -1), GridTitles[1], GridPrice[1]));// Photos
        gridItem.add(new GridProductIMG(GridIcons.getResourceId(2, -1), GridTitles[2], GridPrice[2]));// Communities
        gridItem.add(new GridProductIMG(GridIcons.getResourceId(3, -1), GridTitles[3], GridPrice[3]));// Communities
        gridItem.add(new GridProductIMG(GridIcons.getResourceId(4, -1), GridTitles[4], GridPrice[4]));// Communities
        GridIcons.recycle();
        productGridadapter = new ProductGridAdapter(getActivity(), gridItem);


        //GridView gridview = (GridView) rootView.findViewById(R.id.gridview);
        grid.setAdapter(productGridadapter);

        return rootView;

    }
}
