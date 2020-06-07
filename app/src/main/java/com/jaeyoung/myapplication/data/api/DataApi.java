package com.jaeyoung.myapplication.data.api;

import com.jaeyoung.myapplication.data.response.DataResponse;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface DataApi {
    @GET("/api/v1/employees")
    Single<DataResponse> getData();
}
