package com.example.myappvolley;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
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

import java.util.ArrayList;
import android.content.Context;
import android.util.Log;
import com.android.volley.toolbox.StringRequest;


    public class Main4ActivityLisViewSelect extends AppCompatActivity {

        //url de ejemplo https://demonuts.com/android-listview-using-volley/

        private String URLstring = "https://demonuts.com/Demonuts/JsonTest/Tennis/json_parsing.php";
        private static ProgressDialog mProgressDialog;
        private ListView listView;
        ArrayList<DataModel> dataModelArrayList;
        private ListAdapter listAdapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main4_lis_view_select);

            listView = findViewById(R.id.lv);

            retrieveJSON();

        }

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
                                    JSONArray dataArray  = obj.getJSONArray("data");

                                    for (int i = 0; i < dataArray.length(); i++) {

                                        DataModel playerModel = new DataModel();
                                        JSONObject dataobj = dataArray.getJSONObject(i);

                                        playerModel.setName(dataobj.getString("name"));
                                        playerModel.setCountry(dataobj.getString("country"));
                                        playerModel.setCity(dataobj.getString("city"));
                                        playerModel.setImgURL(dataobj.getString("imgURL"));

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
            listAdapter = new ListAdapter(this, dataModelArrayList);
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
