package com.wiktor.mysuperpriceconverter.activity.fragments.exchangeRatesFragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Client {

    // получился синхронный метод

    @GET("/users/{user}/repos")
        // такой результат нужно получить в конце.   конечная точка.
    Call<List<Pojo>> reposForUser(@Path("user") String user);
}
