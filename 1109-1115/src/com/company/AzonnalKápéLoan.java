package com.company;

public class AzonnalKápéLoan extends LoanCalculator {

    public AzonnalKápéLoan (LoanResponse response) {
        super(response);
    }

    @Override
    public int monthlyFeeCalculator(LoanRequest customer) {
        LoanResponse loanResponse = new LoanResponse();
        int monthlyFee;
        int customerAmount = customer.getAmount();
        int period = customer.getPeriod();
        if (!customer.isVip()) {
            customer.setPeriod(customer.getPeriod()-6);
            customer.setAmount(customer.getAmount()-45000);
            monthlyFee = (int) ((customerAmount * (1.5 + (0.03 * (period - 12)))) / customer.getPeriod());
        } else {
            customer.setPeriod(customer.getPeriod()-6);
            customer.setAmount(customer.getAmount()-45000);
            monthlyFee = (int) ((customerAmount * (1.4 + (0.02 * (period - 12)))) / customer.getPeriod());
        }
        loanResponse.setMonthlyFee(monthlyFee);
        return monthlyFee;
    }
}