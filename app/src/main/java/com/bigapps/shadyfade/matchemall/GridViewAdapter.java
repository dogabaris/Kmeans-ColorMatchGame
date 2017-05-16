package com.bigapps.shadyfade.matchemall;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Random;

/**
 * Created by shadyfade on 14.10.2015.
 */
public class GridViewAdapter extends BaseAdapter {
    ImageView imageview;
    private Context context;
    int zorluk,sira;

    public GridViewAdapter(Context c,int zorluk,int sira,List<Integer> RandomDizi) {
        this.context = c;
        this.zorluk = zorluk;
        this.sira = sira;
        this.RandomDizi = RandomDizi;
    }

    @Override
    public int getCount() {
        return RandomDizi.size();
    }

    @Override
    public Object getItem(int position) {
        System.out.println("Item Is :-" + RandomDizi.get(position).toString());
        return null;
    }

    @Override
    public long getItemId(int position) { return 0;   }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            imageview = new ImageView(context);
            if(zorluk==1)
                imageview.setLayoutParams(new GridView.LayoutParams(GridView.LayoutParams.MATCH_PARENT, 120));//y 60 da hard tam sığıyor
            if(zorluk==2)
                imageview.setLayoutParams(new GridView.LayoutParams(GridView.LayoutParams.MATCH_PARENT, 80));
            if(zorluk==3)
                imageview.setLayoutParams(new GridView.LayoutParams(GridView.LayoutParams.MATCH_PARENT, 60));
            imageview.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageview.setPadding(4, 4, 4, 4);
        } else {
            imageview = (ImageView) convertView;
        }
            imageview.setBackgroundColor(RandomDizi.get(position));
            return imageview;
    }

    public List<Integer>RandomDizi= Lists.newArrayList();

    public ImageView getImageview() {
        return imageview;
    }

    public void setImageview(ImageView imageview) {
        this.imageview = imageview;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}

