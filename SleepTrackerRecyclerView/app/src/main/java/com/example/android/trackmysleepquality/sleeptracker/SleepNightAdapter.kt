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
import com.example.android.trackmysleepquality.sleeptracker.SleepNightAdapter.DataItem
import com.example.android.trackmysleepquality.sleeptracker.SleepNightAdapter.SleepNightDiffCallback
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * [SleepNight] type of the list that it's holding
 * The ListAdapter will use [SleepNightDiffCallback] to figure out what changed random
 * list gets updated.
 * No need for define var for data ListAdapter will take care of keeping track of the list for us.
 * and also getItem() for calc size of list
 */


class SleepNightAdapter(private val clickListener: SleepNightListener) :
        ListAdapter<DataItem, RecyclerView.ViewHolder>(SleepNightDiffCallback()) {

    //The RecyclerView will need to distinguish each item's view type,
    // so that it can correctly assign a view holder to it.
    private val ITEM_VIEW_TYPE_HEADER = 0
    private val ITEM_VIEW_TYPE_ITEM = 1

    private val adapterScope = CoroutineScope(Dispatchers.Default)


    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is DataItem.Header -> ITEM_VIEW_TYPE_HEADER
            is DataItem.SleepNightItem -> ITEM_VIEW_TYPE_ITEM
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is SleepViewHolder -> {
                val nightItem = getItem(position) as DataItem.SleepNightItem
                holder.bind(nightItem.sleepNight, clickListener)
            }

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_VIEW_TYPE_ITEM -> SleepViewHolder.from(parent)
            ITEM_VIEW_TYPE_HEADER -> TextViewHolder.from(parent)
            else -> throw ClassCastException("Unknown viewType $viewType")
        }
    }

    fun addHeaderAndSubmitList(list: List<SleepNight>?) {
        adapterScope.launch {
            val items = when (list) {
                null -> listOf(DataItem.Header)
                else -> listOf(DataItem.Header) + list.map { DataItem.SleepNightItem(it) }
            }
            withContext(Dispatchers.Main) {
                submitList(items)
            }
        }
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

    class SleepNightDiffCallback : DiffUtil.ItemCallback<DataItem>() {
        override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
            return oldItem == newItem
        }

    }

    class SleepNightListener(val clickListener: (nightId: Long) -> Unit) {
        fun onClick(night: SleepNight) = clickListener(night.nightId)
    }

    sealed class DataItem {
        data class SleepNightItem(val sleepNight: SleepNight) : DataItem() {
            override val id = sleepNight.nightId
        }

        object Header : DataItem() {
            override val id = Long.MIN_VALUE
        }

        abstract val id: Long
    }

    class TextViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        companion object {
            fun from(parent: ViewGroup): TextViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.header, parent, false)

                return TextViewHolder(view)
            }
        }
    }


}