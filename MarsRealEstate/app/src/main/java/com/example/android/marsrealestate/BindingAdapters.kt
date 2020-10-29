package com.example.android.marsrealestate

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.android.marsrealestate.network.MarsProperty
import com.example.android.marsrealestate.overview.MarsApiStatus
import com.example.android.marsrealestate.overview.PhotoGridAdapter

/**
 * This binding adapter displays the [MarsApiStatus] of the network request in an image view. When
 * the request is loading, it displays a loading_animation. If the request has an error, it
 * displays a broken image to reflect the connection error. When the request is finished, it
 * hides the image view.
 */
@BindingAdapter("marsApiStatus")
fun ImageView.bindingStatus(status: MarsApiStatus?) {
    when (status) {
        MarsApiStatus.DONE -> {
            visibility = View.GONE
        }
        MarsApiStatus.LOADING -> {
            visibility = View.VISIBLE
            setImageResource(R.drawable.loading_animation)
        }
        MarsApiStatus.ERROR -> {
            setImageResource(R.drawable.ic_connection_error)
            visibility = View.GONE
        }
    }
}

/**
 * data: must declared  as null receiver
 * Use a binding adapter to initialize our photo grid adapter with list data.
 * Using a binding adapter to set the RecyclerView data will cause data binding to
 * automatically observe the LiveData for the list of Mars properties on our behalf.
 * Therefore, this adapter will be called automatically when the Mars property list changes
 */
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<MarsProperty>?) {
    val adapter = recyclerView.adapter as PhotoGridAdapter
    adapter.submitList(data)

}

/**
 * Uses the Glide library to load an image by URL into an [ImageView]
 */
@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
                .load(imgUri)
                .apply(RequestOptions()
                        .placeholder(R.drawable.loading_animation)
                        .error(R.drawable.ic_broken_image))
                .into(imgView)
    }
}