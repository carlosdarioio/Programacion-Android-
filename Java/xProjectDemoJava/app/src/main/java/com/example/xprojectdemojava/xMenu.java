package com.example.xprojectdemojava;
//menu general
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class xMenu extends AppCompatActivity {
TextView xMenuDas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_x_menu);
        xMenuDas=findViewById(R.id.xMenuDas);

        xMenuDas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(xMenu.this,DasdBoard.class);
                startActivity(intent);

            }
        });
    }
}
