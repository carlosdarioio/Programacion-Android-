package com.example.httpget;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RequestQueue queue;
    private TextView txt;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=(TextView) findViewById(R.id.TextView);

        queue= Volley.newRequestQueue(this);

        obtenerDatosVolley();


    }



    private void obtenerDatosVolley()
    {
        //20190610 obtendiendo datos desde los https funciona
        //String url="https://api.androidhive.info/contacts/";
        //String url="http://jsonplaceholder.typicode.com/todos/1";
        //ninguno de estos locales funciona
        //String url="http://10.1.0.136/CFService/Service1.svc/GetData/xr";//varios resulados
        String url="http://10.1.0.136/CFService/Service1.svc/GetData2/xr";//un resultados

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response)
            {

                try {
                    //varios resultados
                    //JSONArray mJSONArray=response.getJSONArray("contacts");
                    //JSONObject mJSONObject = mJSONArray.getJSONObject(0);
                    //String name = mJSONObject.getString("name");

                    //un reusltado
                    String name=response.getString("title");



                    txt.setText(name);
                    Toast.makeText(MainActivity.this,"Nombre:"+name,Toast.LENGTH_LONG).show();


                } catch (JSONException e) {
                    txt.setText("error2");
                    e.printStackTrace();

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                txt.setText("error3");

            }
        });

        queue.add(request);



    }//Fin obtener Datos Volley


    //------------------------------------------------------------------------------------


    //-------------------------------------------------------------------------------------

}
