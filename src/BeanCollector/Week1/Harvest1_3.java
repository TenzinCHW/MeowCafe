package BeanCollector.Week1;

import java.util.Date;

/**
 * Created by HanWei on 15/9/2016.
 */
public class Harvest1_3 {
    // Week 1 Cohort Question 3

    private int id = 0;
    private double balance = 0;
    private double annualInterestRate = 0;
    private Date dateCreated;

    public Harvest1_3(){
        dateCreated = new Date();
    }

    public Harvest1_3(int id, double balance){
        this.id = id;
        this.balance = balance;
        dateCreated = new Date();
    }

    public int getID(){
        return id;
    }

    public void setID(int id){
        this.id = id;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(int balance){
        this.balance = balance;
    }

    public double getAnnualInterestRate(){
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate){
        this.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated(){
        return dateCreated;
    }

    public double getMonthlyInterestRate(){
        return annualInterestRate/12.0;
    }

    public double getMonthlyInterest(){
        return getMonthlyInterestRate()*balance/100;
    }

    public void withdraw(double amount){
        balance -= amount;
    }

    public void deposit(double amount){
        balance += amount;
    }

    public static void main (String[] args) {
        Harvest1_3 account = new Harvest1_3(1122, 20000);
        account.setAnnualInterestRate(4.5);
        account.withdraw(2500);
        account.deposit(3000);
        System.out.println("Balance is " + account.getBalance());
        System.out.println("Monthly interest is " +
                account.getMonthlyInterest());
    }
}
