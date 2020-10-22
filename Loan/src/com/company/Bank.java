package com.company;

public class Bank {
    public static void main(String[] args) {
        LoanRequest customer = new LoanRequest(false, 2000000, 12);
        LoanRequest customerVip = new LoanRequest(true, 34000000, 43);
        LoanResponse bankresponse = new LoanResponse();
        LoanCalculator otp = new LoanCalculator(bankresponse);

        response(customerVip,otp,bankresponse);

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

