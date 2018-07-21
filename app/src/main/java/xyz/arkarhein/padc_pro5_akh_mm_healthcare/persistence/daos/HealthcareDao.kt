package xyz.arkarhein.padc_pro5_akh_mm_healthcare.persistence.daos

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import xyz.arkarhein.padc_pro5_akh_mm_healthcare.data.vos.HealthcareVO

@Dao
interface HealthcareDao {

    @get:Query(value = "SELECT * FROM Healthcare")
    val allHealthcare: List<HealthcareVO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertHealthcare(healthcareVO: List<HealthcareVO>): LongArray

    @Query("SELECT * FROM Healthcare")
    fun getAllHealthcareLiveData(): LiveData<List<HealthcareVO>>
}