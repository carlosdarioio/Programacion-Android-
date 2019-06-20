package com.example.cfordersale;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public Intent intent;
    //pendiente definir FindUserByName en server sap
    private String URLstring = "http://10.1.0.136/CFService/Service1.svc/FindUserByName/";
    //http://10.1.0.136/CFService/Service1.svc/FindUserByName/lo
    public String newString;
    private static ProgressDialog mProgressDialog;
    private ListView listView;
    ArrayList<ClientModel> dataModelArrayList;

    private clfindclientListAdapter listAdapter;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    Toast.makeText(MainActivity.this, "home", Toast.LENGTH_LONG).show();

                    return true;
                case R.id.navigation_dashboard:
                    //Toast.makeText(MainActivity.this, "das", Toast.LENGTH_LONG).show();
                    intent=new Intent(MainActivity.this,MainActivity2.class);
                    startActivity(intent);
                    finish();
                    return true;
                case R.id.navigation_notifications:
                    //Toast.makeText(MainActivity.this, "notif", Toast.LENGTH_LONG).show();
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
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }//fin oncreate

    //retrieveJSON
    private void retrieveJSON() {

        showSimpleProgressDialog(this, "Loading...","Fetching Json",false);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URLstring+newString,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.d("strrrrr", ">>" + response);

                        try {

                            JSONObject obj = new JSONObject(response);
                            if(obj.optString("status").equals("true")){

                                //si solo es 1 no correr el for ni abrir nueva ventana
                                //asignales los valores a los text y liseto
                                dataModelArrayList = new ArrayList<>();
                                JSONArray dataArray  = obj.getJSONArray("users");//nombre de objec json


                                //si son vario usar for <pa buscar clints solo est eusarias>
                                for (int i = 0; i < dataArray.length(); i++) {

                                    ClientModel playerModel = new ClientModel();
                                    JSONObject dataobj = dataArray.getJSONObject(i);

                                    playerModel.setid(dataobj.getString("id"));
                                    playerModel.setcodigo(dataobj.getString("codigo"));
                                    playerModel.setcliente(dataobj.getString("cliente"));


                                    dataModelArrayList.add(playerModel);

                                }

                                setupListview();

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //displaying the error in toast if occurrs
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        // request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(stringRequest);


    }

    private void setupListview(){
        removeSimpleProgressDialog();  //will remove progress dialog
        listAdapter = new clfindclientListAdapter(this, dataModelArrayList);
        listView.setAdapter(listAdapter);
    }

    public static void removeSimpleProgressDialog() {
        try {
            if (mProgressDialog != null) {
                if (mProgressDialog.isShowing()) {
                    mProgressDialog.dismiss();
                    mProgressDialog = null;
                }
            }
        } catch (IllegalArgumentException ie) {
            ie.printStackTrace();

        } catch (RuntimeException re) {
            re.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void showSimpleProgressDialog(Context context, String title,
                                                String msg, boolean isCancelable) {
        try {
            if (mProgressDialog == null) {
                mProgressDialog = ProgressDialog.show(context, title, msg);
                mProgressDialog.setCancelable(isCancelable);
            }

            if (!mProgressDialog.isShowing()) {
                mProgressDialog.show();
            }

        } catch (IllegalArgumentException ie) {
            ie.printStackTrace();
        } catch (RuntimeException re) {
            re.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //fin retrieveJSON


}//fin class
