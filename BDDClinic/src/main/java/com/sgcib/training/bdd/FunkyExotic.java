package com.sgcib.training.bdd;

import java.util.Currency;
import java.util.Date;

public class FunkyExotic {
    private String dealWay;
    private String dealNature;
    private Date date;
    private Currency currencyNominal;
    private int nominal;
    private double negociationPrice;
    private Currency currencyNego;
    private int cashfFlow;
    private int feeCashfFlow;
    private String cashFlowWay;
    private int amout;
    private String feeCashfFlowWay;
    private int feeAmount;

    public void setDealWay(String dealWay) {
        this.dealWay = dealWay;
    }

    public void setDealNature(String dealNature) {
        this.dealNature = dealNature;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setNominal(int nominal,Currency currency) {
        this.nominal = nominal;
        this.currencyNominal = currency;
    }

    public void setNegociationPrice(double negociationPrice, Currency japan) {
        this.negociationPrice = negociationPrice;
        this.currencyNego = japan;
    }

    public void validate() {
        this.cashfFlow = 1;
        if (this.negociationPrice < 0)
            this.feeCashfFlow = 1;
        else this.feeCashfFlow = 0;
        this.cashFlowWay = "receive";
        double amountAsDouble = nominal * negociationPrice;
        this.amout = Math.abs(new Double(amountAsDouble).intValue());
        this.feeCashfFlowWay = "give";
        this.feeAmount = 2 * amout;
    }

    public int getPriceCashfFlow() {
        return cashfFlow;
    }

    public int getFeeCashfFlow() {
        return feeCashfFlow;
    }

    public Date getDate() {
        return date;
    }


    public String getCashFlowWay() {
        return cashFlowWay;
    }

    public int getAmout() {
        return amout;
    }

    public String getFeeCashfFlowWay() {
        return feeCashfFlowWay;
    }

    public int getFeeAmount() {
        return feeAmount;
    }
}


