
package com.example.daniellachacz.currencyconverter2.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Currency {

    @SerializedName("base")
    @Expose
    private String base;
    @SerializedName("last_update")
    @Expose
    private String lastUpdate;
    @SerializedName("rates")
    @Expose
    private Rates rates;
    @SerializedName("status")
    @Expose
    private int status;
    @SerializedName("target")
    @Expose
    private String target;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Rates getRates() {
        return rates;
    }

    public void setRates(Rates rates) {
        this.rates = rates;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

}
