package com.company;

public class LoanRequest {
    private boolean isVip = true;
    private int amount;
    private int period;

    public LoanRequest(boolean isVip,int amount, int period){
        this.isVip = isVip;
        this.amount = amount;
        this.period = period;
    }

    public int getAmount() {
        return amount;
    }

    public int getPeriod() {
        return period;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean vip) {
        isVip = vip;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPeriod(int period) {
        this.period = period;
    }
}
