package com.thoughtworks.tddintro.accountbalance;

/**
 * Created by samanthastilson on 09/02/2016.
 */
public class Account {
    int amount;

    public Account(int amount) {
        this.amount = amount;
    }

    public void deposit(int depositAmt) {
        this.amount += depositAmt;
    }

    public void withdraw(int withdrawAmt) {
        if(withdrawAmt <= this.amount) {
            this.amount -= withdrawAmt;
        }
    }

    public Integer checkBalance() {
        return this.amount;
    }
}
