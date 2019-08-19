package com.example.intentobjectjava.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.intentobjectjava.R;
import com.example.intentobjectjava.model.MDetalles;
import com.squareup.picasso.Picasso;

public class DetallerActivity extends AppCompatActivity {
    private TextView tvNombre,tvDescripcion;
    private ImageView ivImagen;
    private MDetalles mDetalles;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        try{
        mDetalles=(MDetalles) getIntent().getExtras().getSerializable("model");
        }catch (Exception e)
        {
            finish();
        }

        ivImagen = (ImageView) findViewById(R.id.ad_iv_imagen);
        tvNombre=(TextView) findViewById(R.id.ad_tv_nombre);
        tvDescripcion=(TextView) findViewById(R.id.ad_tv_descripcion);

        tvNombre.setText(mDetalles.getNombre());
        tvDescripcion.setText(mDetalles.getDescripcion());







    }

    public static Intent getCallingIntent(Context context, MDetalles mDetalles){

        Intent intent = new Intent(context,DetallerActivity.class);

        //pasando modelo completo
        intent.putExtra("model",mDetalles);
        return intent;

    }
}
