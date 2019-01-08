
package com.example.daniellachacz.currencyconverter2.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rates {

    @SerializedName("EUR")
    @Expose
    private double eUR;

    @SerializedName("PLN")
    @Expose
    private double pLN;

    @SerializedName("USD")
    @Expose
    private double uSD;

    @SerializedName("CHF")
    @Expose
    private double cHF;


    public double getEUR() {
        return eUR;
    }

    public void setEUR(double eUR) {
        this.eUR = eUR;
    }

    public double getPLN() {
        return pLN;
    }

    public void setPLN(double pLN) {
        this.pLN = pLN;
    }

    public double getUSD() {
        return uSD;
    }

    public void setUSD(double uSD) {
        this.uSD = uSD;
    }

    public double getCHF() {
        return cHF;
    }

    public void setCHF(double cHF) {
        this.cHF = cHF;
    }
}
