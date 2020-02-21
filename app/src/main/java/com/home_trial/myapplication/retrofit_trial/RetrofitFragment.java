package com.home_trial.myapplication.retrofit_trial;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.home_trial.myapplication.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFragment extends Fragment implements View.OnClickListener {
    private Button fetchResponseButton;
    public static final String TAG = "RetrofitFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.retrofit_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fetchResponseButton = view.findViewById(R.id.fetcher_button);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        fetchResponseButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        startFetchingUsingRetrofit();
    }

    private void startFetchingUsingRetrofit() {
        Log.e(TAG, "startFetchingUsingRetrofit: called" );
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiCaller.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiCaller apiCaller = retrofit.create(ApiCaller.class);
        Call<EmployeeData> employeeData = apiCaller.getData();
        employeeData.enqueue(new Callback<EmployeeData>() {
            @Override
            public void onResponse(Call<EmployeeData> call,
                                   Response<EmployeeData> response) {
                Log.d(TAG, "onResponse: "+response.body());
            }

            @Override
            public void onFailure(Call<EmployeeData> call,
                                  Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage());
            }
        });
    }
}