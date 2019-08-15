package com.example.myappvolley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.ProgressDialog;
import android.content.Context;
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

//https://demonuts.com/android-listview-using-volley/
//1 añadir dependencias
// implementation 'com.android.volley:volley:1.1.1'
// implementation 'com.squareup.picasso:picasso:2.71828'
//2 añadir permisos de intenert en  build.gradle <uses-permission android:name="android.permission.INTERNET"/>
//3 crear tu Class of Model: User Model en este caso
//4 Crear ListView Layout(crear layout que contendra el listview ) osea diseño
//5 Crera clase java  ListView Adapter, claase para asignar valores y mover datos dle diseño
//6 agregar ListView al activity_main con el id asignado en el diseño
//7 agregar retrieveJSON en el MainActivity  del activity_main donde esta colocado el ListView Adapter(osea aqui)
    //R.layout.activity_main5_volley_list

    public class Main5ActivityVolleyList extends AppCompatActivity {

        private String URLstring = "http://10.1.0.136/CFService/Service1.svc/Getusers/";
        private static ProgressDialog mProgressDialog;
        private ListView listView;//need
        ArrayList<UserModel> dataModelArrayList;//need
        private UserListAdapter listAdapter;//need

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main5_volley_list);
            listView = findViewById(R.id.lv);
            retrieveJSON();

            //setOnItemClickListener
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    @SuppressWarnings("unchecked")
                    //Obtendiendo datos del dato al que se le dio clic
                    UserModel p = (UserModel ) listView.getItemAtPosition(position);


                    //Main5ActivityVolleyList
                    Toast.makeText(Main5ActivityVolleyList.this,"Get:"+p.getNombre(),Toast.LENGTH_LONG).show();
                }
            });//fin setOnItemClickListener
        }//fon oncreate

        private void retrieveJSON() {

            showSimpleProgressDialog(this, "Loading...","Fetching Json",false);

            StringRequest stringRequest = new StringRequest(Request.Method.GET, URLstring,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            Log.d("strrrrr", ">>" + response);

                            try {

                                JSONObject obj = new JSONObject(response);
                                if(obj.optString("status").equals("true")){

                                    dataModelArrayList = new ArrayList<>();
                                    JSONArray dataArray  = obj.getJSONArray("users");//nombre de objec json

                                    //need
                                    for (int i = 0; i < dataArray.length(); i++) {

                                        UserModel playerModel = new UserModel();
                                        JSONObject dataobj = dataArray.getJSONObject(i);

                                        playerModel.setid(dataobj.getString("id"));
                                        playerModel.setnombre(dataobj.getString("nombre"));
                                        playerModel.setestado(dataobj.getString("estado"));


                                        dataModelArrayList.add(playerModel);

                                    }

                                    //need
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


        }//fin rerieve json

        //insertando datos arraylist en el list
        private void setupListview(){
            removeSimpleProgressDialog();  //will remove progress dialog
            listAdapter = new UserListAdapter(this, dataModelArrayList);
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