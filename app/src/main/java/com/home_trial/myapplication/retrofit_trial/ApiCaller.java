package com.home_trial.myapplication.retrofit_trial;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiCaller {

    String BASE_URL = "https://dummy.restapiexample.com/api/v1/";

    @GET("employees")
    Call<EmployeeData> getData();
}