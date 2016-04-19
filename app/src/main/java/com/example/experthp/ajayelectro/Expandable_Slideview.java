package com.example.experthp.ajayelectro;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.experthp.ajayelectro.Adapter.ExpandListAdapter;
import com.example.experthp.ajayelectro.Adapter.NavDrawerListAdapter;
import com.example.experthp.ajayelectro.Model.Home_Fragment;
import com.example.experthp.ajayelectro.Model.NavDrawerItem;
import com.example.experthp.ajayelectro.Model.Product1Fragment;
import com.example.experthp.ajayelectro.Model.Service1Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Expandable_Slideview extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ExpandableListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;

    // nav drawer title
    private CharSequence mDrawerTitle;

    // used to store app title
    private CharSequence mTitle;


    // slide menu items
    private String[] Graphtec_subitems;
    private String[] CAT1_items_Kikusui1;
    private String[] CAT2_items_Kikusui2;
    private String[] CAT3_items_Kikusui3;
    private TypedArray navMenuIcons;
    private List<String> groupitem;
    private HashMap<String, ArrayList<NavDrawerItem>> childitem;

    private ExpandListAdapter adapter;
    private Fragment Fragment_Container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable__slideview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mTitle = mDrawerTitle = getTitle();

        // load slide menu items
        Graphtec_subitems = getResources().getStringArray(R.array.graphtec_subitems);
        CAT1_items_Kikusui1 = getResources().getStringArray(R.array.CAT1_items_Kikusui);
        CAT2_items_Kikusui2= getResources().getStringArray(R.array.CAT2_items_Kikusui);
        CAT3_items_Kikusui3= getResources().getStringArray(R.array.CAT3_items_Kikusui);
        // nav drawer icons from resources
        navMenuIcons = getResources()
                .obtainTypedArray(R.array.nav_drawer_icons);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ExpandableListView) findViewById(R.id.list_slidermenu);
        //Fragment_Container=(Fragment) findViewById(R.id.frag_container);
        groupitem=new ArrayList<String>();
        groupitem.add("Home");
        groupitem.add("Our Products");
        groupitem.add("Graphtec Corp.,Japan");
        groupitem.add("Kikusui Electronics Corp.,Japan");
        groupitem.add("Power Electronics Equipments");
        groupitem.add("Test & Measurement Instruments");
        groupitem.add("App. Solution & Accessories");
        groupitem.add("Fujikura Ltd.Japan");
        groupitem.add("Kanomax,Japan");
        groupitem.add("Yueming Laser Machine");
        groupitem.add("Our Services & Products");

        childitem = new HashMap<String, ArrayList<NavDrawerItem>>();


        // adding Expandale group items to array
        //SubCat1_Graphtec
        ArrayList<NavDrawerItem> navDrawerItems1 = new ArrayList<NavDrawerItem>();
        navDrawerItems1.add(new NavDrawerItem(Graphtec_subitems[0], navMenuIcons.getResourceId(0, -1)));
        navDrawerItems1.add(new NavDrawerItem(Graphtec_subitems[1], navMenuIcons.getResourceId(1, -1)));
        navDrawerItems1.add(new NavDrawerItem(Graphtec_subitems[2], navMenuIcons.getResourceId(2, -1)));
        navDrawerItems1.add(new NavDrawerItem(Graphtec_subitems[3], navMenuIcons.getResourceId(3, -1), true, "22"));
        navDrawerItems1.add(new NavDrawerItem(Graphtec_subitems[4], navMenuIcons.getResourceId(4, -1)));

        // Subcat_Kikusui1
        ArrayList<NavDrawerItem> navDrawerItems2 = new ArrayList<NavDrawerItem>();
        navDrawerItems2.add(new NavDrawerItem(CAT1_items_Kikusui1[0], navMenuIcons.getResourceId(0, -1)));
        navDrawerItems2.add(new NavDrawerItem(CAT1_items_Kikusui1[1], navMenuIcons.getResourceId(1, -1)));
        navDrawerItems2.add(new NavDrawerItem(CAT1_items_Kikusui1[2], navMenuIcons.getResourceId(2, -1)));
        navDrawerItems2.add(new NavDrawerItem(CAT1_items_Kikusui1[3], navMenuIcons.getResourceId(3, -1), true, "22"));

        // // Subcat_Kikusui2
        ArrayList<NavDrawerItem> navDrawerItems3 = new ArrayList<NavDrawerItem>();
        navDrawerItems3.add(new NavDrawerItem(CAT2_items_Kikusui2[0], navMenuIcons.getResourceId(0, -1)));
        navDrawerItems3.add(new NavDrawerItem(CAT2_items_Kikusui2[1], navMenuIcons.getResourceId(1, -1)));
        navDrawerItems3.add(new NavDrawerItem(CAT2_items_Kikusui2[2], navMenuIcons.getResourceId(2, -1)));
        navDrawerItems3.add(new NavDrawerItem(CAT2_items_Kikusui2[3], navMenuIcons.getResourceId(3, -1), true, "22"));
        navDrawerItems3.add(new NavDrawerItem(CAT2_items_Kikusui2[4], navMenuIcons.getResourceId(3, -1), true, "22"));
        navDrawerItems3.add(new NavDrawerItem(CAT2_items_Kikusui2[5], navMenuIcons.getResourceId(3, -1), true, "22"));
        navDrawerItems3.add(new NavDrawerItem(CAT2_items_Kikusui2[6], navMenuIcons.getResourceId(3, -1), true, "22"));

        // Subcat_Kikusui3
        ArrayList<NavDrawerItem> navDrawerItems4 = new ArrayList<NavDrawerItem>();
        navDrawerItems4.add(new NavDrawerItem(CAT3_items_Kikusui3[0], navMenuIcons.getResourceId(0, -1)));
        navDrawerItems4.add(new NavDrawerItem(CAT3_items_Kikusui3[1], navMenuIcons.getResourceId(1, -1)));

        navMenuIcons.recycle();
        childitem.put(groupitem.get(2), navDrawerItems1);
        childitem.put(groupitem.get(4), navDrawerItems2);
        childitem.put(groupitem.get(5), navDrawerItems3);
        childitem.put(groupitem.get(6), navDrawerItems4);

        adapter = new ExpandListAdapter(this, groupitem, childitem);

        // setting list adapter
        mDrawerList.setAdapter(adapter);
        // Listview Group click listener
        mDrawerList.setGroupIndicator(null);

        mDrawerList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                if (groupPosition==0)
                {
                    displayView(0);
                    return true;
                }
                else if(groupPosition==1 || groupPosition==3)
                {
                    return true;
                }
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                else

                return false;
            }
        });

        // Listview Group expanded listener
        mDrawerList.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        groupitem.get(groupPosition) + " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Listview Group collasped listener
        mDrawerList.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        groupitem.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        mDrawerList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                displayView(childPosition);
                return false;
            }
        });

        // enabling action bar app icon and behaving it as toggle button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mDrawerToggle = new ActionBarDrawerToggle(Expandable_Slideview.this, mDrawerLayout,
                toolbar,
                R.string.drawer_open, // nav drawer open - description for accessibility
                R.string.drawer_close // nav drawer close - description for accessibility
        ) {
            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle(mTitle);
                // calling onPrepareOptionsMenu() to show action bar icons
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(mDrawerTitle);
                // calling onPrepareOptionsMenu() to hide action bar icons
                invalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        if (savedInstanceState == null) {
            // on first time display view for first nav item
            displayView(0);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_start, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // toggle nav drawer on selecting action bar app icon/title
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle action bar actions click
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /***
     * Called when invalidateOptionsMenu() is triggered
     */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // if nav drawer is opened, hide the action items
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    /**
     * Diplaying fragment view for selected nav drawer list item
     * */
    private void displayView(int position) {
        // update the main content by replacing fragments
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new Home_Fragment();
                break;
            case 1:
                fragment = new Home_Fragment();
                break;
            case 2:
                fragment = new Product1Fragment();
                break;
            case 3:

                fragment = new Service1Fragment();
                break;
            case 4:
                fragment = new Service1Fragment();
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.frag_container, fragment).commit();

            // update selected item and title, then close the drawer
            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(CAT2_items_Kikusui2[position]);
            mDrawerLayout.closeDrawer(mDrawerList);
        } else {
            // error in creating fragment
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }


    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("on", "onPostResume2");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("on", "onDestroy2");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("on", "onStop2");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("on", "onPause2");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("on", "onResume2");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("on", "onStart2");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("on", "onRestart2");
    }
}

