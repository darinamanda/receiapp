package id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.R
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.database.entity.RecipePhoto
import kotlinx.android.synthetic.main.item_grid_recipe.view.*

class PhotoAdapter : RecyclerView.Adapter<PhotoAdapter.PhotoHolder>() {
    private var photos: List<RecipePhoto> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_grid_recipe, parent, false)
        return PhotoHolder(itemView)
    }

    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
        holder.view.recipe_image.setImageURI(Uri.parse((photos.get(position)).imageResId))
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    fun setPhotos(photos: List<RecipePhoto>) {
        this.photos = photos
        notifyDataSetChanged()
    }

    class PhotoHolder(val view: View) : RecyclerView.ViewHolder(view)

}