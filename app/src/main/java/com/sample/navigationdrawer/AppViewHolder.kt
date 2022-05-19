package com.sample.navigationdrawer

import android.view.View
import androidx.viewbinding.ViewBinding
import androidx.recyclerview.widget.RecyclerView

class AppViewHolder<T : ViewBinding>(
    val itemBinding: T,
    private val rowSelectedListener: OnRowSelectedListener? = null,
) :
    RecyclerView.ViewHolder(itemBinding.root), View.OnClickListener {

    interface OnRowSelectedListener {
        fun onRowSelected(position: Int)
    }

    init {
        rowSelectedListener?.let {
            itemBinding.root.setOnClickListener(this)
        }
    }

    override fun onClick(v: View) {
        rowSelectedListener?.onRowSelected(adapterPosition)
    }
}