package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;

/**
 * Created by Сергей on 17.12.2016.
 */
public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 600),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 500)
        );
        List<UserMealWithExceed> userMealWithExceedList = getFilteredMealsWithExceed(
                mealList, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000
        );
        System.out.println(userMealWithExceedList);


    }

    public static List<UserMealWithExceed> getFilteredMealsWithExceed(List<UserMeal> userMeals, LocalTime startTime, LocalTime endTime, int calories) {
        Map<LocalDate, Integer> amountCaloriesPerDay = new HashMap<>();
        for (UserMeal um : userMeals) {
            LocalDate key = um.getDateTime().toLocalDate();
            int value = amountCaloriesPerDay.getOrDefault(key, 0);
            amountCaloriesPerDay.put(key, value + um.getCalories());
        }
        List<UserMealWithExceed> userMealWithExceedList = new ArrayList<>();
        for (UserMeal um : userMeals) {
            if (TimeUtil.isBetween(um.getDateTime().toLocalTime(), startTime, endTime)) {
                userMealWithExceedList.add(new UserMealWithExceed(
                        um.getDateTime(), um.getDescription(), um.getCalories(),
                        amountCaloriesPerDay.get(um.getDateTime().toLocalDate()) > calories
                ));
            }
        }

        return userMealWithExceedList;
    }

}
