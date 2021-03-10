package com.android.letsgetplaced;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Admingridview extends AppCompatActivity {

    TextView create;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admingridview);

        create=findViewById(R.id.griddata1);
        img=findViewById(R.id.img2);

        Intent intent=getIntent();
        create.setText(intent.getStringExtra("create"));
        img.setImageResource(intent.getIntExtra("img",0));
    }
}