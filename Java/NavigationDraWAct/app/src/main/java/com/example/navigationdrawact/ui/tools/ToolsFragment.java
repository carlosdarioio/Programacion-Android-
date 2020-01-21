package com.example.navigationdrawact.ui.tools;

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
import com.example.navigationdrawact.TransBuscar2;

public class ToolsFragment extends Fragment {

    private ToolsViewModel toolsViewModel;
//Despacho
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        toolsViewModel =
                ViewModelProviders.of(this).get(ToolsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tools, container, false);
        final TextView textView = root.findViewById(R.id.text_tools);
        toolsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        //------------------
        Button btnReimpTicketDespacho;
        btnReimpTicketDespacho = root.findViewById(R.id.btnReimpTicketDespacho);
        btnReimpTicketDespacho.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://10.1.201.5/DxWebIT/Bodega/xxReimprTKDespxx.aspx"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        //----------

        //------------------
        Button btnCambZonaxFactura;
        btnCambZonaxFactura = root.findViewById(R.id.btnCambZonaxFactura);
        btnCambZonaxFactura.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://10.1.201.5/DxWebIT/CambZnxFact.aspx"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        //-----------------


        //------------------
        Button btnRSolTras;
        btnRSolTras = root.findViewById(R.id.btnRSolTras);
        btnRSolTras.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TransBuscar2.class);
                startActivity(intent);
            }
        });
        //----------


        return root;
    }
}