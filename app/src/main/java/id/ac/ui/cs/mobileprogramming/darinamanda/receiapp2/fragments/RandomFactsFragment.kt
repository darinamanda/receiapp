package id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.viewmodel.RandomFactsViewModel
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.R
import kotlinx.android.synthetic.main.fragment_nutritionfact.*

class RandomFactsFragment : Fragment() {

    companion object {
        fun newInstance() = RandomFactsFragment()
    }

    private lateinit var viewModel: RandomFactsViewModel
    private var randomId = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_nutritionfact, container, false)

        viewModel = ViewModelProviders.of(this).get(RandomFactsViewModel::class.java)
        observeViewModel()

        return view
    }


    fun observeViewModel() {

        randomFactIndex()
        Log.d("FactId", "$randomId")

        viewModel.getFact(randomId).observe(this, Observer { fact ->
            fact?.let {
                fact_icon.setImageResource(fact.imageResId)
                fact_description.text = fact.factDescription
            }
        })

    }

    private fun randomFactIndex() {
        randomId = (0..6).random()

    }
}