package com.example.navigationdrawact.ui.gallery;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;


import com.example.navigationdrawact.R;

public class GalleryFragment extends Fragment {
/*--//caja*/
    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        galleryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });


        //------------------
        Button xbtnReimprDepoRet;
        xbtnReimprDepoRet = root.findViewById(R.id.btnReimprDepoRet);
        xbtnReimprDepoRet.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://10.1.201.5/DxWebIT/Caja/ReimpDepRet.aspx"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });
        //----------
        //------------------
        Button xbtnReimpReciboCaja;
        xbtnReimpReciboCaja = root.findViewById(R.id.btnReimpReciboCaja);
        xbtnReimpReciboCaja.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://10.1.201.5/DxWebIT/ReimpPagoRecibido.aspx"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });
        //----------

        return root;
    }
}