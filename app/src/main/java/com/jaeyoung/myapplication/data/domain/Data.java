package com.jaeyoung.myapplication.data.domain;

import com.google.gson.annotations.SerializedName;

public class Data {
    public @SerializedName("id") int id;
    public @SerializedName("employee_name") String name;
    public @SerializedName("employee_salary") String salary;
}
