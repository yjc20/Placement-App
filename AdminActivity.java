package com.android.letsgetplaced;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class AdminActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    GridView grid;
    String[] Create = {"CREATE EVENT", "DELETE EVENT", "VIEW COMPANY", "VIEW MASTERDATA", "SEND NOTIFICATIONS", "MAKE REPORT"};

    int[] imgs = {R.drawable.create, R.drawable.delete, R.drawable.masterdata, R.drawable.view, R.drawable.send, R.drawable.report1};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        grid = (GridView) findViewById(R.id.gridview);


        CustomAdapter customAdapter = new CustomAdapter();

        grid.setAdapter(customAdapter);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), Admingridview.class);
                intent.putExtra("create", Create[position]);
                intent.putExtra("img", imgs[position]);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.admin, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.cevent) {
            Intent i=new Intent(this,Event.class);
            startActivity(i);
        } else if (id == R.id.vcompany) {
            Intent i=new Intent(this, com.android.letsgetplaced.View.class);
            startActivity(i);
        } else if (id == R.id.vmaster) {
            Intent i=new Intent(this,Masterdata.class);
            startActivity(i);
        } else if (id == R.id.snotify) {
            Intent i=new Intent(this,Notifiactions.class);
            startActivity(i);
        } else if (id == R.id.mreport) {
            Intent i=new Intent(this,Report.class);
            startActivity(i);

        } else if (id == R.id.devent) {
            Intent i=new Intent(this,Delete.class);
            startActivity(i);

        }else if (id == R.id.legacy) {
            Intent i=new Intent(this,Legacy.class);
            startActivity(i);

        }else if (id == R.id.lgp) {
            Intent i=new Intent(this,LetsGetPlaced.class);
            startActivity(i);

        }else if (id == R.id.help) {
            Intent i=new Intent(this,Help.class);
            startActivity(i);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return imgs.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            @SuppressLint({"ViewHolder", "InflateParams"}) View view = getLayoutInflater().inflate(R.layout.rowdata, null);

            TextView create = view.findViewById(R.id.create);
            ImageView img = view.findViewById(R.id.event);

            create.setText(Create[position]);
            img.setImageResource(imgs[position]);
            return view;
        }

    }
}
