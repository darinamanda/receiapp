package id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.database.entity.NutritionFacts

@Dao
interface NutritionFactsDao {

    @Insert
    fun insert(fact: NutritionFacts)

    @Query("DELETE FROM facts_table")
    fun deleteAllFacts()

    @Query("SELECT * FROM facts_table ")
    fun getAllFacts(): LiveData<List<NutritionFacts>>

    @Query("SELECT * FROM facts_table WHERE id=:listId")
    fun getFact(listId: Int): LiveData<NutritionFacts>
}