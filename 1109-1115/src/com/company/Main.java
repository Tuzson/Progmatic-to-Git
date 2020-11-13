package com.company;

public class Main {

    public static void main(String[] args) {
        CityBike cityBike = new CityBike(28,30,new int[]{12,14,16,18,20,22});
        cityBike.isLighting();
        cityBike.switchLight();
        cityBike.isLighting();
        cityBike.horning();
        LoanRequest loanRequest = new LoanRequest(false,2000000,25);
        LoanResponse loanResponse = new LoanResponse();
        AzonnalKápéLoan loan = new AzonnalKápéLoan(loanResponse);
        loan.monthlyFeeCalculator(loanRequest);
        response(loanRequest,loan,loanResponse);



    }
    public static void response (LoanRequest customer, LoanCalculator bank, LoanResponse answer) {
        bank.requestDecision(customer);

        if (!answer.isGranted()) {
            System.out.println("Igényelt összeg: " + customer.getAmount() + " Hitel felveteő-e: " + answer.isGranted() + "Indok: Túl magas összeget akar felvenni ");

        } else {
            System.out.println("Igényelt összeg: " + customer.getAmount());
            System.out.println("Hitel felvehető-e: " + answer.isGranted());
            System.out.println("Fedezet szükséges-e: " + answer.needsCoverage());
            System.out.println("Fedezet összege: " + answer.getCoverageAmount());
            System.out.println("Kezes szükséges-e: " + answer.isNeedsSuccessor());
            System.out.println("Havi törlesztő részlet: " + answer.getMonthlyFee());
        }
    }
}
