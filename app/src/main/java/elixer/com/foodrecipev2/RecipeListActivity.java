package elixer.com.foodrecipev2;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


import java.util.List;

import elixer.com.foodrecipev2.adapters.OnRecipeListener;
import elixer.com.foodrecipev2.adapters.RecipeRecyclerAdapter;
import elixer.com.foodrecipev2.models.Recipe;
import elixer.com.foodrecipev2.util.Testing;
import elixer.com.foodrecipev2.viewmodels.RecipeListViewModel;

public class RecipeListActivity extends BaseActivity implements OnRecipeListener {

    private static final String TAG = "RecipeListActivity";

    private RecipeListViewModel mRecipeListViewModel;
    private RecyclerView mRecyclerView;
    private RecipeRecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);
        mRecyclerView = findViewById(R.id.recipe_list);

        mRecipeListViewModel = ViewModelProviders.of(this).get(RecipeListViewModel.class);

        initRecyclerView();
        subscribeObservers();
        testRetrofitRequest();
    }

    private void subscribeObservers(){

        mRecipeListViewModel.getRecipes().observe(this, new Observer<List<Recipe>>() {
            @Override
            public void onChanged(@Nullable List<Recipe> recipes) {
                if(recipes != null){
                    Testing.printRecipes("network test", recipes);
                }
                mAdapter.setRecipes(recipes);
            }
        });
    }

    private void testRetrofitRequest(){
        mRecipeListViewModel.searchRecipesApi("chicken", 1);
    }

    private void initRecyclerView(){
        mAdapter = new RecipeRecyclerAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onRecipeClick(int position) {
        Log.d(TAG, "onRecipeClick: clicked. " + position);
    }

    @Override
    public void onCategoryClick(String category) {

    }
}

