package com.example.myapplicationbottomnav;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
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

public class clfindclient extends AppCompatActivity {
    //x aqui vas proba obtener FindUserByName por nombre si lo agarra que lo muestre em el lost
    //si se le da click qie insert el articulo en la base de datos
    private String URLstring = "http://10.1.0.136/CFService/Service1.svc/FindUserByName/";
                              //http://10.1.0.136/CFService/Service1.svc/FindUserByName/lo
    public String newString;
    private static ProgressDialog mProgressDialog;
    private ListView listView;
    ArrayList<ClientModel> dataModelArrayList;
    private clfindclientListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lvfindclient);
        listView = findViewById(R.id.lv);


        Bundle extras = getIntent().getExtras();
        newString= extras.getString("client");
        Toast.makeText(clfindclient.this,"nombre find: "+URLstring+newString,Toast.LENGTH_LONG).show();
        retrieveJSON();



        //setOnItemClickListener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                @SuppressWarnings("unchecked")
                //Obtendiendo datos del dato al que se le dio clic
                        ClientModel p = (ClientModel ) listView.getItemAtPosition(position);

                //Main5ActivityVolleyList
                Toast.makeText(clfindclient.this,"Get:"+p.getNombre(),Toast.LENGTH_LONG).show();
            }
        });//fin setOnItemClickListener
    }

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

                                dataModelArrayList = new ArrayList<>();
                                JSONArray dataArray  = obj.getJSONArray("users");//nombre de objec json

                                for (int i = 0; i < dataArray.length(); i++) {

                                    ClientModel playerModel = new ClientModel();
                                    JSONObject dataobj = dataArray.getJSONObject(i);

                                    playerModel.setid(dataobj.getString("id"));
                                    playerModel.setnombre(dataobj.getString("nombre"));
                                    playerModel.setCliente(dataobj.getString("estado"));


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

}