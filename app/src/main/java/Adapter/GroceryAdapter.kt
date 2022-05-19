package io.a70mm.utils.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sample.navigationdrawer.AppViewHolder
import com.sample.navigationdrawer.databinding.GraceryListBinding
import io.a70mm.utils.Model.ImagaData

class GroceryAdapter (
    private val imagedata: List<ImagaData>,
    private val ImageListener: OnImageSelected,
) : RecyclerView.Adapter<AppViewHolder<GraceryListBinding>>(),
    AppViewHolder.OnRowSelectedListener {

    interface OnImageSelected {
        fun onLatestVideoSelected(latestVideo: ImagaData)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): AppViewHolder<GraceryListBinding> {
        val itemBinding = GraceryListBinding.inflate(LayoutInflater.from(parent.context))
        return AppViewHolder(itemBinding, this)
    }
    override fun onBindViewHolder(holder: AppViewHolder<GraceryListBinding>, position: Int) {
        val imaga = imagedata[position]
        holder.itemBinding.text.text = imaga.getTitle()
    }
    override fun getItemCount() = 2

    override fun onRowSelected(position: Int) {
        ImageListener.onLatestVideoSelected(imagedata[position])
    }
}



