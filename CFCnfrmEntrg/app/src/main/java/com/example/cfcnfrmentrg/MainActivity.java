package com.example.cfcnfrmentrg;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private RequestQueue queue;
    EditText firstNumEditText;
    TextView resultTextView;
    Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        queue= Volley.newRequestQueue(this);

        firstNumEditText =(EditText) findViewById(R.id.firstNumEditText);
        resultTextView=(TextView) findViewById(R.id.resultTextView);

        addBtn = (Button) findViewById(R.id.addBtn);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int num1=Integer.parseInt(firstNumEditText.getText().toString());
                //int num2=Integer.parseInt(secondNumEditText.getText().toString());
                obtenerDatosVolley();
            }
        });
    }//fin void on create

    //________________________




    //------------------------------------------------------------------------------------
    private void obtenerDatosVolley()
    {
        //20190610 obtendiendo datos desde los https funciona
        //String url="https://api.androidhive.info/contacts/";
        //String url="http://jsonplaceholder.typicode.com/todos/1";
        //ninguno de estos locales funciona
        //String url="http://10.1.0.136/CFService/Service1.svc/GetData/xr";//varios resulados
        //String url="http://10.1.0.136/CFService/Service1.svc/GetData2/"+firstNumEditText.getText().toString();//un resultados
        //test update
        String url="http://10.1.0.136/CFService/Service1.svc/ConfirmUser/"+firstNumEditText.getText().toString();//un resultados



        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response)
            {
                try
                {
                    //varios resultados
                    //JSONArray mJSONArray=response.getJSONArray("contacts");
                    //JSONObject mJSONObject = mJSONArray.getJSONObject(0);
                    //String name = mJSONObject.getString("name");

                    //un reusltado
                    //String name=response.getString("title");

                    //test update
                    String name=response.getString("Result");

                    resultTextView.setText(name);
                    Toast.makeText(MainActivity.this,"result:"+response,Toast.LENGTH_LONG).show();


                } catch (JSONException e) {
                    resultTextView.setText("error2");
                    e.printStackTrace();

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                resultTextView.setText("error3");

            }
        });

        queue.add(request);


    }//Fin obtener Datos Volley

    //-------------------------------------------------------------------------------------


}
