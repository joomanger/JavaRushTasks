package com.javarush.task.task14.task1417;

/**
 * Created by Alex on 30.07.17.
 */
public class USD extends Money {
    public USD(double amount) {
        super(amount);
    }

    @Override
    public String getCurrencyName() {
        return "USD";
    }
}
