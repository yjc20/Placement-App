package com.android.letsgetplaced;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomAdapter extends BaseAdapter {
    String [] result;
    Context context;
    int [] imageId;
    private static LayoutInflater inflater=null;
    public CustomAdapter(MainActivity mainActivity, String[] osNameList, int[] osImages) {
        // TODO Auto-generated constructor stub
        result=osNameList;
        context=mainActivity;
        imageId=osImages;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        return null;
//    }

//    public class Holder
//    {
//        TextView os_text;
//        ImageView os_img;
//    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
//        Holder holder=new Holder();
        View rowView;
//        String[] Company={"COMPANY LIST","UPDATE PROFILE","VIEW NOTIFICATIONS","GENERATE RESUME"};
//
//        int[] images={R.drawable.company,R.drawable.update,R.drawable.notify,R.drawable.projresume};

        rowView = inflater.inflate(R.layout.row_data, null);
        TextView company=rowView.findViewById(R.id.companylist);
        ImageView imageView=rowView.findViewById(R.id.company);

        company.setText(result[position]);
        imageView.setImageResource(imageId[position]);
//        holder.os_text =(TextView) rowView.findViewById(R.id.os_texts);
//        holder.os_img =(ImageView) rowView.findViewById(R.id.os_images);
//
//        holder.os_text.setText(result[position]);
//        holder.os_img.setImageResource(imageId[position]);

        rowView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_SHORT).show();
            }
        });

        return rowView;
    }
}
