package com.bigapps.shadyfade.matchemall;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by shadyfade on 03.11.2015.
 */
public class ColorGridViewAdapter extends BaseAdapter {
    private Context context;
    ImageView imageview;

    public ColorGridViewAdapter(Context c,List<Integer> GridColors) {
        this.context = c;
        this.GridColors = GridColors;

    }

    @Override
    public int getCount() {
        return GridColors.size();
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
        if (convertView == null) {
            imageview = new ImageView(context);
            imageview.setLayoutParams(new GridView.LayoutParams(GridView.LayoutParams.MATCH_PARENT, 70));
            imageview.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageview.setPadding(4, 4, 4, 4);
        } else {
            imageview = (ImageView) convertView;
        }
        imageview.setBackgroundColor(GridColors.get(position));
        return imageview;
    }

    public List<Integer> GridColors = Lists.newArrayList();
}
