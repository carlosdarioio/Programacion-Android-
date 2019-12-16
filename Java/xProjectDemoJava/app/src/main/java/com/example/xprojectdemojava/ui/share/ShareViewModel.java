package com.example.xprojectdemojava.ui.share;
//share es cosecha
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ShareViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ShareViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Cosechas");
    }

    public LiveData<String> getText() {
        return mText;
    }
}