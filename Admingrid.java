package com.android.letsgetplaced;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

@SuppressLint("Registered")
public class Admingrid extends AppCompatActivity {
    GridView grid;
    String[] Create={"CREATE EVENT","DELETE EVENT","VIEW COMPANY","VIEW MASTERDATA","SEND NOTIFICATIONS","MAKE REPORT"};

    int[] imgs={R.drawable.create,R.drawable.delete,R.drawable.masterdata,R.drawable.view,R.drawable.send,R.drawable.report1};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admingrid);

        grid=(GridView)findViewById(R.id.gridview1);


        CustomAdapter customAdapter=new CustomAdapter();

        grid.setAdapter(customAdapter);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getApplicationContext(),Admingridview.class);
                intent.putExtra("create",Create[position]);
                intent.putExtra("img",imgs[position]);
                startActivity(intent);
            }
        });
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
            @SuppressLint({"ViewHolder", "InflateParams"}) View view=getLayoutInflater().inflate(R.layout.rowdata,null);

            TextView create=view.findViewById(R.id.create);
            ImageView img=view.findViewById(R.id.event);

            create.setText(Create[position]);
            img.setImageResource(imgs[position]);
            return view;
        }

    }
}


