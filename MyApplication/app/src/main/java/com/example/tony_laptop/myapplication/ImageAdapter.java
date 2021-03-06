package com.example.tony_laptop.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tony_Laptop on 2/17/2018.
 */

public class ImageAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<String> mThumbIds;

    public ImageAdapter(Context c, ArrayList<String> resources) {
        mContext = c;
        mThumbIds = resources;
    }

    @Override
    public int getCount() {
        return mThumbIds.size();
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds.get(position);
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
            img.setLayoutParams(new GridView.LayoutParams(100, 100));
            //img.setScaleType(ImageView.ScaleType.CENTER_CROP);
            img.setPadding(1, 1, 1, 1);
        } else {
            img = (ImageView) convertView;
        }

        String url = (String) getItem(position);
        Picasso.with(mContext).load(url).fit().centerCrop().into(img);
        return img;
    }
}
