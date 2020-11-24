package id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.database.data

import android.os.AsyncTask
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.R
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.database.NutritionFactsDatabase
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.database.entity.NutritionFacts

class FactsDbAsyncTask(db: NutritionFactsDatabase?) : AsyncTask<Unit, Unit, Unit>() {
    private val factsDao = db?.factsDao()

    override fun doInBackground(vararg p0: Unit?) {
        factsDao?.insert(
            NutritionFacts(
                imageResId = R.drawable.ic_mango,
                factTitle = "Fun Fact About Mango",
                factDescription = "The Mango is an ancient fruit that can be dated as old as 4000 years."
            )
        )
        factsDao?.insert(
            NutritionFacts(
                imageResId = R.drawable.ic_cucumber,
                factTitle = "Fun Fact About Cucumber",
                factDescription = "Cucumbers contain Vitamins B1, B2, B3, B5 and B6, folic acid, Vitamin C, calcium, iron, magnesium, phosphorus, potassium and zinc. Who needs a multivitamin?"
            )
        )
        factsDao?.insert(
            NutritionFacts(
                imageResId = R.drawable.ic_noodle,
                factTitle = "Fun Fact About Noodles",
                factDescription = "Noodles are an excellent source of energy and are high in vitamins and minerals like iron, thiamin, niacin and riboflavin as well as containing low sodium content and low-fat content."
            )
        )
        factsDao?.insert(
            NutritionFacts(
                imageResId = R.drawable.ic_chocolate,
                factTitle = "Fun Fact About Chocolate",
                factDescription = "Research to date supports that chocolate can be enjoyed as part of a balanced, heart-healthy diet and lifestyle."
            )
        )
        factsDao?.insert(
            NutritionFacts(
                imageResId = R.drawable.ic_guava,
                factTitle = "Fun Fact About Guava",
                factDescription = "A ripe guava has a strong, sweet smell. The flesh of the fruit is white, pink, yellow, or red and contains small, edible seeds. It is a rich source of vitamin C. In fact, it has even more vitamin C than an orange!"
            )
        )
        factsDao?.insert(
            NutritionFacts(
                imageResId = R.drawable.ic_ice_cream,
                factTitle = "Fun Fact About Ice Cream",
                factDescription = "It takes 12 pounds of milk to produce just 1 gallon of ice cream"
            )
        )
        factsDao?.insert(
            NutritionFacts(
                imageResId = R.drawable.ic_spinach,
                factTitle = "Fun Fact About Spinach",
                factDescription = "Spinach is a cool season crop and belongs to the goose foot family along with Swiss chard and beets. It is low in calories, and is a good source of vitamin C, vitamin A, and minerals, especially iron."
            )
        )
    }
}