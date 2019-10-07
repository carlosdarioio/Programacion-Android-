package com.example.androidfmit.ui.wfactura;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class WfacturaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public WfacturaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is wfactura fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

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




}
