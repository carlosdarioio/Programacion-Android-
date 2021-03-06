package com.example.navigationdrawact.ui.home;

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

import com.example.navigationdrawact.BuscarFactura;
import com.example.navigationdrawact.ClBuscar;
import com.example.navigationdrawact.DarDescuentoManual;
import com.example.navigationdrawact.DesbloquearArticulos;
import com.example.navigationdrawact.Main2ActivityBasic;
import com.example.navigationdrawact.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);


        homeViewModel.getText().observe(this, new Observer<String>() {


            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);


            }
        });

        //------------------
        Button btBuscaFactura;
        btBuscaFactura = root.findViewById(R.id.btBuscaFactura);
        btBuscaFactura.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BuscarFactura.class);
                startActivity(intent);
            }
        });
        //----------

        //------------------
        Button btnDarDescuentoManual;
        btnDarDescuentoManual = root.findViewById(R.id.btnDescuentoManual);
        btnDarDescuentoManual.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DarDescuentoManual.class);
                startActivity(intent);
            }
        });
        //----------

        //------------------
        Button btnDesbloquearArt;
        btnDesbloquearArt = root.findViewById(R.id.btnDesbloquearArt);
        btnDesbloquearArt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DesbloquearArticulos.class);
                startActivity(intent);
            }
        });
        //----------

        //------------------
        Button btnReimpContraEntrega;
        btnReimpContraEntrega = root.findViewById(R.id.btnReimpContraEntrega);
        btnReimpContraEntrega.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://10.1.201.5/DxWebIT//Ventas/ReimprContEntrega.aspx"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        //----------




        return root;
    }
}