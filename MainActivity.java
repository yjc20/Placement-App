package com.android.letsgetplaced;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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

@SuppressLint("Registered")
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    GridView gridView;
    String[] Company = {"COMPANY LIST", "UPDATE PROFILE", "VIEW NOTIFICATIONS", "GENERATE RESUME"};

    int[] images = {R.drawable.company, R.drawable.update, R.drawable.notify, R.drawable.projresume};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        gridView = (GridView) findViewById(R.id.gridview1);
        //    gridView.setAdapter(new CustomAdapter(GridActivity.this, Company, images));

        CustomAdapter customAdapter = new CustomAdapter();

        gridView.setAdapter(customAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), GridActivity2.class);
                intent.putExtra("company", Company[position]);
                intent.putExtra("imageView", images[position]);
                startActivity(intent);
            }
        });


    }


    @Override
    public void onBackPressed() {
        //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //if (drawer.isDrawerOpen(GravityCompat.START)) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Do you want to logout?");


            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent in =new Intent(MainActivity.this,LoginpageActivity.class);
                    startActivity(in);


                    finish();

                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });

            AlertDialog a = builder.create();
            a.setTitle("Exit");
            a.show();
            /*drawer.closeDrawer(GravityCompat.START);

        } else {
            super.onBackPressed();
        }*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.list) {
            Intent list = new Intent(this, Companylist.class);
            startActivity(list);

        } else if (id == R.id.notify) {
            Intent notify = new Intent(this, ViewNotifications.class);
            startActivity(notify);

        } else if (id == R.id.profile) {
            Intent profile = new Intent(this, UpdateProfile.class);
            startActivity(profile);

        } else if (id == R.id.legacy) {
            Intent legacy = new Intent(this, Legacy.class);
            startActivity(legacy);

        } else if (id == R.id.about) {
            Intent about = new Intent(this, LetsGetPlaced.class);
            startActivity(about);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return images.length;
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
            @SuppressLint({"ViewHolder", "InflateParams"}) View view = getLayoutInflater().inflate(R.layout.row_data, null);

            TextView company = view.findViewById(R.id.companylist);
            ImageView imageView = view.findViewById(R.id.company);

            company.setText(Company[position]);
            imageView.setImageResource(images[position]);
            return view;


        }
    }
}
