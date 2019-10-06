package com.karsten.seekbarfragmentversuch.fragments;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class OpacityViewModel extends ViewModel {
    // private MutableLiveData<CharSequence> text = new MutableLiveData<>();
    // public void setText(CharSequence input) {
    //     text.setValue(input);
    // }
    // public LiveData<CharSequence> getText() {
    //      return text;
    //  }

    private MutableLiveData<Integer> mInteger = new MutableLiveData<>();
    private MutableLiveData<Integer> mIndex = new MutableLiveData<>();

    public LiveData<Integer> getInt() {
        return mInteger;
    }

    public void setInt(Integer input) {
        mInteger.setValue(input);
    }

    public void setIndex(int index) {
        mIndex.setValue(index);
    }

}
