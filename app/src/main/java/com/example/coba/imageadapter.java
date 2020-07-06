package com.example.coba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class imageadapter extends BaseAdapter {

    private Context mContext;

    public int[] imageArray = {

            R.drawable.chef1, R.drawable.chef2, R.drawable.ker1, R.drawable.ker2, R.drawable.ker3, R.drawable.ker4, R.drawable.ker5,
            R.drawable.ancol1, R.drawable.ancol2, R.drawable.futsal, R.drawable.pic4, R.drawable.pic5, R.drawable.pic7, R.drawable.pic8,
            R.drawable.pic9, R.drawable.shalat1, R.drawable.toga1, R.drawable.toga2
    };

    public imageadapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return imageArray.length;
    }

    @Override
    public Object getItem(int position) {
        return imageArray[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(imageArray[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(340, 350));

        return imageView;
    }
}