package id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.R
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.fragments.IngredientFragment
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.fragments.StepFragment


class PagerAdapter(fm: FragmentManager, context: Context, recipeId: Int) : FragmentPagerAdapter(fm) {

    private val recipeId = recipeId
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                IngredientFragment.newInstance(recipeId)
            } else -> {
                return StepFragment.newInstance(recipeId)
            }
        }
    }

    override fun getCount(): Int {
        return 2
    }

    private val tabTitles = arrayOf<String>(
        context.resources.getString(R.string.string_ingredients),
        context.resources.getString(R.string.string_instruction)
    )


    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> tabTitles[0]
            else -> {
                return tabTitles[1]
            }
        }
    }
}