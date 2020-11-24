package id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.database.data
import android.os.AsyncTask
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.R
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.database.RecipeDatabase
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.database.entity.RecipeMenu

class DbAsyncTask(db: RecipeDatabase?) : AsyncTask<Unit, Unit, Unit>() {
    private val recipeDao = db?.recipeDao()

    override fun doInBackground(vararg p0: Unit?) {
        recipeDao?.insert(
            RecipeMenu(
                id = 0,
                imageResId = R.drawable.aglio,
                name = "Spaghetti Aglio Olio",
                rating = "4.6",
                total_cook_time = "32 mins",
                prep_time = "10 min",
                cook_time = "22 min",
                difficulty = "easy",
                servings = "4 pp",
                videoId = "mmE63IPiNp4",
                ingredientList = "1 pound uncooked spaghetti\n" +
                        "6 cloves garlic, thinly sliced\n" +
                        "1/2 cup olive oil\n" +
                        "1/4 cup teaspoon red pepper flakes\n" +
                        "salt and freshly ground black pepper\n" +
                        "1/4 cup chopped fresh Italian parsley\n" +
                        "1 cup finely grated Parmigiano-Reggiano cheese",
                instructionList = "Bring a large pot of lightly salted water to a boil. Cook spaghetti in the boiling water, stirring occasionally until cooked through but firm to the bite, about 12 minutes. Drain and transfer to a pasta bowl.\n\n" +
                        "Combine garlic and olive oil in a cold skillet. Cook over medium heat to slowly toast garlic, about 10 minutes. Reduce heat to medium-low when olive oil begins to bubble. Cook and stir until garlic is golden brown, about another 5 minutes. Remove from heat.\n\n" +
                        "Stir red pepper flakes, black pepper, and salt into the pasta. Pour in olive oil and garlic, and sprinkle on Italian parsley and half of the Parmigiano-Reggiano cheese; stir until combined.\n\n" +
                        "Serve pasta topped with the remaining Parmigiano-Reggiano cheese."
            )
        )
        recipeDao?.insert(
            RecipeMenu(
                id = 0,
                imageResId = R.drawable.all_recipe2,
                name = "California Grilled Veggie Sandwich",
                rating = "4.8",
                total_cook_time = "50 min",
                prep_time = "30 min",
                cook_time = "20 min",
                difficulty = "easy",
                servings = "4 pp",
                videoId = "m0LbgNNDNok" ,
                ingredientList = "1/4 cup mayonnaise\n" +
                        "3 gloves garlic, minced\n" +
                        "1 tablespoon lemon juice\n" +
                        "1/8 cup olive oil\n" +
                        "1 cup sliced red bell peppers\n" +
                        "1 small zucchini, sliced\n" +
                        "1 red onion, sliced\n" +
                        "1 small yellow squash, sliced\n" +
                        "2 (4-x6-inch) focaccia bread pieces, split horizontally\n" +
                        "1/2 cup crumbled feta cheese\n",
                instructionList = "In a bowl, mix the mayonnaise, minced garlic, and lemon juice. Set aside in the refrigerator.\n\n" +
                        "Preheat the grill for high heat.\n\n" +
                        "Brush vegetables with olive oil on each side. Brush grate with oil. Place bell peppers and zucchini closest to the middle of the grill, and set onion and squash pieces around them. Cook for about 3 minutes, turn, and cook for another 3 minutes. The peppers may take a bit longer. Remove from grill, and set aside.\n\n" +
                        "Spread some of the mayonnaise mixture on the cut sides of the bread, and sprinkle each one with feta cheese. Place on the grill cheese side up, and cover with lid for 2 to 3 minutes. This will warm the bread, and slightly melt the cheese. Watch carefully so the bottoms don't burn. Remove from grill, and layer with the vegetables. Enjoy as open faced grilled sandwiches."
            )
        )
        recipeDao?.insert(
            RecipeMenu(
                id = 0,
                imageResId = R.drawable.chicken_wing,
                name = "Grill Master Chicken Wing",
                rating = "4.4",
                total_cook_time = "30 mins",
                prep_time = "10 mins",
                cook_time = "20 mins",
                difficulty = "medium",
                servings = "10 pp",
                videoId = "gK_rpc3pO-4",
                ingredientList = "1/2 cup soy sauce\n" +
                        "1/2 cup Italian-style salad dressing\n" +
                        "3 pounds chicken wings, cut apart at joints, wing tips discarded\n" +
                        "1/4 cup butter\n" +
                        "1 teaspoon soy sauce\n",
                instructionList = "Combine 1/2 cup soy sauce, Italian dressing, and chicken wings in a large, zip-top bag. Close bag and refrigerate 4 hours to overnight.\n\n" +
                        "Preheat an outdoor grill for medium heat. In a small saucepan, melt the butter. Stir in the 1 teaspoon soy sauce and the hot pepper sauce. Turn off heat and reserve.\n\n" +
                        "Remove the chicken wings from the marinade and pat dry. Cook the wings on the preheated grill, turning occasionally, until the chicken is well browned and no longer pink, 25 to 30 minutes.\n\n" +
                        "Place grilled wings in a large bowl. Pour butter sauce over wings; toss to mix well."
            )
        )
        recipeDao?.insert(
            RecipeMenu(
                id = 0,
                imageResId = R.drawable.fish_chips,
                name = "Crispy Beer Batter Fish and Chips",
                rating = "4.5",
                total_cook_time = "25 min",
                prep_time = "10 min",
                cook_time = "15 min",
                difficulty = "easy",
                servings = "4 pp",
                videoId = "qHl1MoXPXz0",
                ingredientList = "1 cup self-rising flour\n" +
                        "2 tablespoons rice flour\n" +
                        "1/4 teaspoon baking powder\n" +
                        "4 (6 ounce) cod fillets, fully thawed if frozen\n" +
                        "2 tablespoons rice flour, or as needed\n" +
                        "salt to taste\n" +
                        "1 cup lager-style beer, or more as needed\n" +
                        "vegetable oil for frying",
                instructionList = "Whisk self-rising flour, rice flour, and baking powder together in a bowl. Freeze until ready to use.\n\n" +
                        "Pat fish as dry as possible. Cut pieces lengthwise to get eight 1-inch thick strips. Place rice flour on a plate and season with salt. Dust fish lightly with the mixture and shake off excess. Cover a plate with crinkled foil to make a quick drying rack; place fish on top.\n\n" +
                        "Pour beer into the flour mixture and whisk, adding more as needed, until batter is the consistency of thick pancake batter. Dip fish pieces into the batter to coat; lift out and let excess drip off.\n\n" +
                        "Fry fish in batches until golden brown, dunking occasionally if needed, 3 to 4 minutes. Drain on paper towels. Serve immediately."
            )
        )
        recipeDao?.insert(
            RecipeMenu(
                id = 0,
                imageResId = R.drawable.broccoli_salad,
                name = "Broccoli Salad",
                rating = "4.4",
                total_cook_time = "30 min",
                prep_time = "15 min",
                cook_time = "5 min",
                difficulty = "easy",
                servings = "6 pp",
                videoId = "UlfAiRtmNwA",
                ingredientList = "10 slices bacon\n" +
                        "1 head fresh broccoli, cut into bite size pieces\n" +
                        "1/4 cup red onion, chopped\n" +
                        "1/2 cup raisins\n" +
                        "3 tablespoons white wine vinegar\n" +
                        "2 tablespoons white sugar\n" +
                        "1 cup mayonnaise\n" +
                        "1 cup sunflower seeds",
                instructionList = "Place bacon in a large, deep skillet. Cook over medium high heat until evenly brown. Drain, crumble and set aside.\n\n" +
                        "In a medium bowl, combine the broccoli, onion and raisins. In a small bowl, whisk together the vinegar, sugar and mayonnaise. Pour over broccoli mixture, and toss until well mixed. Refrigerate for at least two hours.\n\n" +
                        "Before serving, toss salad with crumbled bacon and sunflower seeds."
            )
        )
        recipeDao?.insert(
            RecipeMenu(
                id = 0,
                imageResId = R.drawable.cookies,
                name = "Chocolate Chip Cookie",
                rating = "4.7",
                total_cook_time = "25 min",
                prep_time = "10 min",
                cook_time = "15 min",
                difficulty = "easy",
                servings = "18 pp",
                videoId = "K92T3uc75bM",
                ingredientList = "2 cups all-purpose flour\n" +
                        "1/2 teaspoon baking soda\n" +
                        "1/2 teaspoon salt\n" +
                        "3/4 cup unsalted butter, melted\n" +
                        "1 cup packed brown sugar\n" +
                        "1/2 cup white sugar\n" +
                        "1 tablespoon vanilla extract\n" +
                        "1 egg\n" +
                        "1 egg yolk\n" +
                        "2 cups semisweet chocolate chips",
                instructionList = "Preheat the oven to 325 degrees F (165 degrees C). Grease cookie sheets or line with parchment paper.\n\n" +
                        "Sift together the flour, baking soda and salt; set aside.\n\n" +
                        "In a medium bowl, cream together the melted butter, brown sugar and white sugar until well blended. Beat in the vanilla, egg, and egg yolk until light and creamy. Mix in the sifted ingredients until just blended. Stir in the chocolate chips by hand using a wooden spoon. Drop cookie dough 1/4 cup at a time onto the prepared cookie sheets. Cookies should be about 3 inches apart.\n\n" +
                        "Bake for 15 to 17 minutes in the preheated oven, or until the edges are lightly toasted. Cool on baking sheets for a few minutes before transferring to wire racks to cool completely."
            )
        )
    }
}