package com.example.daniellachacz.currencyconverter2.data.network;

import com.example.daniellachacz.currencyconverter2.data.model.Currency;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("currency")
    Call<Currency> getCurrentCurrency(
            @Query("base") String base,
            @Query("target") String target,
            @Query("apikey") String apiKey);
}
