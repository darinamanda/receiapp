package id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.R
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.adapter.RecipeAdapter
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.database.entity.RecipeMenu
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.viewmodel.RecipeViewModel
import kotlinx.android.synthetic.main.fragment_recycler_list.*

class MenuFragment : Fragment() {

    companion object {
        fun newInstance() = MenuFragment()
    }

    private lateinit var recipeViewModel: RecipeViewModel
    private val recipeAdapter = RecipeAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_recycler_list, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recipeViewModel = ViewModelProviders.of(this).get(RecipeViewModel::class.java)
        list_recycler_view.apply {
            layoutManager = LinearLayoutManager(activity)
            (layoutManager as LinearLayoutManager).orientation = LinearLayoutManager.HORIZONTAL
            adapter = recipeAdapter
        }

        observeViewModel()
    }

    fun observeViewModel() {
        recipeViewModel.getAllRecipes()
            .observe(this, Observer<List<RecipeMenu>> { t -> recipeAdapter.setRecipes(t!!) })
    }

}