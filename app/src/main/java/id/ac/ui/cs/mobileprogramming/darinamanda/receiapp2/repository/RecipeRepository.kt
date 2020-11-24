package id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.repository

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.database.RecipeDatabase
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.database.dao.RecipeDao
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.database.entity.RecipeMenu

class RecipeRepository(application: Application) {

    private var recipeDao: RecipeDao
    private var allRecipes: LiveData<List<RecipeMenu>>
    private lateinit var detailRecipe: LiveData<RecipeMenu>

    init {
        val database: RecipeDatabase = RecipeDatabase.getInstance(
            application.applicationContext
        )!!
        recipeDao = database.recipeDao()
        allRecipes = recipeDao.getAllRecipes()
    }

    fun insert(recipe: RecipeMenu) {
        val insertRecipeAsyncTask = InsertRecipeAsyncTask(recipeDao).execute(recipe)
    }

    fun deleteAllRecipes() {
        val deleteAllRecipesAsyncTask = DeleteAllRecipesAsyncTask(
            recipeDao
        ).execute()
    }

    fun detailRecipe(listId: Int): LiveData<RecipeMenu> {
        detailRecipe = recipeDao.detailRecipe(listId)
        return detailRecipe
    }

    fun getAllRecipes(): LiveData<List<RecipeMenu>> {
        return allRecipes
    }

    private class InsertRecipeAsyncTask(recipeDao: RecipeDao) : AsyncTask<RecipeMenu, Unit, Unit>() {
        val recipeDao = recipeDao
        override fun doInBackground(vararg p0: RecipeMenu?) {
            recipeDao.insert(p0[0]!!)
        }
    }

    private class DeleteAllRecipesAsyncTask(val recipeDao: RecipeDao) : AsyncTask<Unit, Unit, Unit>() {
        override fun doInBackground(vararg p0: Unit?) {
            recipeDao.deleteAllRecipes()
        }
    }

}