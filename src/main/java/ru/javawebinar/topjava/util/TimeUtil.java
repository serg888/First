package ru.javawebinar.topjava.util;

import java.time.LocalTime;

/**
 * Created by Сергей on 17.12.2016.
 */
public class TimeUtil {
    public static boolean isBetween(LocalTime it, LocalTime startTime, LocalTime endTime){
        return (it.compareTo(startTime)>=0)&&(it.compareTo(endTime)<=0);
    }
}
