package com.example.myappvolley;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;

//RequestQueue

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myAppVolley.MESSAGE";

    public TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        textView.setText("txt");

//---------------
        RequestQueue requestQueue;
// Instantiate the cache
        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024); // 1MB cap
// Set up the network to use HttpURLConnection as the HTTP client.
        Network network = new BasicNetwork(new HurlStack());
// Instantiate the RequestQueue with the cache and network.
        requestQueue = new RequestQueue(cache, network);
// Start the queue
        requestQueue.start();
        String url ="https://www.example.com";

// Formulate the request and handle the response.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Do something with the response
                        //textView.setText("Response is: "+ response.substring(0,500));
                        Toast.makeText(MainActivity.this,"get:"+response.substring(0,500),Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Handle error
                        textView.setText("error ");
                    }
                });

// Add the request to the RequestQueue.
        requestQueue.add(stringRequest);
//----------------

    }//fin void on create

/****gggg****/
    /** Called when the user taps the Send button */

    //get html
    public void sendMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Main2Activity.class);
        //EditText editText = (EditText) findViewById(R.id.editText);
        String message = "Mensaje";//editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    //Get Json Class
    public void P3(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Main3Activity.class);
        startActivity(intent);
    }

    //Pruebas
    public void Pruebas(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Pruebas.class);
        startActivity(intent);
    }

    //VolleyList ejemplo https://demonuts.com/android-listview-using-volley/
    public void xListView(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Main4ActivityLisViewSelect.class);
        startActivity(intent);
    }

    //VolleyList codigo propio
    public void VolleyList(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Main5ActivityVolleyList.class);
        startActivity(intent);
    }
}
