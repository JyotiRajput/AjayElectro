package com.example.experthp.ajayelectro.Adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.experthp.ajayelectro.Model.GridProductIMG;
import com.example.experthp.ajayelectro.R;

import java.util.ArrayList;

/**
 * Created by expert HP on 21-Feb-2016.
 */
public class ProductGridAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<GridProductIMG> gridItems;

    public ProductGridAdapter(Context context, ArrayList<GridProductIMG> gridItems){
        this.context = context;
        this.gridItems = gridItems;
    }
    @Override
    public int getCount() {
        return gridItems.size();
    }

    @Override
    public Object getItem(int position) {
        return gridItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.grid_product_layout, null);

        }
            ImageView imgIcon = (ImageView) convertView.findViewById(R.id.img);
            TextView txtTitle = (TextView) convertView.findViewById(R.id.tx1);
            TextView txtCount = (TextView) convertView.findViewById(R.id.tx2);
        Log.d("fragment", gridItems.get(1).getTitle());

        //convertView.setLayoutParams(new GridView.LayoutParams(200, 200));
        imgIcon.setImageResource(gridItems.get(position).getIcon());

            imgIcon.setScaleType(ImageView.ScaleType.CENTER_CROP);

        //


        txtTitle.setText(gridItems.get(position).getTitle());
            txtCount.setText(gridItems.get(position).getPrice());
            return convertView;
        }
    }
