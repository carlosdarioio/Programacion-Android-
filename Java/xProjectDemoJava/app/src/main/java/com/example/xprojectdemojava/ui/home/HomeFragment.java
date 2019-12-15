package com.example.xprojectdemojava.ui.home;

import android.content.Intent;
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

import com.example.xprojectdemojava.Actividades1;
import com.example.xprojectdemojava.DasdBoard;
import com.example.xprojectdemojava.Operarios1;
import com.example.xprojectdemojava.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    Button btnActividades,button5;

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


        //por aqui vas programando el menu, nota x  jaca sino el terma
        //te detesniste aqui pa confirmar si el menu se abre
        btnActividades=root.findViewById(R.id.btnActividades);
        btnActividades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Actividades1.class);
                startActivity(intent);

            }
        });



        //firmatos de form que empezaste asiendo
        button5=root.findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Operarios1.class);
                startActivity(intent);

            }
        });

        return root;
    }
}