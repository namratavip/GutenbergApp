package com.androidmodule.gutenbergapp.data.api;


import com.androidmodule.gutenbergapp.data.model.Response;

import io.reactivex.Observable;

public class ApiServiceImpl implements ApiHelper{

    public ApiService apiService;

    public ApiServiceImpl(ApiService apiService){
        this.apiService = apiService;
    }

    @Override
    public Observable<Response> getResponse(String searchKey, String apiKey, String format) {
        return apiService.getResponse(searchKey,apiKey,format);
    }
}
