package com.home_trial.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static com.home_trial.myapplication.MyConstants.RETROFIT;

public class MainFragment extends Fragment implements EventsInjection.Injector {
    public static final String TAG = "MainFragment";
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private String[] trialAppsArray = {"Retrofit"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        myAdapter = new MyAdapter(trialAppsArray, getActivity());

        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void injectEvent(int injectedEvent) {
switch(){
    case RETROFIT:
        OpenRetrofitFragment openRetrofitFragment = new OpenRetrofitFragment();
        break;
}
    }
}
