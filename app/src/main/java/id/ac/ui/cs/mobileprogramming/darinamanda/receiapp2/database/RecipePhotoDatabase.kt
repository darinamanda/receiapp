package id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.database.dao.RecipePhotoDao
import id.ac.ui.cs.mobileprogramming.darinamanda.receiapp2.database.entity.RecipePhoto

@Database(entities = [RecipePhoto::class], version = 1)
abstract class RecipePhotoDatabase : RoomDatabase() {

    abstract fun photoDao(): RecipePhotoDao

    companion object {

        @Volatile
        private var INSTANCE: RecipePhotoDatabase? = null

        internal fun getDatabase(context: Context): RecipePhotoDatabase? {
            if (INSTANCE == null) {
                synchronized(RecipePhotoDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            RecipePhotoDatabase::class.java, "photo_database"
                        )
                            .build()
                    }
                }
            }
            return INSTANCE
        }
    }
}