package id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.database.entity.RecipePhoto

@Dao
interface RecipePhotoDao {

    @Insert
    fun insert(photo: RecipePhoto)

    @Query("DELETE FROM photo_table")
    fun deleteAllPhotos()

    @Query("SELECT * FROM photo_table ")
    fun getAllPhotos(): LiveData<List<RecipePhoto>>

}