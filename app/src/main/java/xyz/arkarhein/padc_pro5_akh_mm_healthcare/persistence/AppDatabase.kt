package xyz.arkarhein.padc_pro5_akh_mm_healthcare.persistence

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import xyz.arkarhein.padc_pro5_akh_mm_healthcare.data.vos.HealthcareVO
import xyz.arkarhein.padc_pro5_akh_mm_healthcare.persistence.daos.HealthcareDao

@Database(entities = [(HealthcareVO::class)], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun healthcareDao(): HealthcareDao

    companion object {
        private val DB_NAME = "Healthcare.DB"
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME)
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
            }
            val i = INSTANCE
            return i!!
        }
    }
}