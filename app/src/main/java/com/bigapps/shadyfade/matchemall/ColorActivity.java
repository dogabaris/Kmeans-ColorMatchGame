package com.bigapps.shadyfade.matchemall;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.GridView;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by shadyfade on 03.11.2015.
 */
public class ColorActivity extends ActionBarActivity {
    Context context;
    String zorluk;
    int randomiterator,random;
    static int Kume1sınır,Kume2sınır,Kume3sınır,Kume4sınır,Kume5sınır;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_color);

        Kume1.clear();
        Kume2.clear();
        Kume3.clear();
        Kume4.clear();
        Kume5.clear();
        RandomDizi.clear();
        Kume1sınır=0;
        Kume2sınır=0;
        Kume3sınır=0;
        Kume4sınır=0;
        Kume5sınır=0;

        Bundle extras = getIntent().getExtras();
        zorluk = extras.getString("zorluk");

        GridView gridView1,gridView2,gridView3,gridView4,gridView5;

        if(Integer.parseInt(zorluk)==1) {
            KMeans kmeans = new KMeans(1, 36);
            Kume1 = kmeans.getKume1();
            Kume2 = kmeans.getKume2();
            Kume3 = kmeans.getKume3();
            RandomDizi = kmeans.getRandomDizi();
            Kume1sınır = kmeans.getKume1sınır();
            Kume2sınır = kmeans.getKume2sınır();
            Kume3sınır = kmeans.getKume3sınır();
        }
        else if(Integer.parseInt(zorluk)==2) {
            KMeans kmeans = new KMeans(2, 54);
            Kume1 = kmeans.getKume1();
            Kume2 = kmeans.getKume2();
            Kume3 = kmeans.getKume3();
            Kume4 = kmeans.getKume4();
            RandomDizi = kmeans.getRandomDizi();
            Kume1sınır = kmeans.getKume1sınır();
            Kume2sınır = kmeans.getKume2sınır();
            Kume3sınır = kmeans.getKume3sınır();
            Kume4sınır = kmeans.getKume4sınır();
        }
        else if(Integer.parseInt(zorluk)==3) {
            KMeans kmeans = new KMeans(3, 72);
            Kume1 = kmeans.getKume1();
            Kume2 = kmeans.getKume2();
            Kume3 = kmeans.getKume3();
            Kume4 = kmeans.getKume4();
            Kume5 = kmeans.getKume5();
            RandomDizi = kmeans.getRandomDizi();
            Kume1sınır = kmeans.getKume1sınır();
            Kume2sınır = kmeans.getKume2sınır();
            Kume3sınır = kmeans.getKume3sınır();
            Kume4sınır = kmeans.getKume4sınır();
            Kume5sınır = kmeans.getKume5sınır();
        }


        gridView1 = (GridView) findViewById(R.id.gridView1);
        ColorGridViewAdapter gw1 = new ColorGridViewAdapter(this,Kume1);
        gridView1.setAdapter(gw1);

        gridView2 = (GridView) findViewById(R.id.gridView2);
        final ColorGridViewAdapter gw2 = new ColorGridViewAdapter(this,Kume2);
        gridView2.setAdapter(gw2);

        gridView3 = (GridView) findViewById(R.id.gridView3);
        final ColorGridViewAdapter gw3 = new ColorGridViewAdapter(this,Kume3);
        gridView3.setAdapter(gw3);

        gridView4 = (GridView) findViewById(R.id.gridView4);
        final ColorGridViewAdapter gw4 = new ColorGridViewAdapter(this,Kume4);
        gridView4.setAdapter(gw4);

        gridView5 = (GridView) findViewById(R.id.gridView5);
        final ColorGridViewAdapter gw5 = new ColorGridViewAdapter(this,Kume5);
        gridView5.setAdapter(gw5);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_next) {
            Intent i = new Intent(ColorActivity.this, GameActivity.class);
            i.putExtra("zorluk", zorluk);
            finish();
            startActivity(i);
            RandomDizi.clear();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    static public List<Integer>Kume1= Lists.newArrayList();
    static public List<Integer>Kume2= Lists.newArrayList();
    static public List<Integer>Kume3= Lists.newArrayList();
    static public List<Integer>Kume4= Lists.newArrayList();
    static public List<Integer>Kume5= Lists.newArrayList();
    static public List<Integer>RandomDizi= Lists.newArrayList();

    public List<Integer> getRandomDizi() {
        return RandomDizi;
    }

    public List<Integer> getKume1() {
        return Kume1;
    }

    public List<Integer> getKume2() {
        return Kume2;
    }

    public List<Integer> getKume3() {
        return Kume3;
    }

    public List<Integer> getKume4() {
        return Kume4;
    }

    public List<Integer> getKume5() {
        return Kume5;
    }

    public List<Integer>Dizi= Lists.newArrayList(
            Color.parseColor("#CD5C5C"),
            Color.parseColor("#F08080"),
            Color.parseColor("#FA8072"),
            Color.parseColor("#E9967A"),
            Color.parseColor("#FFA07A"),
            Color.parseColor("#DC143C"),
            Color.parseColor("#FF0000"),
            Color.parseColor("#B22222"),
            Color.parseColor("#8B0000"),
            Color.parseColor("#FFC0CB"),
            Color.parseColor("#FFB6C1"),
            Color.parseColor("#FF69B4"),
            Color.parseColor("#FF1493"),
            Color.parseColor("#C71585"),
            Color.parseColor("#DB7093"),
            Color.parseColor("#ADFF2F"),
            Color.parseColor("#7FFF00"),
            Color.parseColor("#7CFC00"),
            Color.parseColor("#00FF00"),
            Color.parseColor("#32CD32"),
            Color.parseColor("#98FB98"),
            Color.parseColor("#90EE90"),
            Color.parseColor("#00FA9A"),
            Color.parseColor("#00FF7F"),
            Color.parseColor("#3CB371"),
            Color.parseColor("#2E8B57"),
            Color.parseColor("#228B22"),
            Color.parseColor("#008000"),
            Color.parseColor("#006400"),
            Color.parseColor("#9ACD32"),
            Color.parseColor("#6B8E23"),
            Color.parseColor("#808000"),
            Color.parseColor("#556B2F"),
            Color.parseColor("#66CDAA"),
            Color.parseColor("#8FBC8F"),
            Color.parseColor("#20B2AA"),
            Color.parseColor("#008B8B"),
            Color.parseColor("#008080"),
            Color.parseColor("#FFA07A"),
            Color.parseColor("#FF7F50"),
            Color.parseColor("#FF6347"),
            Color.parseColor("#FF4500"),
            Color.parseColor("#FF8C00"),
            Color.parseColor("#FFA500"),
            Color.parseColor("#FFD700"),
            Color.parseColor("#FFFF00"),
            Color.parseColor("#FFFFE0"),
            Color.parseColor("#FFFACD"),
            Color.parseColor("#FAFAD2"),
            Color.parseColor("#FFEFD5"),
            Color.parseColor("#FFE4B5"),
            Color.parseColor("#FFDAB9"),
            Color.parseColor("#EEE8AA"),
            Color.parseColor("#F0E68C"),
            Color.parseColor("#BDB76B"),
            Color.parseColor("#00FFFF"),
            Color.parseColor("#00FFFF"),
            Color.parseColor("#E0FFFF"),
            Color.parseColor("#AFEEEE"),
            Color.parseColor("#7FFFD4"),
            Color.parseColor("#40E0D0"),
            Color.parseColor("#48D1CC"),
            Color.parseColor("#00CED1"),
            Color.parseColor("#5F9EA0"),
            Color.parseColor("#4682B4"),
            Color.parseColor("#B0C4DE"),
            Color.parseColor("#B0E0E6"),
            Color.parseColor("#ADD8E6"),
            Color.parseColor("#87CEEB"),
            Color.parseColor("#87CEFA"),
            Color.parseColor("#00BFFF"),
            Color.parseColor("#1E90FF"),
            Color.parseColor("#6495ED"),
            Color.parseColor("#7B68EE"),
            Color.parseColor("#4169E1"),
            Color.parseColor("#0000FF"),
            Color.parseColor("#0000CD"),
            Color.parseColor("#00008B"),
            Color.parseColor("#000080"),
            Color.parseColor("#191970"),
            Color.parseColor("#E6E6FA"),
            Color.parseColor("#D8BFD8"),
            Color.parseColor("#DDA0DD"),
            Color.parseColor("#EE82EE"),
            Color.parseColor("#DA70D6"),
            Color.parseColor("#FF00FF"),
            Color.parseColor("#FF00FF"),
            Color.parseColor("#BA55D3"),
            Color.parseColor("#9370DB"),
            Color.parseColor("#8A2BE2"),
            Color.parseColor("#9400D3"),
            Color.parseColor("#9932CC"),
            Color.parseColor("#8B008B"),
            Color.parseColor("#800080"),
            Color.parseColor("#4B0082"),
            Color.parseColor("#6A5ACD"),
            Color.parseColor("#483D8B"),
            Color.parseColor("#FFF8DC"),
            Color.parseColor("#FFEBCD"),
            Color.parseColor("#FFE4C4"),
            Color.parseColor("#FFDEAD"),
            Color.parseColor("#F5DEB3"),
            Color.parseColor("#DEB887"),
            Color.parseColor("#D2B48C"),
            Color.parseColor("#BC8F8F"),
            Color.parseColor("#F4A460"),
            Color.parseColor("#DAA520"),
            Color.parseColor("#B8860B"),
            Color.parseColor("#CD853F"),
            Color.parseColor("#D2691E"),
            Color.parseColor("#8B4513"),
            Color.parseColor("#A0522D"),
            Color.parseColor("#A52A2A"),
            Color.parseColor("#800000"),
            Color.parseColor("#FFFFFF"),
            Color.parseColor("#FFFAFA"),
            Color.parseColor("#F0FFF0"),
            Color.parseColor("#F5FFFA"),
            Color.parseColor("#F0FFFF"),
            Color.parseColor("#F0F8FF"),
            Color.parseColor("#F8F8FF"),
            Color.parseColor("#F5F5F5"),
            Color.parseColor("#FFF5EE"),
            Color.parseColor("#FFF5DC"),
            Color.parseColor("#FDF5E6"),
            Color.parseColor("#FFFAF0"),
            Color.parseColor("#FFFFF0"),
            Color.parseColor("#FAEBD7"),
            Color.parseColor("#FAF0E6"),
            Color.parseColor("#FFF0F5"),
            Color.parseColor("#FFE4E1"),
            Color.parseColor("#DCDCDC"),
            Color.parseColor("#D3D3D3"),
            Color.parseColor("#C0C0C0"),
            Color.parseColor("#A9A9A9"),
            Color.parseColor("#808080"),
            Color.parseColor("#696969"),
            Color.parseColor("#778899"),
            Color.parseColor("#708090"),
            Color.parseColor("#2F4F4F"),
            Color.parseColor("#000000"));

}
