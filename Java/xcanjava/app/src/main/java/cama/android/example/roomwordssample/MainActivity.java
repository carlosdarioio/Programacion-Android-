/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cama.android.example.roomwordssample;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import cama.android.example.roomwordssample.R;

import java.util.ArrayList;
import java.util.List;
//idea
//que al insertar x valor cargue otra vez le inicio
// y que a ala vez aprete automTICO el agegar mas para que lo dirija d enuevo
//si quiere verlos que solo aprete pa tras
//en la otra ventana programar que cuando deje de escribir aprete el boton de agregar

//ver como haces el post lo de insertado al wcf
public class MainActivity extends AppCompatActivity {

    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;
    public static final int UPDATE_WORD_ACTIVITY_REQUEST_CODE = 2;

    public static final String EXTRA_DATA_UPDATE_WORD = "extra_word_to_be_updated";
    public static final String EXTRA_DATA_ID = "extra_data_id";

    private WordViewModel mWordViewModel;

    private RequestQueue queue2;
    Button brnpost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        // Set up the RecyclerView.
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final WordListAdapter adapter = new WordListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Set up the WordViewModel.
        mWordViewModel = ViewModelProviders.of(this).get(WordViewModel.class);
        // Get all the words from the database
        // and associate them to the adapter.
        mWordViewModel.getAllWords().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(@Nullable final List<Word> words) {
                // Update the cached copy of the words in the adapter.
                adapter.setWords(words);
            }
        });

        // Floating action button setup
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewWordActivity.class);
                startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
            }
        });

        //2019 10 05 boton para efectuar post alola
        FloatingActionButton fab2 = findViewById(R.id.fab3);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"brnpost:",Toast.LENGTH_LONG).show();
                PostVolleyinsert();
            }
        });




        // Add the functionality to swipe items in the
        // RecyclerView to delete the swiped item.
        ItemTouchHelper helper = new ItemTouchHelper(
                new ItemTouchHelper.SimpleCallback(0,
                        ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
                    @Override
                    // We are not implementing onMove() in this app.
                    public boolean onMove(RecyclerView recyclerView,
                                          RecyclerView.ViewHolder viewHolder,
                                          RecyclerView.ViewHolder target) {
                        return false;
                    }

                    @Override
                    // When the use swipes a word,
                    // delete that word from the database.
                    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                        int position = viewHolder.getAdapterPosition();
                        Word myWord = adapter.getWordAtPosition(position);
                        Toast.makeText(MainActivity.this,
                                getString(R.string.delete_word_preamble) + " " +
                                myWord.getWord(), Toast.LENGTH_LONG).show();

                        // Delete the word.
                        mWordViewModel.deleteWord(myWord);
                    }
                });
        // Attach the item touch helper to the recycler view.
        helper.attachToRecyclerView(recyclerView);

        adapter.setOnItemClickListener(new WordListAdapter.ClickListener()  {

            @Override
            public void onItemClick(View v, int position) {
                Word word = adapter.getWordAtPosition(position);
                launchUpdateWordActivity(word);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;



    }

    // The options menu has a single item "Clear all data now"
    // that deletes all the entries in the database.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, as long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.clear_data) {
            // Add a toast just for confirmation
            Toast.makeText(this, R.string.clear_data_toast_text, Toast.LENGTH_LONG).show();

            // Delete the existing data.
            mWordViewModel.deleteAll();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * When the user enters a new word in the NewWordActivity,
     * that activity returns the result to this activity.
     * If the user entered a new word, save it in the database.

     * @param requestCode ID for the request
     * @param resultCode indicates success or failure
     * @param data The Intent sent back from the NewWordActivity,
     *             which includes the word that the user entered
     */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Word word = new Word(data.getStringExtra(NewWordActivity.EXTRA_REPLY));
            // Save the data.
            mWordViewModel.insert(word);
            //alola 2019 abriendo la ventana de inserra automatic
            Intent intent = new Intent(MainActivity.this, NewWordActivity.class);
            startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
            //fin alola
        } else if (requestCode == UPDATE_WORD_ACTIVITY_REQUEST_CODE
                && resultCode == RESULT_OK) {
            String word_data = data.getStringExtra(NewWordActivity.EXTRA_REPLY);
            int id = data.getIntExtra(NewWordActivity.EXTRA_REPLY_ID, -1);

            if (id != -1) {
                mWordViewModel.update(new Word(id, word_data));
            } else {
                Toast.makeText(this, R.string.unable_to_update,
                        Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(
                    this, R.string.empty_not_saved, Toast.LENGTH_LONG).show();
        }
    }

    public void launchUpdateWordActivity( Word word) {
        Intent intent = new Intent(this, NewWordActivity.class);
        intent.putExtra(EXTRA_DATA_UPDATE_WORD, word.getWord());
        intent.putExtra(EXTRA_DATA_ID, word.getId());
        startActivityForResult(intent, UPDATE_WORD_ACTIVITY_REQUEST_CODE);
    }


    //----------------------------
    private void PostVolleyinsert()
    {
        //final String url = "http://10.1.0.93:81/SapService.svc/xPostScanJava";//trabajo
        final String url = "http://192.168.0.17:80/CFService/SapService.svc/xcanjava";//casa xPostScanJava!testPostScanJava
        // Instantiate the RequestQueue.
        queue2 = Volley.newRequestQueue(this);
        Gson gson = new Gson();
        JSONObject xRootObject = new JSONObject();

        try
        {
            String json =gson.toJson(mWordViewModel.getAllWords().getValue());
            Log.d("gson.toJson", "{\"xRootObject\":"+json+"}");
            xRootObject.put("xRootObject","{\"xRootObject\":"+json+"}"    );
            //xRootObject.put("docnum","papadaosea");
        } catch (JSONException e) {
            Toast.makeText(MainActivity.this,"PostV e2:",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
        if(xRootObject.length()>0){
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, xRootObject, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response)
                {
                    try
                    {
                        Log.d("response ", response.toString());

                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this,"PostV e3:",Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }//contralor
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    Log.d("PostV e4: ",error.toString());
                }
            });
            queue2.add(request);
            //--xtxtcount.setText("");
        }//Fin if
        else{Toast.makeText(MainActivity.this," osea no puede ser <6 ",Toast.LENGTH_LONG).show();}
    }//fin PostVolleyinsert

    // ----------------------------
}//fin MainActiivity