package com.jaeyoung.myapplication.data.response;

import com.google.gson.annotations.SerializedName;
import com.jaeyoung.myapplication.data.domain.Data;

import java.util.List;

public class DataResponse {
    public @SerializedName("status") String status;
    public @SerializedName("data") List<Data> items;
}
