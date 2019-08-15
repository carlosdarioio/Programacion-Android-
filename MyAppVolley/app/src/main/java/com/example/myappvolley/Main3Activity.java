package com.example.myappvolley;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static java.sql.DriverManager.println;

//idea al cargar la apk jalar datos json
//pedir colocar x numero y al darle mostrar
//que muestre el datos obtenido en json
public class Main3Activity extends AppCompatActivity {
    TextView textView;
    EditText ediText;
    Button button,xbtnpost;
    private RequestQueue queue;
    private RequestQueue queue2;
    JSONArray mJSONArray;
    JSONObject mJSONObject;
    JSONArray mJSONArray2;
    JSONObject mJSONObject2;

    private String x2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        queue= Volley.newRequestQueue(this);
        textView=findViewById(R.id.textView);
        ediText=findViewById(R.id.editText);
        button=findViewById(R.id.button);
        xbtnpost=findViewById(R.id.btnpost);

        obtenerDatosVolley();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try
                {

                    int num=Integer.parseInt(ediText.getText().toString());
                    mJSONObject = mJSONArray.getJSONObject(num);
                    String name = mJSONObject.getString("nombre");
                    Toast.makeText(Main3Activity.this,"Get:"+name,Toast.LENGTH_LONG).show();


                    textView.setText("Get:"+name);


                } catch (JSONException e) {
                    Toast.makeText(Main3Activity.this,"XError2 get:",Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }


            }
        });

        xbtnpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PostVolley1();
                Toast.makeText(Main3Activity.this,"Post : "+x2,Toast.LENGTH_LONG).show();
                /*
                try
                {

                    int num=Integer.parseInt(ediText.getText().toString());
                    mJSONObject = mJSONArray.getJSONObject(num);
                    String name = mJSONObject.getString("nombre");
                    Toast.makeText(Main3Activity.this,"Get:"+name,Toast.LENGTH_LONG).show();


                    textView.setText("Get:"+name);


                } catch (JSONException e) {
                    Toast.makeText(Main3Activity.this,"XError2 get:",Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }*/


            }
        });





    }//fin void oncreate

    //------------------------------------------------------------------------------------
    private void obtenerDatosVolley()
    {
        String url="http://10.1.0.136:81/Service1.svc/getusers/";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response)
            {
                try
                {
                    //varios resultados
                    mJSONArray=response.getJSONArray("users");
                    mJSONObject = mJSONArray.getJSONObject(0);
                    Toast.makeText(Main3Activity.this,"result:"+response,Toast.LENGTH_LONG).show();


                } catch (JSONException e) {
                    Toast.makeText(Main3Activity.this,"Error2:",Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Toast.makeText(Main3Activity.this,"Error3:",Toast.LENGTH_LONG).show();

            }
        });
        queue.add(request);
    }//Fin obtener Datos Volley

    //aqui explica bien todo https://www.itsalif.info/content/android-volley-tutorial-http-get-post-put
    private void PostVolley1()
    {
        final String url = "http://10.1.0.136:81/SapService.svc/testpost1";//trabajo
        //final String url = "http://192.168.0.17:80/CFService/SapService.svc/testpost1";//casa
        Log.d("Post PostVolley1", "entro");

        println("PostVolley1");

        // Instantiate the RequestQueue.
        queue2 = Volley.newRequestQueue(this);
        JSONObject xRootObject = new JSONObject();

        try
        {
            //varios resultados
            xRootObject.put("value","alfinsera");


        } catch (JSONException e) {
            Toast.makeText(Main3Activity.this,"Error2:",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }



        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, xRootObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response)
            {
                try
                {
                    //varios resultados
                    //mJSONArray=response.getJSONArray("users");
                    //mJSONObject = mJSONArray.getJSONObject(0);
                    Log.d("response ", response.toString());
                    Toast.makeText(Main3Activity.this,"post result:"+response,Toast.LENGTH_LONG).show();


                } catch (Exception e) {
                    Toast.makeText(Main3Activity.this,"post Error2:",Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Toast.makeText(Main3Activity.this,"post Error3:",Toast.LENGTH_LONG).show();

            }
        });
        queue2.add(request);


    }

    //-------------------------------------------------------------------------------------
}
