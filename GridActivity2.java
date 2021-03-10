package com.android.letsgetplaced;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ListView;

public class GridActivity2 extends AppCompatActivity {

    TextView company;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid2);

        company=findViewById(R.id.griddata);
        imageView=findViewById(R.id.img1);

        Intent intent=getIntent();
        company.setText(intent.getStringExtra("company"));
        imageView.setImageResource(intent.getIntExtra("imageView",0));
    }
}
