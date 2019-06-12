package com.example.myappvolley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import static com.example.myappvolley.MySingleton.*;

//idea al cargar la apk jalar datos json
//pedir colocar x numero y al darle mostrar
//que muestre el datos obtenido en json
public class Main3Activity extends AppCompatActivity {
    TextView textView;
    EditText ediText;
    Button button;
    private RequestQueue queue;
    JSONArray mJSONArray;
    JSONObject mJSONObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        queue= Volley.newRequestQueue(this);
        textView=findViewById(R.id.textView);
        ediText=findViewById(R.id.editText);
        button=findViewById(R.id.button);
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



    }//fin void oncreate

    //------------------------------------------------------------------------------------
    private void obtenerDatosVolley()
    {
        String url="http://10.1.0.136/CFService/Service1.svc/getusers/";
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

    //-------------------------------------------------------------------------------------
}
