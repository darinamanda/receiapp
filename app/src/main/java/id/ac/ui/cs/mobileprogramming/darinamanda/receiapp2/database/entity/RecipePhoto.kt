package id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photo_table")
data class RecipePhoto(

    var imageResId: String

) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}