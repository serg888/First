package ru.javawebinar.topjava.model;

import java.time.LocalDateTime;

/**
 * Created by Сергей on 17.12.2016.
 */
public class UserMealWithExceed {
    protected final LocalDateTime dateTime;
    protected final String description;
    protected final int calories;
    protected final boolean isExceed;

    public UserMealWithExceed(LocalDateTime dateTime, String description, int calories, boolean isExceed) {
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
        this.isExceed = isExceed;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public int getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return "UserMealWithExceed{" +
                "dateTime=" + dateTime +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                ", isExceed=" + isExceed +
                '}';
    }
}
