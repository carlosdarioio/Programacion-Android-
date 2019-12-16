package com.example.xprojectdemojava.ui.send;
//send es Configuracion General
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SendViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SendViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Configuracion General");
    }

    public LiveData<String> getText() {
        return mText;
    }
}