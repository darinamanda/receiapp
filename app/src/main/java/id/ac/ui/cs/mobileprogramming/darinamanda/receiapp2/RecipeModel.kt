package id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2

import java.io.Serializable

data class RecipeModel(val imageResId: Int,
                       val name: String,
                       val rating: String,
                       val total_cook_time: String,
                       val prep_time: String,
                       val cook_time: String,
                       val difficulty: String,
                       val servings: String) : Serializable
