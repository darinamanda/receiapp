package id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.repository

import android.app.Application
import androidx.lifecycle.LiveData
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.database.RecipePhotoDatabase
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.database.dao.RecipePhotoDao
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.database.entity.RecipePhoto
import android.os.AsyncTask

class RecipePhotoRepository internal constructor(application: Application) {

    private var photoDao: RecipePhotoDao
    private var allPhotos: LiveData<List<RecipePhoto>>

    init {
        val database: RecipePhotoDatabase = RecipePhotoDatabase.getDatabase(
            application.applicationContext
        )!!
        photoDao = database.photoDao()
        allPhotos = photoDao.getAllPhotos()
    }

    fun insert(photo: RecipePhoto) {
        insertAsyncTask(photoDao).execute(photo)
    }

    fun getAllPhotos(): LiveData<List<RecipePhoto>> {
        return allPhotos
    }

    private class insertAsyncTask internal constructor(private val mAsyncTaskDao: RecipePhotoDao) :
        AsyncTask<RecipePhoto, Void, Void>() {

        override fun doInBackground(vararg params: RecipePhoto): Void? {
            mAsyncTaskDao.insert(params[0])
            return null
        }
    }
}