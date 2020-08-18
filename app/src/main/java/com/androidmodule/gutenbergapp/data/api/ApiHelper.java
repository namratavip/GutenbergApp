package com.androidmodule.gutenbergapp.data.api;


import com.androidmodule.gutenbergapp.data.model.Response;

import io.reactivex.Observable;

public interface ApiHelper {
    Observable<Response> getResponse(String searchKey, String apiKey, String format);
}
