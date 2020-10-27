package com.example.android.trackmysleepquality.sleeptracker

import android.widget.ImageView
import android.widget.TextView

import androidx.databinding.BindingAdapter
import com.example.android.trackmysleepquality.R
import com.example.android.trackmysleepquality.convertDurationToFormatted
import com.example.android.trackmysleepquality.convertNumericQualityToString
import com.example.android.trackmysleepquality.database.SleepNight


// Binding adapters are adapters that take your data and adapt it into
// something that data binding can use to bind a view, like text or an image

@BindingAdapter("sleepDurationFormatted")
fun TextView.setSleepDurationFormatted(sleepNight: SleepNight?) {
    sleepNight?.let {
        text = convertDurationToFormatted(sleepNight.startTimeMilli,
                sleepNight.endTimeMilli, context.resources)
    }

}

@BindingAdapter("sleepQualityString")
fun TextView.setSleepQualityString(sleepNight: SleepNight?) {
    sleepNight?.let {
        text = convertNumericQualityToString(sleepNight.sleepQuality, context.resources)
    }
}

@BindingAdapter("setImage")
fun ImageView.setImage(sleepNight: SleepNight?) {
    sleepNight?.let {
        setImageResource(when (sleepNight.sleepQuality) {
            0 -> R.drawable.ic_sleep_0
            1 -> R.drawable.ic_sleep_1
            2 -> R.drawable.ic_sleep_2
            3 -> R.drawable.ic_sleep_3
            4 -> R.drawable.ic_sleep_4
            5 -> R.drawable.ic_sleep_5
            else -> R.drawable.ic_sleep_active
        })
    }
}