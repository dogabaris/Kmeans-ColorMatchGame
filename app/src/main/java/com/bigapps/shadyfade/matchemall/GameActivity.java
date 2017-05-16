package com.bigapps.shadyfade.matchemall;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * Created by shadyfade on 13.10.2015.
 */
public class GameActivity extends Activity{
    GridView grid;
    int i=0;
    String zorluk;
    int firstClick,secondClick,sira=0,random,randomiterator,Kume1sınır,Kume2sınır,Kume3sınır,Kume4sınır,Kume5sınır,kume1kalan=0,kume2kalan=0,kume3kalan=0,kume4kalan=0,kume5kalan=0;
    int skor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game);

        Bundle extras = getIntent().getExtras();
        zorluk = extras.getString("zorluk");

        final Random rand = new Random();


        final TextView tv_kume1 = (TextView)findViewById(R.id.tv_kume1);
        final TextView tv_kume2 = (TextView)findViewById(R.id.tv_kume2);
        final TextView tv_kume3 = (TextView)findViewById(R.id.tv_kume3);
        final TextView tv_kume4 = (TextView)findViewById(R.id.tv_kume4);
        final TextView tv_kume5 = (TextView)findViewById(R.id.tv_kume5);
        final TextView tv_duration = (TextView)findViewById(R.id.tv_duration);



        Kume1sınır = ColorActivity.Kume1sınır;
        Kume2sınır = ColorActivity.Kume2sınır;
        Kume3sınır = ColorActivity.Kume3sınır;
        Kume4sınır = ColorActivity.Kume4sınır;
        Kume5sınır = ColorActivity.Kume5sınır;

        Kume1 = ColorActivity.Kume1;
        Kume2 = ColorActivity.Kume2;
        Kume3 = ColorActivity.Kume3;
        Kume4 = ColorActivity.Kume4;
        Kume5 = ColorActivity.Kume5;

        for(randomiterator=0;randomiterator<141;randomiterator++){//oyun ekranını zorluğa göre adaptörleme bölümü
            if(Integer.parseInt(zorluk)==1 && randomiterator<36) {
                random = rand.nextInt(141);
                OyunRandomDizi.add(randomiterator, Dizi.get(random));
                tv_kume1.setText("10");
                tv_kume2.setText("10");
                tv_kume3.setText("10");
                kume1kalan=10;
                kume2kalan=10;
                kume3kalan=10;

                new CountDownTimer(1800000, 1000) {

                    public void onTick(final long millisUntilFinished) {
                        int seconds = (int) (millisUntilFinished / 1000);
                        skor = seconds;
                        int minutes = seconds / 60;
                        seconds = seconds % 60;


                        tv_duration.setText(String.format("%d:%02d", minutes, seconds));
                    }

                    public void onFinish() {
                        Intent i = new Intent(GameActivity.this, Highscore.class);
                        i.putExtra("sonuc", "0");
                        finish();
                        startActivity(i);
                    }
                }.start();

            }else if(Integer.parseInt(zorluk)==2 && randomiterator<54) {
                random = rand.nextInt(141);
                OyunRandomDizi.add(randomiterator, Dizi.get(random));
                tv_kume1.setText("15");
                tv_kume2.setText("15");
                tv_kume3.setText("15");
                tv_kume4.setText("15");
                kume1kalan=15;
                kume2kalan=15;
                kume3kalan=15;
                kume4kalan=15;


                new CountDownTimer(1500000, 1000) {

                    public void onTick(long millisUntilFinished) {
                        int seconds = (int) (millisUntilFinished / 1000);
                        skor = seconds;
                        int minutes = seconds / 60;
                        seconds = seconds % 60;


                        tv_duration.setText(String.format("%d:%02d", minutes, seconds));
                    }

                    public void onFinish() {
                        Intent i = new Intent(GameActivity.this, Highscore.class);
                        i.putExtra("sonuc", "0");
                        finish();
                        startActivity(i);
                    }
                }.start();

            }else if(Integer.parseInt(zorluk)==3 && randomiterator<72) {
                random = rand.nextInt(141);
                OyunRandomDizi.add(randomiterator,Dizi.get(random));
                tv_kume1.setText("20");
                tv_kume2.setText("20");
                tv_kume3.setText("20");
                tv_kume4.setText("20");
                tv_kume5.setText("20");
                kume1kalan=20;
                kume2kalan=20;
                kume3kalan=20;
                kume4kalan=20;
                kume5kalan=20;

                new CountDownTimer(900000, 1000) {

                    public void onTick(long millisUntilFinished) {
                        int seconds = (int) (millisUntilFinished / 1000);
                        skor = seconds;
                        int minutes = seconds / 60;
                        seconds = seconds % 60;


                        tv_duration.setText(String.format("%d:%02d", minutes, seconds));
                    }

                    public void onFinish() {
                        Intent i = new Intent(GameActivity.this, Highscore.class);
                        i.putExtra("sonuc", "0");
                        finish();
                        startActivity(i);
                    }
                }.start();

            }
        }

        grid = (GridView) findViewById(R.id.gridView);
        final GridViewAdapter gw = new GridViewAdapter(this,Integer.parseInt(zorluk),0,OyunRandomDizi);
        grid.setAdapter(gw);


        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @TargetApi(Build.VERSION_CODES.KITKAT)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                i++;
                if (i % 2 == 1) {
                    firstClick = position;
                } else {
                    if (i % 2 == 0) {

                        secondClick = position;
                        Integer temp = gw.RandomDizi.get(firstClick);

                        if (secondClick == (firstClick - 1) || secondClick == (firstClick + 1) || secondClick == (firstClick - 6) || secondClick == (firstClick + 6)) {// + şeklinde hareket için
                            gw.RandomDizi.set(firstClick, gw.RandomDizi.get(secondClick));
                            gw.RandomDizi.set(secondClick, temp);

                            gw.notifyDataSetChanged();//Viewi günceller
                            //grid.setAdapter(gw);
                            //grid.refreshDrawableState();
                            grid.invalidateViews();


                            int sag = 0, ust = 0, alt = 0, sol = 0;
                            int sagiterator = 1, soliterator = 0, ustiterator = 0, altiterator = 0, merkezkume = 0, merkezicerik = gw.RandomDizi.get(secondClick), whileiterator = 1;


                            System.out.println("Randomdizi icerik " + merkezicerik);

                            if (Kume1.contains(merkezicerik)) {
                                merkezkume = 1;
                            }
                            if (Kume2.contains(merkezicerik)) {
                                merkezkume = 2;
                            }
                            if (Kume3.contains(merkezicerik)) {
                                merkezkume = 3;
                            }
                            if (Kume4.contains(merkezicerik)) {
                                merkezkume = 4;
                            }
                            if (Kume5.contains(merkezicerik)) {
                                merkezkume = 5;
                            }


                            System.out.println("merkezkume " + merkezkume);

                            while (true) {//saga bak
                                if (Kume1.contains(gw.RandomDizi.get(secondClick + whileiterator))) {
                                    sag = 1;
                                }
                                if (Kume2.contains(gw.RandomDizi.get(secondClick + whileiterator))) {
                                    sag = 2;
                                }
                                if (Kume3.contains(gw.RandomDizi.get(secondClick + whileiterator))) {
                                    sag = 3;
                                }
                                if (Kume4.contains(gw.RandomDizi.get(secondClick + whileiterator))) {
                                    sag = 4;
                                }
                                if (Kume5.contains(gw.RandomDizi.get(secondClick + whileiterator))) {
                                    sag = 5;
                                }

                                if (merkezkume == sag) {
                                    switch (sag) {
                                        case 1:
                                            gw.RandomDizi.set(secondClick + whileiterator,  Dizi.get(rand.nextInt(141)));
                                            gw.notifyDataSetChanged();
                                            grid.invalidateViews();
                                            kume1kalan--;
                                            break;
                                        case 2:
                                            gw.RandomDizi.set(secondClick + whileiterator, Dizi.get(rand.nextInt(141)));
                                            gw.notifyDataSetChanged();
                                            grid.invalidateViews();
                                            kume2kalan--;
                                            break;
                                        case 3:
                                            gw.RandomDizi.set(secondClick + whileiterator, Dizi.get(rand.nextInt(141)));
                                            gw.notifyDataSetChanged();
                                            grid.invalidateViews();
                                            kume3kalan--;
                                            break;
                                        case 4:
                                            gw.RandomDizi.set(secondClick + whileiterator, Dizi.get(rand.nextInt(141)));
                                            gw.notifyDataSetChanged();
                                            grid.invalidateViews();
                                            kume4kalan--;
                                            break;
                                        case 5:
                                            gw.RandomDizi.set(secondClick + whileiterator, Dizi.get(rand.nextInt(141)));
                                            gw.notifyDataSetChanged();
                                            grid.invalidateViews();
                                            kume5kalan--;
                                            break;

                                    }
                                } else
                                    break;

                                whileiterator++;
                            }
                            whileiterator = 1;

                            while (true) {//sola bak
                                if (Kume1.contains(gw.RandomDizi.get(secondClick - whileiterator))) {
                                    sol = 1;
                                }
                                if (Kume2.contains(gw.RandomDizi.get(secondClick - whileiterator))) {
                                    sol = 2;
                                }
                                if (Kume3.contains(gw.RandomDizi.get(secondClick - whileiterator))) {
                                    sol = 3;
                                }
                                if (Kume4.contains(gw.RandomDizi.get(secondClick - whileiterator))) {
                                    sol = 4;
                                }
                                if (Kume5.contains(gw.RandomDizi.get(secondClick - whileiterator))) {
                                    sol = 5;
                                }

                                if (merkezkume == sol) {
                                    switch (sol) {
                                        case 1:
                                            gw.RandomDizi.set(secondClick - whileiterator, Dizi.get(rand.nextInt(141)));
                                            gw.notifyDataSetChanged();
                                            grid.invalidateViews();
                                            kume1kalan--;
                                            break;
                                        case 2:
                                            gw.RandomDizi.set(secondClick - whileiterator, Dizi.get(rand.nextInt(141)));
                                            gw.notifyDataSetChanged();
                                            grid.invalidateViews();
                                            kume2kalan--;
                                            break;
                                        case 3:
                                            gw.RandomDizi.set(secondClick - whileiterator, Dizi.get(rand.nextInt(141)));
                                            gw.notifyDataSetChanged();
                                            grid.invalidateViews();
                                            kume3kalan--;
                                            break;
                                        case 4:
                                            gw.RandomDizi.set(secondClick - whileiterator, Dizi.get(rand.nextInt(141)));
                                            gw.notifyDataSetChanged();
                                            grid.invalidateViews();
                                            kume4kalan--;
                                            break;
                                        case 5:
                                            gw.RandomDizi.set(secondClick - whileiterator, Dizi.get(rand.nextInt(141)));
                                            gw.notifyDataSetChanged();
                                            grid.invalidateViews();
                                            kume5kalan--;
                                            break;

                                    }
                                } else
                                    break;

                                whileiterator--;
                            }
                            whileiterator = 1;

                            while (true) {//uste bak
                                if (Kume1.contains(gw.RandomDizi.get(secondClick + whileiterator))) {
                                    ust = 1;
                                }
                                if (Kume2.contains(gw.RandomDizi.get(secondClick + whileiterator))) {
                                    ust = 2;
                                }
                                if (Kume3.contains(gw.RandomDizi.get(secondClick + whileiterator))) {
                                    ust = 3;
                                }
                                if (Kume4.contains(gw.RandomDizi.get(secondClick + whileiterator))) {
                                    ust = 4;
                                }
                                if (Kume5.contains(gw.RandomDizi.get(secondClick + whileiterator))) {
                                    ust = 5;
                                }

                                if (merkezkume == ust) {
                                    switch (ust) {
                                        case 1:
                                            gw.RandomDizi.set(secondClick + whileiterator, Dizi.get(rand.nextInt(141)));
                                            gw.notifyDataSetChanged();
                                            grid.invalidateViews();
                                            kume1kalan--;
                                            break;
                                        case 2:
                                            gw.RandomDizi.set(secondClick + whileiterator, Dizi.get(rand.nextInt(141)));
                                            gw.notifyDataSetChanged();
                                            grid.invalidateViews();
                                            kume2kalan--;
                                            break;
                                        case 3:
                                            gw.RandomDizi.set(secondClick + whileiterator,Dizi.get(rand.nextInt(141)));
                                            gw.notifyDataSetChanged();
                                            grid.invalidateViews();
                                            kume3kalan--;
                                            break;
                                        case 4:
                                            gw.RandomDizi.set(secondClick + whileiterator, Dizi.get(rand.nextInt(141)));
                                            gw.notifyDataSetChanged();
                                            grid.invalidateViews();
                                            kume4kalan--;
                                            break;
                                        case 5:
                                            gw.RandomDizi.set(secondClick + whileiterator, Dizi.get(rand.nextInt(141)));
                                            gw.notifyDataSetChanged();
                                            grid.invalidateViews();
                                            kume5kalan--;
                                            break;

                                    }
                                } else
                                    break;

                                whileiterator = whileiterator - 6;
                            }
                            whileiterator = 1;

                            while (true) {//alt bak
                                if (Kume1.contains(gw.RandomDizi.get(secondClick + whileiterator))) {
                                    alt = 1;
                                }
                                if (Kume2.contains(gw.RandomDizi.get(secondClick + whileiterator))) {
                                    alt = 2;
                                }
                                if (Kume3.contains(gw.RandomDizi.get(secondClick + whileiterator))) {
                                    alt = 3;
                                }
                                if (Kume4.contains(gw.RandomDizi.get(secondClick + whileiterator))) {
                                    alt = 4;
                                }
                                if (Kume5.contains(gw.RandomDizi.get(secondClick + whileiterator))) {
                                    alt = 5;
                                }

                                if (merkezkume == alt) {
                                    switch (alt) {
                                        case 1:
                                            gw.RandomDizi.set(secondClick + whileiterator, Dizi.get(rand.nextInt(141)));
                                            gw.notifyDataSetChanged();
                                            grid.invalidateViews();
                                            kume1kalan--;
                                            break;
                                        case 2:
                                            gw.RandomDizi.set(secondClick + whileiterator, Dizi.get(rand.nextInt(141)));
                                            gw.notifyDataSetChanged();
                                            grid.invalidateViews();
                                            kume2kalan--;
                                            break;
                                        case 3:
                                            gw.RandomDizi.set(secondClick + whileiterator, Dizi.get(rand.nextInt(141)));
                                            gw.notifyDataSetChanged();
                                            grid.invalidateViews();
                                            kume3kalan--;
                                            break;
                                        case 4:
                                            gw.RandomDizi.set(secondClick + whileiterator, Dizi.get(rand.nextInt(141)));
                                            gw.notifyDataSetChanged();
                                            grid.invalidateViews();
                                            kume4kalan--;
                                            break;
                                        case 5:
                                            gw.RandomDizi.set(secondClick + whileiterator, Dizi.get(rand.nextInt(141)));
                                            gw.notifyDataSetChanged();
                                            grid.invalidateViews();
                                            kume5kalan--;
                                            break;

                                    }
                                } else
                                    break;

                                whileiterator = whileiterator + 6;
                            }
                            tv_kume1.setText(""+kume1kalan);
                            tv_kume2.setText(""+kume2kalan);
                            tv_kume3.setText(""+kume3kalan);
                            tv_kume4.setText(""+kume4kalan);
                            tv_kume5.setText(""+kume5kalan);

                        } else {
                            Toast.makeText(GameActivity.this, "Geçersiz hamle!", Toast.LENGTH_SHORT).show();
                        }

                    }
                }

                if(kume1kalan<=0 && kume2kalan<=0 && kume3kalan<=0 && kume4kalan<=0 && kume5kalan<=0 ){//basarılı bitti
                    Intent i = new Intent(GameActivity.this, Highscore.class);
                    i.putExtra("sonuc", "1");
                    i.putExtra("skor", ""+skor);
                    finish();
                    startActivity(i);
                }

            }
        });
    }


    public List<Integer>Kume1= Lists.newArrayList();
    public List<Integer>Kume2= Lists.newArrayList();
    public List<Integer>Kume3= Lists.newArrayList();
    public List<Integer>Kume4= Lists.newArrayList();
    public List<Integer>Kume5= Lists.newArrayList();
    public List<Integer>OyunRandomDizi= Lists.newArrayList();

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
