package id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.R
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.viewmodel.RecipeViewModel
import kotlinx.android.synthetic.main.fragment_instructions.*

class StepFragment() : Fragment(){

    companion object {
        fun newInstance(index: Int): StepFragment {
            val f = StepFragment()

            // Supply index input as an argument.
            val args = Bundle()
            args.putInt("index", index)
            f.arguments = args

            return f
        }
    }

    private lateinit var viewModel: RecipeViewModel
    private var recipeId = 0

    fun getShownIndex(): Int {
        return arguments!!.getInt("index", 0)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Get recipeId
        recipeId = getShownIndex()
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_instructions, container, false)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(RecipeViewModel::class.java)
        observeViewModel()
    }

    fun observeViewModel() {

        viewModel.detailRecipe(recipeId+1).observe(this, Observer { recipe ->
            recipe?.let {
                textview_instructions.text = recipe.instructionList
            }
        })

    }


}