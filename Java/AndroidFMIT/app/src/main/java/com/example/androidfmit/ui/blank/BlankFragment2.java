package com.example.androidfmit.ui.blank;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.androidfmit.R;

public class BlankFragment2 extends Fragment {

    private BlankFragment2ViewModel mViewModel;

    //public static BlankFragment2 newInstance() {        return new BlankFragment2();    }

    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.blank_fragment2_fragment, container, false);
        mViewModel =
                ViewModelProviders.of(this).get(BlankFragment2ViewModel.class);
        View root = inflater.inflate(R.layout.blank_fragment2_fragment, container, false);
        final TextView textView = root.findViewById(R.id.text_blankshow);
        mViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;

    }



}
