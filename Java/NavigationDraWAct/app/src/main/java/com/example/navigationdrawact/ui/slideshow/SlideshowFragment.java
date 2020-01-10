package com.example.navigationdrawact.ui.slideshow;

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

import com.example.navigationdrawact.ClBuscar;
import com.example.navigationdrawact.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SlideshowFragment extends Fragment {
    //clientes----------------
    private SlideshowViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        slideshowViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        Date today = Calendar.getInstance().getTime();//getting date
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");//formating according to my need
        String date = formatter.format(today);


        long timeInMillis = System.currentTimeMillis();
        Calendar cal1 = Calendar.getInstance();
        cal1.setTimeInMillis(timeInMillis);
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "dd/MM/yyyy hh:mm:ss a");
        String hour = dateFormat.format(cal1.getTime());


        TextView clindexfecha = root.findViewById(R.id.clindexfecha);
        clindexfecha.setText(date);

        TextView clindexhora = root.findViewById(R.id.clindexhora);
        clindexhora.setText(hour);


        //------------------
        Button btnDatosCL;
        btnDatosCL = root.findViewById(R.id.btnDatosCL);
        btnDatosCL.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ClBuscar.class);
                startActivity(intent);
            }
        });
        //----------


        return root;
    }
}