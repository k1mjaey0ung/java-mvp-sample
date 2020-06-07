package com.jaeyoung.myapplication.repository;

import com.jaeyoung.myapplication.data.api.DataApi;

import java.util.concurrent.TimeUnit;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataRepository {
    public DataApi create() {
        return createRetrofit().create(DataApi.class);
    }

    private Retrofit createRetrofit() {
        return new Retrofit.Builder()
            .client(new OkHttpClient.Builder()
                    .connectionPool(new ConnectionPool(5, 20, TimeUnit.SECONDS))
                    .build())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://dummy.restapiexample.com/")
            .build();
    }
}
