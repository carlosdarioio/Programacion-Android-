package com.example.myapplicationbottomnav;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mTextMessage;
    public Intent in;
    public Button xbtnfindclient;
    public EditText xCliente;

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



        Spinner spinner = (Spinner) findViewById(R.id.almacen);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.almacenes_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Spinner termino = (Spinner) findViewById(R.id.termino);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
        R.array.termino, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        termino.setAdapter(adapter2);

        Spinner entrega = (Spinner) findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
        R.array.entrega, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        entrega.setAdapter(adapter3);


        xbtnfindclient=(Button) findViewById(R.id.btnfindclient);
        xbtnfindclient.setOnClickListener(this);

        xCliente=(EditText) findViewById(R.id.Cliente);





        //navView.getTag(1).notifyAll();
        //int g = navView.getSelectedItemId();
        //Intent intent = new Intent(this, Main2Activity.class);
        //startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case  R.id.btnfindclient: {
                // do something for button 1 click
                //ventana pa buscar cliente
                in=new Intent(MainActivity.this,clfindclient.class);
                String txt=xCliente.getText().toString();
                in.putExtra("client", txt);
                startActivity(in);
                finish();

                //Toast.makeText(MainActivity.this, "alola", Toast.LENGTH_LONG).show();
                break;
            }
            //.... etc
        }
    }
}
