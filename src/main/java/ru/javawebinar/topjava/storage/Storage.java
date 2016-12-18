package ru.javawebinar.topjava.storage;

import ru.javawebinar.topjava.model.UserMeal;

/**
 * Created by Сергей on 18.12.2016.
 */
public interface Storage {
    void add(UserMeal... userMeals);

    void delete(UserMeal userMeal);

    void update(UserMeal userMeal);

    UserMeal get(Object key);


}
