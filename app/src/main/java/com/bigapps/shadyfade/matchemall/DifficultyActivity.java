package com.bigapps.shadyfade.matchemall;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

/**
 * Created by shadyfade on 13.10.2015.
 */
public class DifficultyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_difficulty);

        Button btn_easy = (Button) findViewById(R.id.btn_easy);
        Button btn_medium = (Button) findViewById(R.id.btn_medium);
        Button btn_hard = (Button) findViewById(R.id.btn_hard);

        btn_easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DifficultyActivity.this, ColorActivity.class);
                String zorluk = null;
                i.putExtra("zorluk", "1");
                startActivity(i);
            }
        });

        btn_medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DifficultyActivity.this, ColorActivity.class);
                String zorluk = null;
                i.putExtra("zorluk", "2");
                startActivity(i);
            }
        });

        btn_hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DifficultyActivity.this, ColorActivity.class);
                String zorluk = null;
                i.putExtra("zorluk", "3");
                startActivity(i);
            }
        });

    }
}
