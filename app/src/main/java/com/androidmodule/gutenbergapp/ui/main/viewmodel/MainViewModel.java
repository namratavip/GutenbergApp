package com.androidmodule.gutenbergapp.ui.main.viewmodel;

import android.util.Log;

import com.androidmodule.gutenbergapp.data.api.ApiHelper;
import com.androidmodule.gutenbergapp.data.model.Album;
import com.androidmodule.gutenbergapp.data.model.Response;
import com.androidmodule.gutenbergapp.util.Constant;
import com.androidmodule.gutenbergapp.util.Resource;


import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends ViewModel {

    private ApiHelper apiHelper;
    private MutableLiveData<Resource<List<Album>>> albumList;
    private CompositeDisposable compositeDisposable;

    public MainViewModel(ApiHelper apiHelper) {
        this.apiHelper = apiHelper;
        albumList = new MutableLiveData<>();
        compositeDisposable = new CompositeDisposable();
    }

    public void searchKey(String key) {
        searchAlbum(key);
    }

    private void searchAlbum(String searchKey) {
        albumList.postValue(Resource.loading(null));
        compositeDisposable.add(apiHelper.getResponse(searchKey, Constant.API_KEY,"json")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(getObserver()));
    }


    private DisposableObserver<Response> getObserver() {
        return new DisposableObserver<Response>() {

            @Override
            public void onNext(Response response) {
                Log.d("albumSize",""+response.getResults().getAlbumMatches().getAlbum().size());
                albumList.postValue(Resource.success(response.getResults().getAlbumMatches().getAlbum()));
            }

            @Override
            public void onError(Throwable e) {
                Log.d("Error*",""+e.getMessage());
                albumList.postValue(Resource.error(e.toString(), null));
            }

            @Override
            public void onComplete() {

            }
        };
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }

    public MutableLiveData<Resource<List<Album>>> getAlbums() {
        return albumList;
    }
}
