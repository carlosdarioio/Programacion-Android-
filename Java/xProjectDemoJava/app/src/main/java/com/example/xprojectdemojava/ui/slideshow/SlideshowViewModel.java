package com.example.xprojectdemojava.ui.slideshow;
//menu_slideshow es inventario
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SlideshowViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SlideshowViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Inventario de la empresa");
    }

    public LiveData<String> getText() {
        return mText;
    }
}