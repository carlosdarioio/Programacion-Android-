package com.example.myapplicationbottomnav;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;
    Intent in;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText("1 "+R.string.title_home);
                    return true;



                case R.id.navigation_dashboard:
                    mTextMessage.setText("1 "+R.string.title_dashboard);
                    in=new Intent(getBaseContext(),Main2Activity.class);
                    startActivity(in);
                    finish();
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText("1 "+R.string.title_notifications);
                    in=new Intent(getBaseContext(),Main3Activity.class);
                    startActivity(in);
                    finish();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        //navView.getTag(1).notifyAll();
     //   int g = navView.getSelectedItemId();
      //  Intent intent = new Intent(this, Main2Activity.class);
//        startActivity(intent);
    }

}
