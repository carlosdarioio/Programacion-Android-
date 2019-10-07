package com.example.androidfmit.ui.blank;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BlankFragment2ViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public BlankFragment2ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Blank2 fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

}
