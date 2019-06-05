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

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    EditText firstNumEditText;
    EditText secondNumEditText;
    TextView resultTextView;
    ProgressDialog pd;
    getClass data =new getClass() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNumEditText =(EditText) findViewById(R.id.firstNumEditText);
        //secondNumEditText=(EditText) findViewById(R.id.secondNumEditText);
        resultTextView=(TextView) findViewById(R.id.resultTextView);

        Button addBtn = (Button) findViewById(R.id.addBtn);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //int num1=Integer.parseInt(firstNumEditText.getText().toString());

                //int num2=Integer.parseInt(secondNumEditText.getText().toString());

                //int result=num1+num2;

                new JsonTask().execute("https://jsonplaceholder.typicode.com/todos/"+firstNumEditText.getText().toString());
            }
        });
    }//fin void on create

    //________________________
    private class JsonTask extends AsyncTask<String, String, String>
    {

        protected void onPreExecute() {
            super.onPreExecute();

            pd = new ProgressDialog(MainActivity.this);
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
            //textView.setText("json: "+result);



            //*******************************************************
            String  jsonString =result; //http request
            Gson gson = new Gson();
            data= gson.fromJson(jsonString,getClass.class);
            //***********************************************
            //data.title
            resultTextView.setText(""+data.title);

        }
    }//fin jsontask

    //class
    class getClass
    {
        //userid int
        //id int
        //title text
        //completed boolean
        private int userId;

        private int id;

        private String title;

        private boolean completed;

    }//find class
    //fin class
}
