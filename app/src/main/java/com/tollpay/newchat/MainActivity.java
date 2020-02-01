package com.tollpay.newchat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

import android.location.Criteria;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import android.location.LocationListener;
import android.location.LocationManager;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements LocationListener{

    String provider;
    protected double latitude,longitude;

    protected LocationManager locationManager;
    protected LocationListener locationListener;
    protected Context context;

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




        if(ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,Manifest.permission.ACCESS_FINE_LOCATION)){
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
            }
            else {
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
            }
        }else {

        }
        if(ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,Manifest.permission.CAMERA)){
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CAMERA},1);
            }
            else {
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CAMERA},1);
            }
        }else {

        }
        if(ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,Manifest.permission.READ_EXTERNAL_STORAGE)){
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);
            }
            else {
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);
            }
        }else {

        }
        if(ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,Manifest.permission.WRITE_EXTERNAL_STORAGE)){
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
            }
            else {
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
            }
        }else {

        }
        if(ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,Manifest.permission.ACCESS_COARSE_LOCATION)){
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},1);
            }
            else {
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},1);
            }
        }else {

        }


        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED){

            if(ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,Manifest.permission.SEND_SMS)){

                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.SEND_SMS},1);
            }
            else {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.SEND_SMS},1);
            }

        }else {

        }
        locationManager  =(LocationManager)getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        provider = locationManager.getBestProvider(criteria,false);


       Location location = locationManager.getLastKnownLocation(provider);
       locationManager.requestLocationUpdates(provider,0,1,this);

      if (location != null) {
          onLocationChanged(location);
       }
      else {
          Toast.makeText(this,"no location provider found",Toast.LENGTH_SHORT).show();
      }
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
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:{
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    if(ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.SEND_SMS)== PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(this,"Permission granted",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(this,"No permission granted",Toast.LENGTH_SHORT).show();
                }
            }
            case 2:{
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    if(ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(this,"Permission granted",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(this,"No permission granted",Toast.LENGTH_SHORT).show();
                    }
                }
            }
            case 3:{
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    if(ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(this,"Permission granted",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(this,"No permission granted",Toast.LENGTH_SHORT).show();
                    }
                }
            }

        }
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
            String number="9489466003";


            try {

                SmsManager smsManager = SmsManager.getDefault();
                String uri ="I am in trouble"+"https://maps.google.com/maps?q="+latitude+","+longitude;
                StringBuffer smsBody = new StringBuffer();
                smsBody.append(Uri.parse(uri));
                smsManager.sendTextMessage(number,null,smsBody.toString(),null,null);
                Toast.makeText(MainActivity.this,"Sent!!",Toast.LENGTH_SHORT).show();


            }catch (Exception e)
            {
                Toast.makeText(MainActivity.this,"Failed!!",Toast.LENGTH_SHORT).show();
            }

        }



        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onLocationChanged(Location location) {
        latitude = location.getLatitude();
        longitude = location.getLongitude();

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
