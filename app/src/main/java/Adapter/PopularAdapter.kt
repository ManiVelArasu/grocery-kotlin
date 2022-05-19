package io.a70mm.utils.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.sample.navigationdrawer.AppViewHolder
import com.sample.navigationdrawer.databinding.PopularItemBinding


import io.a70mm.utils.Model.ImagaData
import io.a70mm.utils.Model.PopularData

class PopularAdapter (
    private val imagedata: List<PopularData>,
    private val ImageListener: OnImageSelected,
) : RecyclerView.Adapter<AppViewHolder<PopularItemBinding>>(),
    AppViewHolder.OnRowSelectedListener {

    interface OnImageSelected {
        fun onLatestVideoSelected(latestVideo: PopularData)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): AppViewHolder<PopularItemBinding> {
        val itemBinding = PopularItemBinding.inflate(LayoutInflater.from(parent.context))
        return AppViewHolder(itemBinding, this)
    }
    override fun onBindViewHolder(holder: AppViewHolder<PopularItemBinding>, position: Int) {
        val dailyVideo = imagedata[position]
        holder.itemBinding.text.text = dailyVideo.getTitle()
    }
    override fun getItemCount() = 2

    override fun onRowSelected(position: Int) {
        ImageListener.onLatestVideoSelected(imagedata[position])
    }
}


