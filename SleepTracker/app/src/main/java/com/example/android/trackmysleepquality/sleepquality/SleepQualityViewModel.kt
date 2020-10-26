package com.example.android.trackmysleepquality.sleepquality

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.trackmysleepquality.database.SleepDatabaseDao
import com.example.android.trackmysleepquality.sleeptracker.SleepTrackerFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class SleepQualityViewModel(
        private val sleepNightKey: Long,
        private val database: SleepDatabaseDao
) : ViewModel() {


    /**
     * Variable that tells the fragment whether it should navigate to [SleepTrackerFragment].
     *
     * This is `private` because we don't want to expose the ability to set [MutableLiveData] to
     * the [Fragment]
     */
    private val _navigateToSleepTracker = MutableLiveData<Boolean>()

    val navigateToSleepTracker: LiveData<Boolean>
        get() = _navigateToSleepTracker

    /**
     * Call this immediately after navigating to [SleepTrackerFragment]
     */
    fun doneNavigation() {
        _navigateToSleepTracker.value = false
    }

    /**
     * Sets the sleep quality and updates the database.
     *
     * Then navigates back to the SleepTrackerFragment.
     */
    fun onSleepQuality(quality: Int) {
        viewModelScope.launch {
            // no need for withContext if method in Dao marked suspend
//            withContext(Dispatchers.IO) {
                val tonight = database.get(sleepNightKey) ?: return@launch
                tonight.sleepQuality = quality
                database.update(tonight)
//            }
            // Setting this state variable to true will alert the observer and trigger navigation.
            _navigateToSleepTracker.value = true
        }
    }


}