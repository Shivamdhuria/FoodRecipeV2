package elixer.com.foodrecipev2.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import elixer.com.foodrecipev2.models.Recipe;
import elixer.com.foodrecipev2.repositories.RecipeRepository;


public class RecipeListViewModel extends ViewModel {

    private RecipeRepository mRecipeRepository;

    public RecipeListViewModel() {
        mRecipeRepository = RecipeRepository.getInstance();
    }

    public LiveData<List<String>> getmRecipeRepository() {
        return mRecipeRepository.getmRecipes();
    }
}



