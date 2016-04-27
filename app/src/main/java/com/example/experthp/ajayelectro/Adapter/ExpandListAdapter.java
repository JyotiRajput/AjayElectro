package com.example.experthp.ajayelectro.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.experthp.ajayelectro.Model.NavDrawerItem;
import com.example.experthp.ajayelectro.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by expert HP on 25-Feb-2016.
 */
public class ExpandListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, ArrayList<NavDrawerItem>> _listDataChild;

    public ExpandListAdapter(Context context, List<String> listDataHeader,
                                 HashMap<String, ArrayList<NavDrawerItem>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final NavDrawerItem childitem = (NavDrawerItem) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_view_item, null);
        }

        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.title);

        imgIcon.setImageResource(childitem.getIcon());
        txtTitle.setText(childitem.getTitle());

        // displaying count
        // check whether it set visible or not


        return convertView;

    }

    @Override
    public int getChildrenCount(int groupPosition) {
        if (groupPosition == 0 || groupPosition == 1 || groupPosition == 3) {
            return 0;
        }
            else {
            return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                    .size();
        }
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group, null);
        }
        ImageView icon= (ImageView) convertView.findViewById(R.id.icon);
        if (groupPosition==0 || groupPosition==1 || groupPosition==3)
            icon.setVisibility(View.INVISIBLE);
        else
        icon.setVisibility(View.VISIBLE);

        if(isExpanded)
        {

            icon.setImageResource(R.drawable.up);
        }
        else
        {icon.setImageResource(R.drawable.down);}

        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.lblListHeader);
        lblListHeader.setTypeface(null, Typeface.NORMAL);
        lblListHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
