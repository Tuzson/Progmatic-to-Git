package edu.progmatic.transfermoney;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Bank {

    private Map<String, Account> accounts;

    List<Transfer> transfers = new ArrayList<>();

    public Bank(Map<String, Account> accounts) {
        this.accounts = accounts;
    }

    private Object lock = new Object();

    //Lehet az egész metódust szinkronizálni (synchronise)
    public  boolean tranferMoney(String from, String to, int sum){
        Account fromAcc = accounts.get(from);
        Account toAcc = accounts.get(to);
        if(fromAcc != null && toAcc != null){
            synchronized (accounts) {
                int fromMoney = fromAcc.getMoney();
                if (fromMoney >= sum) {
                    transfers.add(new Transfer(from, to, sum));
                    toAcc.setMoney(toAcc.getMoney() + sum);
                    fromAcc.setMoney(fromMoney - sum);
                    return true;
                }
            }
        }
        return false;
    }
    public void printTransactionHistory(){
        for (Transfer transfer : transfers) {
            System.out.println(transfer);
        }
    }

    public void printAccounts(){
        for (Account acc : accounts.values()) {
            System.out.println(acc);
        }
    }

}
