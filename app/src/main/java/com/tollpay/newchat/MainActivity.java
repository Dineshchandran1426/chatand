package com.tollpay.newchat;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private TabLayout mytablayout;
    private ViewPager myview;
    private tabsadapter mytabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myview = (ViewPager) findViewById(R.id.vpager);
        mytabs = new tabsadapter(getSupportFragmentManager());
        myview.setAdapter(mytabs);

        mytablayout = (TabLayout)findViewById(R.id.tab);
        mytablayout.setupWithViewPager(myview);

        mytablayout.getTabAt(0).setIcon(R.drawable.cam);
        mytablayout.getTabAt(1).setIcon(R.drawable.ic_comment_black_24dp);
        mytablayout.getTabAt(2).setIcon(R.drawable.new_status);
        mytablayout.getTabAt(3).setIcon(R.drawable.new_call);



        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

////        FloatingActionButton fab = findViewById(R.id.fab);
////        fab.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                Snackbar.make(view, "Contacts", Snackbar.LENGTH_LONG)
////                        .setAction("Action", null).show();
//
//            }
//        });
  }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.action_settings) {
            Intent i = new Intent(MainActivity.this,Main3Activity.class);
            startActivity(i);
        }
        if(id == R.id.sos){
            Intent i = new Intent(MainActivity.this,sos.class);
            startActivity(i);
        }



        return super.onOptionsItemSelected(item);
    }
}
