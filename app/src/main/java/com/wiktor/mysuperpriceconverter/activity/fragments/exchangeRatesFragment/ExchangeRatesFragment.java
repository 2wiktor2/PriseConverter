package com.wiktor.mysuperpriceconverter.activity.fragments.exchangeRatesFragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.wiktor.mysuperpriceconverter.R;
import com.wiktor.mysuperpriceconverter.activity.Constants;
import com.wiktor.mysuperpriceconverter.activity.fragments.exchangeRatesFragment.adapter.RecyclerViewAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ExchangeRatesFragment extends Fragment {

    RecyclerView recyclerView;

    List <Pojo> listPogo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_for_exchange_rates, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = getActivity().findViewById(R.id.rv_exchange_rates_container);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();

        Client client = retrofit.create(Client.class);
        Call<List<Pojo>> call = client.reposForUser(Constants.USER);
        call.enqueue(new Callback <List <Pojo>>() {
            @Override
            public void onResponse(Call <List <Pojo>> call, Response<List <Pojo>> response) {
                List<Pojo> repos = response.body();
                RecyclerViewAdapter adapter = new RecyclerViewAdapter(repos, getContext());
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call <List <Pojo>> call, Throwable t) {
                Toast.makeText(getActivity(), "Что-то не так с интернетом", Toast.LENGTH_SHORT).show();
            }
        });

    }
}






























