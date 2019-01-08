package com.example.daniellachacz.currencyconverter2.viewmodel;

import android.app.Application;

import com.example.daniellachacz.currencyconverter2.data.CurrencyRepository;
import com.example.daniellachacz.currencyconverter2.data.network.ApiClient;

import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class MainViewModel extends AndroidViewModel {

    private CurrencyRepository currencyRepository;
    public final ObservableField<String> from = new ObservableField<>();
    public final ObservableField<String> to = new ObservableField<>();

    public MainViewModel(Application application) {
       super(application);
       currencyRepository = new CurrencyRepository(application);
    }

    public void setCurrencies() {
        currencyRepository.getCurrency(String.valueOf(from.get()), String.valueOf(to.get()), ApiClient.KEY);
    }

    public LiveData<Double> getRate() {
        return currencyRepository.getRate();
    }

}