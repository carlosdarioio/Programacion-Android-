package com.example.xprojectdemojava.ui.tools;
//tools es Presupuestos
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ToolsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ToolsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Presupuestos");
    }

    public LiveData<String> getText() {
        return mText;
    }
}