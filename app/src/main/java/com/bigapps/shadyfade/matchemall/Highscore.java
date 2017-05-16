package com.bigapps.shadyfade.matchemall;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * Created by shadyfade on 07.11.2015.
 */
public class Highscore extends Activity {
    String sonuc,skor;
    int highscore1,highscore2,highscore3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_highscore);

        Bundle extras = getIntent().getExtras();
        sonuc = extras.getString("sonuc");
        skor = extras.getString("skor");

        TextView tv_highscore1 = (TextView)findViewById(R.id.tv_highscore1);
        TextView tv_highscore2 = (TextView)findViewById(R.id.tv_highscore2);
        TextView tv_highscore3 = (TextView)findViewById(R.id.tv_highscore3);

        TextView tv_sonuc = (TextView)findViewById(R.id.tv_sonuc);
        TextView tv_score = (TextView)findViewById(R.id.tv_score);

        if(Integer.parseInt(sonuc)==1){
            tv_sonuc.setText("Kazandınız!");
            tv_score.setText(skor);
        }
        else if(Integer.parseInt(sonuc)==0){
            tv_sonuc.setText("Kaybettiniz!");
            tv_score.setText("0");
        }

        highscore1=Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(this).getString("Highscore1", "0"));
        highscore2=Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(this).getString("Highscore2", "0"));
        highscore3=Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(this).getString("Highscore3", "0"));
        int score = Integer.parseInt(skor);

        if(score>=highscore1 && score>highscore2 && score>highscore3){
            PreferenceManager.getDefaultSharedPreferences(this).edit().putString("Highscore1", skor).commit();
        }else if(score<highscore1 && score>highscore2 && score>highscore3){
            PreferenceManager.getDefaultSharedPreferences(this).edit().putString("Highscore2", skor).commit();
        }else if(score<highscore1 && score<highscore2 && score>highscore3){
            PreferenceManager.getDefaultSharedPreferences(this).edit().putString("Highscore3", skor).commit();
        }

        tv_highscore1.setText(""+highscore1);
        tv_highscore2.setText(""+highscore2);
        tv_highscore3.setText(""+highscore3);

        //PreferenceManager.getDefaultSharedPreferences(this).getString("Highscore1", "0");//
        //PreferenceManager.getDefaultSharedPreferences(this).edit().putString("Highscore3", "myStringToSave").commit();

    }


}
