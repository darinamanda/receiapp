package id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.database.entity.RecipePhoto
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.repository.RecipePhotoRepository

class RecipePhotoViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: RecipePhotoRepository = RecipePhotoRepository(application)
    private var allRecipePhoto: LiveData<List<RecipePhoto>> = repository.getAllPhotos()
    private lateinit var detailRecipePhoto: LiveData<RecipePhoto>

    fun insert(photo: RecipePhoto) {
        repository.insert(photo)
    }

    fun getAllPhotos(): LiveData<List<RecipePhoto>> {
        return allRecipePhoto
    }
}