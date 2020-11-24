package id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipe_table")
data class RecipeMenu(

    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var imageResId: Int,
    var name: String,
    var rating: String,
    var total_cook_time: String,
    var prep_time: String,
    var cook_time: String,
    var difficulty: String,
    var servings: String,
    var videoId: String,
    var ingredientList: String,
    var instructionList: String
)