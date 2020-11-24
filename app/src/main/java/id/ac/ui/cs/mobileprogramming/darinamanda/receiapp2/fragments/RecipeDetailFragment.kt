package id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.R
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.activities.CookActivity
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.viewmodel.RecipeViewModel
import kotlinx.android.synthetic.main.fragment_recipedetail.*

class RecipeDetailFragment : Fragment() {

    companion object {
        fun newInstance() = RecipeDetailFragment()
    }

    private lateinit var viewModel: RecipeViewModel
    private var imageRes = 0
    private var videoId = ""
    private var recipeId = 0
    private var ingredientList = ""
    private var instructionList = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_recipedetail, container, false)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        arguments?.let {
            recipeId = RecipeDetailFragmentArgs.fromBundle(it).id
        }


        viewModel = ViewModelProviders.of(this).get(RecipeViewModel::class.java)
        observeViewModel()

        button_cooknow.setOnClickListener{ view ->
            Log.d("btnSetup", "Selected")
            val intent = Intent(context, CookActivity::class.java)

            val name = card_view_image_title.text.toString()
            val rating = card_view_rating.text.toString()
            val totalTime = card_view_preptime.text.toString()
            val difficulty = card_view_difficulty.text.toString()
            val servings = card_view_servings.text.toString()
            val prepTime = card_view_prep_time.text.toString()
            val cookTime = card_view_cook_time.text

            intent.putExtra("Image", "$imageRes")
            intent.putExtra("Name", name)
            intent.putExtra("Rating", rating)
            intent.putExtra("TotalTime", totalTime)
            intent.putExtra("Difficulty", difficulty)
            intent.putExtra("Servings", servings)
            intent.putExtra("PrepTime", prepTime)
            intent.putExtra("CookTime", cookTime)
            intent.putExtra("VideoID", videoId)
            intent.putExtra("Ingredients", ingredientList)
            intent.putExtra("Instructions", instructionList)
            intent.putExtra("RecipeId", "$recipeId")
            startActivity(intent)
        }
    }

    fun observeViewModel() {

        viewModel.detailRecipe(recipeId+1).observe(this, Observer { recipe ->
            recipe?.let {
                card_view_image.setImageResource(recipe.imageResId)
                card_view_image_title.text = recipe.name
                card_view_rating.text = recipe.rating
                card_view_preptime.text = recipe.total_cook_time
                card_view_difficulty.text = recipe.difficulty
                card_view_servings.text = recipe.servings
                card_view_prep_time.text = recipe.prep_time
                card_view_cook_time.text = recipe.cook_time

                imageRes = recipe.imageResId
                videoId = recipe.videoId
                ingredientList = recipe.ingredientList
                instructionList = recipe.instructionList
            }
        })

    }

}