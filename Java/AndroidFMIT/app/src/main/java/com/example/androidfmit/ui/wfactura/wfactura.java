package com.example.androidfmit.ui.wfactura;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidfmit.R;

import java.util.List;


public class wfactura extends Fragment {

    private WfacturaViewModel mWfacturaViewModel;



    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mWfacturaViewModel =
                ViewModelProviders.of(this).get(WfacturaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);

        //-*-prueba ejecutando startActivity
        /*
        final Button btnListF;
        btnListF=root.findViewById((R.id.btnListF));
        btnListF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ListFactura.class);
                startActivity(intent);
            }
        });
        */

        //--

        mWfacturaViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });




        return root;

    }

}
