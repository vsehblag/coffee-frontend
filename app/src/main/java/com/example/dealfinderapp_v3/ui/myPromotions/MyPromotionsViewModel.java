package com.example.dealfinderapp_v3.ui.myPromotions;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyPromotionsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public MyPromotionsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is myPromotions fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}