package com.thoughtworks.tddintro.accountbalance;

/**
 * Created by samanthastilson on 09/02/2016.
 */
public class Account {
    int amount;

    public Account(int amount) {
        this.amount = amount;
    }

    public Integer deposit(int depositAmt) {
        this.amount += depositAmt;
        return this.amount;
    }

    public Integer withdraw(int withdrawAmt) {
        if(withdrawAmt <= this.amount) {
            this.amount -= withdrawAmt;
        }
        return this.amount;
    }
}
