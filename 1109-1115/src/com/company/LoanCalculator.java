package com.company;

public class LoanCalculator {

    private LoanRequest customer;
    private LoanResponse response;

    public LoanCalculator(LoanResponse response) {
        this.response = response;
    }

    public void requestDecision(LoanRequest customer1) {
        if (!customer1.isVip() && customer1.getAmount() <= 20000000) {
            if (customer1.getAmount() > 500000 && customer1.getAmount() <= 3000000) {
                response.setGranted(true);
                response.setNeedsCoverage(true);
                response.setCoverageAmount(coverageCalculator(customer1));
                response.setMonthlyFee(monthlyFeeCalculator(customer1));
            } else if (customer1.getAmount() > 3000000) {
                response.setGranted(true);
                response.setNeedsCoverage(true);
                response.setNeedsSuccessor(true);
                response.setCoverageAmount(coverageCalculator(customer1));
                response.setMonthlyFee(monthlyFeeCalculator(customer1));
            } else {
                response.setGranted(true);
                response.setMonthlyFee(monthlyFeeCalculator(customer1));

            }
        } else if (!customer1.isVip() && customer1.getAmount() > 20000000) {
            response.setGranted(false);
            //túl sokat akar felvenni
        }
        if (customer1.isVip() && customer1.getAmount() <= 50000000) {
            if (customer1.getAmount() > 3000000 && customer1.getAmount() <= 20000000) {
                response.setGranted(true);
                response.setNeedsCoverage(true);
                response.setCoverageAmount(coverageCalculator(customer1));
                response.setMonthlyFee(monthlyFeeCalculator(customer1));
            } else if (customer1.getAmount() > 20000000) {
                response.setGranted(true);
                response.setNeedsCoverage(true);
                response.setNeedsSuccessor(true);
                response.setCoverageAmount(coverageCalculator(customer1));
                response.setMonthlyFee(monthlyFeeCalculator(customer1));
            } else {
                response.setGranted(true);
                response.setMonthlyFee(monthlyFeeCalculator(customer1));
            }

        } else if (customer1.isVip() && customer1.getAmount() > 50000000) {
            response.setGranted(false);
        }
    }

    public int coverageCalculator(LoanRequest customer) {
        int coverageAmount;
        if (!customer.isVip()) {
            coverageAmount = (int) (customer.getAmount() * 0.8);
        } else {
            coverageAmount = (int) (customer.getAmount() * 0.7);
        }
        return coverageAmount;
    }

    public int monthlyFeeCalculator(LoanRequest customer) {
        int monthlyFee;
        int customerAmount = customer.getAmount();
        int period = customer.getPeriod();
        if (!customer.isVip()) {
            monthlyFee = (int) ((customerAmount * (1.5 + (0.03 *(period-12))))/ customer.getPeriod());
        } else {
            monthlyFee = (int) ((customerAmount * (1.4 + (0.02 *(period-12))))/ customer.getPeriod());
        }
        return monthlyFee;
    }
}