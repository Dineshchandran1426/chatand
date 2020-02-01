package com.tollpay.newchat;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

public class Main4Activity extends AppCompatActivity {

    Button sec;
    Button ver;
    Button pri;
    Button change;
Button del;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Main3Activity.class));
                finish();
            }

        });

       sec = (Button)findViewById(R.id.button2);
       ver = (Button)findViewById(R.id.button3);
       pri = (Button)findViewById(R.id.button) ;
       change=(Button)findViewById(R.id.button4);
        del=(Button)findViewById(R.id.button6);

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Main4Activity.this,delete.class);
                startActivity(i);
            }
        });

       pri.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i = new Intent(Main4Activity.this,privacy.class);
               startActivity(i);
           }
       });

       sec.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i = new Intent(Main4Activity.this,Main5Activity.class);
               startActivity(i);
           }
       });

       ver.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i = new Intent(Main4Activity.this,Main6Activity.class);
               startActivity(i);
           }
       });
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Main4Activity.this,changenum1.class);
                startActivity(i);
            }
        });

    }

}
