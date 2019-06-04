package com.example.myappvolley;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Entity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

//por aqui vas ahora buscar como pasar x string en formato json a varibles
public class Pruebas extends AppCompatActivity {
    Button btnHit;
    Button post;
    ProgressDialog pd;
    TextView txtJson;
    TextView textView3;
    TextView textView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pruebas);
        new JsonTask().execute("https://jsonplaceholder.typicode.com/todos/1");

        btnHit = (Button) findViewById(R.id.btnHit);
        post = (Button) findViewById(R.id.xpost);
        txtJson = (TextView) findViewById(R.id.tvJsonItem);


        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);


        //BTN GET
        btnHit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new JsonTask().execute("https://jsonplaceholder.typicode.com/todos/2");
            }
        });

        //BTNPOST
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncT asyncT = new AsyncT();
                asyncT.execute();
            }
        });


    }//fin oncreate



//________________________
private class JsonTask extends AsyncTask<String, String, String>
{

    protected void onPreExecute() {
        super.onPreExecute();

        pd = new ProgressDialog(Pruebas.this);
        pd.setMessage("Please wait");
        pd.setCancelable(false);
        pd.show();
    }

    protected String doInBackground(String... params) {


        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL(params[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();


            InputStream stream = connection.getInputStream();

            reader = new BufferedReader(new InputStreamReader(stream));

            StringBuffer buffer = new StringBuffer();
            String line = "";

            while ((line = reader.readLine()) != null) {
                buffer.append(line+"\n");
                Log.d("Response: ", "> " + line);   //here u ll get whole response...... :-)

            }

            return buffer.toString();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if (pd.isShowing()){
            pd.dismiss();
        }
        txtJson.setText(result);



        //*******************************************************
        String  jsonString =result; //http request
        RootClass data =new RootClass() ;
        Gson gson = new Gson();
        data= gson.fromJson(jsonString,RootClass.class);
        //***********************************************
        //data.title
        textView3.setText(data.title);
        textView4.setText(""+data.id);





    }
}//fin jsontask


    class RootClass
    {
        //userid int
        //id int
        //title text
        //completed boolean
        private int userid;

        public int getFielduserid() {
            return userid;
        }

        public void setFielduserid(int userid) {
            this.userid = userid;
        }//.........

        private int id;

        public int getFieldid() {
            return id;
        }

        public void setFieldid(int id) {
            this.id = id;
        }//.........

        private String title;

        public String getFieldtitle() {
            return title;
        }

        public void setFieldtitle(String title) {
            this.title = title;
        }//.........

        private boolean completed;

        public boolean getFieldcompleted() {
            return completed;
        }

        public void setFieldtitle(boolean completed) {
            this.completed = completed;
        }//.........


    }//find class


    //----------------------------------POST-------------------------------------------------

    class AsyncT extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... params) {

            try {
                URL url = new URL("https://jsonplaceholder.typicode.com/POST"); //Enter URL here
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST"); // here you are telling that it is a POST request, which can be changed into "PUT", "GET", "DELETE" etc.
                httpURLConnection.setRequestProperty("Content-Type", "application/json"); // here you are setting the `Content-Type` for the data you are sending which is `application/json`
                httpURLConnection.connect();

                JSONObject jsonObject = new JSONObject();
                jsonObject.put("para_1", "arg_1");

                DataOutputStream wr = new DataOutputStream(httpURLConnection.getOutputStream());
                wr.writeBytes(jsonObject.toString());
                textView3.setText(jsonObject.toString());
                wr.flush();
                wr.close();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }


    }
//fin post




}//find proyect

