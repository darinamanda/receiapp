package id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.repository

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.database.NutritionFactsDatabase
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.database.dao.NutritionFactsDao
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.database.entity.NutritionFacts

class RandomFactsRepository internal constructor(application: Application) {

    private var factsDao: NutritionFactsDao

    private var allFacts: LiveData<List<NutritionFacts>>

    private lateinit var fact: LiveData<NutritionFacts>

    init {
        val database: NutritionFactsDatabase = NutritionFactsDatabase.getInstance(
            application.applicationContext
        )!!
        factsDao = database.factsDao()
        allFacts = factsDao.getAllFacts()
    }


    fun insert(fact: NutritionFacts) {
        val insertFactsAsyncTask = RandomFactsRepository.InsertFactsAsyncTask(factsDao).execute(fact)
    }

    fun getFact(listId: Int): LiveData<NutritionFacts> {
        fact = factsDao.getFact(listId)
        return fact
    }


    fun getAllFacts(): LiveData<List<NutritionFacts>> {
        return allFacts
    }

    private class InsertFactsAsyncTask(factsDao: NutritionFactsDao) : AsyncTask<NutritionFacts, Unit, Unit>() {
        val factsDao = factsDao

        override fun doInBackground(vararg p0: NutritionFacts?) {
            factsDao.insert(p0[0]!!)
        }
    }
}