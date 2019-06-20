package com.example.cfordersale;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    public Intent intent;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //Toast.makeText(MainActivity2.this, "home", Toast.LENGTH_LONG).show();
                    intent=new Intent(getBaseContext(),MainActivity.class);
                    startActivity(intent);
                    finish();

                    return true;
                case R.id.navigation_dashboard:

                    Toast.makeText(MainActivity2.this, "das", Toast.LENGTH_LONG).show();
                    return true;
                case R.id.navigation_notifications:
                    //Toast.makeText(MainActivity2.this, "notif", Toast.LENGTH_LONG).show();
                    intent=new Intent(getBaseContext(),MainActivity3.class);
                    startActivity(intent);
                    finish();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
