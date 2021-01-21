package edu.progmatic.transfermoney;

public class Hacker extends Thread{
private Bank bank;
    public Hacker(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        bank.tranferMoney("Aladár","Dalára",100);
    }
}
