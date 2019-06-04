package com.udemyandroid.viewcomponents;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HomeActivity extends AppCompatActivity {
    TextView textEmail;

    ProgressDialog pd;
    TextView textView;
    TextView textView2;
    TextView textView3;

    RootClass data =new RootClass() ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Bundle extras = getIntent().getExtras();
        String xclave = extras.getString("cl");

        textEmail = findViewById(R.id.textViewEmail);
        textEmail.setText("clave ingresada : " + xclave);

        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);


        new JsonTask().execute("https://jsonplaceholder.typicode.com/todos/"+xclave);//tenia 2
    }




    //________________________
    private class JsonTask extends AsyncTask<String, String, String>
    {

        protected void onPreExecute() {
            super.onPreExecute();

            pd = new ProgressDialog(HomeActivity.this);
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
            textView.setText("json: "+result);



            //*******************************************************
            String  jsonString =result; //http request
            Gson gson = new Gson();
            data= gson.fromJson(jsonString,RootClass.class);
            //***********************************************
            //data.title
            textView2.setText("Respuesta: "+data.title);
            textView3.setText("id:"+data.id);





        }
    }//fin jsontask


    class RootClass
    {
        //userid int
        //id int
        //title text
        //completed boolean
        private int userId;

        public int getFielduserid() {
            return userId;
        }

        public void setFielduserid(int userid) {
            this.userId = userId;
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

}
