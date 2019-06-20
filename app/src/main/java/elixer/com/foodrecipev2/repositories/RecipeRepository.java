package elixer.com.foodrecipev2.repositories;

import android.arch.lifecycle.LiveData;

import java.util.List;

import elixer.com.foodrecipev2.models.Recipe;
import elixer.com.foodrecipev2.requests.RecipeApiClient;

public class RecipeRepository {

    private static RecipeRepository instance;
    private RecipeApiClient mRecipeApiClient;

    public static RecipeRepository getInstance(){
        if(instance == null){
            instance = new RecipeRepository();
        }
        return instance;
    }

    private RecipeRepository() {
        mRecipeApiClient = RecipeApiClient.getInstance();
    }

    public LiveData<List<Recipe>> getRecipes(){
        return mRecipeApiClient.getRecipes();
    }

    public void searchRecipesApi(String query, int pageNumber){
        if(pageNumber == 0){
            pageNumber = 1;
        }
        mRecipeApiClient.searchRecipesApi(query, pageNumber);
    }
    public void cancelRequest(){
        mRecipeApiClient.cancelRequest();

    }}










