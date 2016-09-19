package BeanGrinder.Week2;

import BeanCollector.Week1.Account;

/**
 * Created by HanWei on 19/9/2016.
 */
public class CheckingAccount extends Account {
    // Week 2 Homework Question 3
    // Actually Ground2_3

    public CheckingAccount(int id, double balance){
        super(id, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (getBalance() - amount < -5000.0){
            System.out.println("over limit");
        }
        else{
            super.withdraw(amount);
        }
    }

    public static void main(String[] args) {
        CheckingAccount myCheckAcc = new CheckingAccount(1024, 8000.0);
        myCheckAcc.deposit(2000);
        myCheckAcc.withdraw(15000);
        System.out.println(myCheckAcc.getBalance());
        myCheckAcc.withdraw(200);
        System.out.println(myCheckAcc.getBalance());
        myCheckAcc.deposit(7000);
        myCheckAcc.withdraw(200);
        System.out.println(myCheckAcc.getBalance());
    }
}
