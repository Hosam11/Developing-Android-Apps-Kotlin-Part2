package com.example.android.trackmysleepquality.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface SleepDatabaseDao {

    @Insert
    fun insert(sleepNight: SleepNight)

    /**
     * When updating a row with a value already set in a column,
     * replaces the old value with the new one.
     *
     * @param sleepNight new value to write
     */
    @Update
    suspend fun update(sleepNight: SleepNight)
    /**
     * Selects and returns the row that matches the supplied start time, which is our key.
     *
     * @param key startTimeMilli to match
     */

    @Query("SELECT * FROM DAILY_SLEEP_QUALITY_TABLE WHERE nightId= :key")
    suspend fun get(key: Long): SleepNight?

    /**
     * Deletes all values from the table.
     *
     * This does not delete the table, only its contents.
     */
    @Query("DELETE FROM daily_sleep_quality_table")
    fun clear()

    /**
     * Selects and returns all rows in the table,
     *
     * sorted by start time in descending order.
     */
    @Query("SELECT * FROM daily_sleep_quality_table ORDER BY nightId DESC")
    fun getAllNights(): LiveData<List<SleepNight>>
    /**
     * Selects and returns the latest night.
     */

    @Query("SELECT * FROM daily_sleep_quality_table ORDER BY nightId DESC LIMIT 1")
    fun getTonight(): SleepNight?
}
