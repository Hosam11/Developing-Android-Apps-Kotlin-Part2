package com.example.android.trackmysleepquality.sleeptracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.R
import com.example.android.trackmysleepquality.database.SleepNight
import com.example.android.trackmysleepquality.databinding.ListItemSleepNightGridBinding
import com.example.android.trackmysleepquality.sleeptracker.SleepNightAdapter.SleepNightDiffCallback

/**
 * [SleepNight] type of the list that it's holding
 * The ListAdapter will use [SleepNightDiffCallback] to figure out what changed random
 * list gets updated.
 * No need for define var for data ListAdapter will take care of keeping track of the list for us.
 * and also getItem() for calc size of list
 */
class SleepNightAdapter(private val clickListener: SleepNightListener) : ListAdapter<SleepNight, SleepNightAdapter.SleepViewHolder>
(SleepNightDiffCallback()) {


    override fun onBindViewHolder(holder: SleepViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SleepViewHolder {
        return SleepViewHolder.from(parent)
    }


    class SleepViewHolder private constructor(val binding: ListItemSleepNightGridBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: SleepNight, clickListener: SleepNightListener) {
            // tell binding object about new sleepNight
            binding.sleep = item

            binding.clickListener = clickListener
            /*
            This call is an optimization that asks data binding to execute any pending bindings right away.
            It's always a good idea to call executePendingBindings() when you use binding adapters in a RecyclerView,
            because it can slightly speed up sizing the views
            */
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): SleepViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemSleepNightGridBinding.inflate(layoutInflater, parent, false)

                return SleepViewHolder(binding)
            }
        }

    }


    class SleepNightDiffCallback : DiffUtil.ItemCallback<SleepNight>() {
        override fun areItemsTheSame(oldItem: SleepNight, newItem: SleepNight): Boolean {
            return oldItem.nightId == newItem.nightId
        }

        override fun areContentsTheSame(oldItem: SleepNight, newItem: SleepNight): Boolean {
            return oldItem == newItem
        }

    }

    class SleepNightListener(val clickListener: (nightId: Long) -> Unit) {
        fun onClick(night: SleepNight) = clickListener(night.nightId)
    }


    

}