package com.androidmodule.gutenbergapp.ui.base;

import com.androidmodule.gutenbergapp.data.api.ApiHelper;
import com.androidmodule.gutenbergapp.ui.main.viewmodel.MainViewModel;


import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelFactory implements ViewModelProvider.Factory {

    public ApiHelper apiHelper;

    public ViewModelFactory(ApiHelper apiHelper){
        this.apiHelper = apiHelper;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)){
            return (T) new MainViewModel(apiHelper);
        }
        throw new IllegalArgumentException("Unknown class name");
    }
}
