package com.example.lucie.recipes;

/**
 * Created by lucie on 11/17/15.
 */
public class Food {
    int id;
    String name, ingredients, method;

    public Food(int id, String name, String ingredients, String method){
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.method = method;
    }

    int getId(){
        return id;
    }
    String getName(){
        return name;
    }
    String getIngredients(){
        return ingredients;
    }
    String getMethod(){
        return method;
    }
}
