package id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.database.entity.RecipeMenu
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.repository.RecipeRepository

class RecipeViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: RecipeRepository =
        RecipeRepository(application)
    private var allRecipes: LiveData<List<RecipeMenu>> = repository.getAllRecipes()
    private lateinit var detailRecipe: LiveData<RecipeMenu>

    fun insert(recipe: RecipeMenu) {
        repository.insert(recipe)
    }

    fun deleteAllRecipes() {
        repository.deleteAllRecipes()
    }

    fun detailRecipe(listId: Int): LiveData<RecipeMenu> {
        detailRecipe = repository.detailRecipe(listId)
        return detailRecipe
    }

    fun getAllRecipes(): LiveData<List<RecipeMenu>> {
        return allRecipes
    }
}