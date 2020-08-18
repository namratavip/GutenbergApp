package com.androidmodule.gutenbergapp.util;

public class Resource<T> {

    public Status status;
    public T data;
    public String message;

    public Resource(Status status, T data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public static  <T> Resource success(T data) {
        return new Resource(Status.SUCCESS, data, null);
    }

    public static <T> Resource error(T data, String message) {
        return new Resource(Status.ERROR, data, message);
    }

    public static <T> Resource loading(T data) {
        return new Resource(Status.LOADING, data, null);
    }
}
