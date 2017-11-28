package com.javarush.task.task14.task1408;

/**
 * Created by Alex on 29.07.17.
 */
public class MoldovanHen extends Hen {
    @Override
    int getCountOfEggsPerMonth() {
        return 3;
    }

    @Override
    String getDescription() {
        return super.getDescription()+" Моя страна - "+Country.MOLDOVA+". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}
