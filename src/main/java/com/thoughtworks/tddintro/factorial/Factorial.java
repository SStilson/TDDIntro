package com.thoughtworks.tddintro.factorial;

public class Factorial {
    public Integer compute(int i) {
        if(i < 0) {
            throw new IllegalArgumentException("i cannot be negative!");
        } else if(i <= 1) {
            return 1;
        } else {
            return i * compute(i-1);
        }
    }
}
