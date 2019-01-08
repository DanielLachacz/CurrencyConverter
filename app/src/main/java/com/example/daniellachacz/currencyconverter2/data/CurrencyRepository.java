package com.example.daniellachacz.currencyconverter2.data;

import android.app.Application;

import com.example.daniellachacz.currencyconverter2.data.model.Currency;
import com.example.daniellachacz.currencyconverter2.data.network.ApiClient;
import com.example.daniellachacz.currencyconverter2.data.network.ApiInterface;

import java.text.DecimalFormat;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CurrencyRepository {

    private ApiInterface apiInterface;
    private  String apiKey = ApiClient.KEY;
    private MutableLiveData<Double> rate = new MutableLiveData<>();

    public CurrencyRepository(Application application) {
       apiInterface = ApiClient.getClient();
    }

    public LiveData<Currency> getCurrency(String base, final String target, String apiKey) {

        final MutableLiveData<Currency> data = new MutableLiveData<>();
        apiInterface.getCurrentCurrency(base, target, apiKey).enqueue(new Callback<Currency>() {
            @Override
            public void onResponse(Call<Currency> call, Response<Currency> response) {
                data.setValue(response.body());

                String get = data.getValue().getTarget();
                DecimalFormat df = new DecimalFormat("#0.00");
                switch (get) {
                    case "EUR":
                        rate.postValue(Double.valueOf(df.format(data.getValue().getRates().getEUR())));
                        break;
                    case "PLN":
                        rate.postValue(Double.valueOf(df.format(data.getValue().getRates().getPLN())));
                        break;
                    case "USD":
                        rate.postValue(Double.valueOf(df.format(data.getValue().getRates().getUSD())));
                        break;
                    case "CHF":
                        rate.postValue(Double.valueOf(df.format(data.getValue().getRates().getCHF())));
                        break;
                }
            }

            @Override
            public void onFailure(Call<Currency> call, Throwable t) {

            }
        });
        return data;
    }

    public LiveData<Double> getRate() {
        return rate;
    }

}
