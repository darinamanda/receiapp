package id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.R
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.database.entity.RecipeMenu
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.fragments.MenuFragmentDirections
import kotlinx.android.synthetic.main.item_recipe.view.*

class RecipeAdapter : RecyclerView.Adapter<RecipeAdapter.RecipeHolder>() {
    private var recipes: List<RecipeMenu> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recipe, parent, false)
        return RecipeHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecipeHolder, position: Int) {
        holder.view.card_view_image.setImageResource(recipes.get(position).imageResId)
        holder.view.card_view_image_title.text = recipes.get(position).name
        holder.view.card_view_rating.text = recipes.get(position).rating
        holder.view.card_view_preptime.text = recipes.get(position).total_cook_time
        holder.view.card_view_difficulty.text = recipes.get(position).difficulty
        holder.view.setOnClickListener {
                Navigation.findNavController(it)
                    .navigate(MenuFragmentDirections.recipeDetailFragment().setId(position))
        }
    }

    override fun getItemCount(): Int {
        return recipes.size
    }

    fun setRecipes(recipes: List<RecipeMenu>) {
        this.recipes = recipes
        notifyDataSetChanged()
    }

    class RecipeHolder(val view: View) : RecyclerView.ViewHolder(view)
}