package com.example.tony_laptop.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

/**
 * Created by Tony_Laptop on 2/17/2018.
 */

public class ImageAdapter extends BaseAdapter {

    private Context mContext;
    private String[] mThumbIds;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView img;
        if (convertView == null) {
            img = new ImageView(mContext);
            img.setLayoutParams(new GridView.LayoutParams(85, 85));
            img.setScaleType(ImageView.ScaleType.CENTER_CROP);
            img.setPadding(8, 8, 8, 8);
        } else {
            img = (ImageView) convertView;
        }

        String url = (String) getItem(position);
        Picasso.with(mContext).load(url).placeholder(R.mipmap.ic_launcher).fit().centerCrop().into(img);
        img.setImageResource(mThumbIds[position]);
        return img;
    }
}
