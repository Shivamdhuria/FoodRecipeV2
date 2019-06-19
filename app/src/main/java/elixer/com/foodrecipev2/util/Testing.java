package elixer.com.foodrecipev2.util;

import android.util.Log;

import java.util.List;


import elixer.com.foodrecipev2.models.Recipe;

public class Testing {

    public static void printRecipes(String tag, List<Recipe> list){
        for(Recipe recipe: list){
            Log.d(tag, "printRecipes: " + recipe.getRecipe_id() + ", " + recipe.getTitle());
        }
    }
}
