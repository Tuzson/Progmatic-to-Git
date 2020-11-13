package com.company;

public class LoanResponse {
    private boolean isGranted;
    private boolean needsSuccessor;
    private boolean needsCoverage;
    private int coverageAmount;
    private int monthlyFee;

   public LoanResponse(){

    }

    public void setCoverageAmount(int coverageAmount) {
        this.coverageAmount = coverageAmount;
    }

    public void setGranted(boolean granted) {
        isGranted = granted;
    }

    public void setMonthlyFee(int monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    public void setNeedsCoverage(boolean needsCoverage) {
        this.needsCoverage = needsCoverage;
    }

    public void setNeedsSuccessor(boolean needsSuccessor) {
        this.needsSuccessor = needsSuccessor;
    }

    public int getCoverageAmount() {
        return coverageAmount;
    }

    public int getMonthlyFee() {
        return monthlyFee;
    }

    public boolean needsCoverage() {
        return needsCoverage;
    }

    public boolean isGranted() {
        return isGranted;
    }

    public boolean isNeedsSuccessor() {
        return needsSuccessor;
    }

}
