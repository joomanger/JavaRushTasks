package com.javarush.task.task15.task1530;

/**
 * Created by Alex on 19.08.17.
 */
public abstract class DrinkMaker {
    public abstract void getRightCup();

    public abstract void putIngredient();

    public abstract void pour();

    public void makeDrink() {
        getRightCup();
        putIngredient();
        pour();
    }
}
