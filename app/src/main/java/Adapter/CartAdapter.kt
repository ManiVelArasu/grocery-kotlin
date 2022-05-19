package io.a70mm.utils.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.sample.navigationdrawer.R
import io.a70mm.utils.Model.CartData

class CartAdapter (private var cartlist: List<CartData>) :
    RecyclerView.Adapter<CartAdapter.MyViewHolder>() {
    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var price: TextView = view.findViewById(R.id.price)

    }
    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.cart_view, parent, false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val movie = cartlist[position]
        holder.price.text = movie.getItem()
    }
    override fun getItemCount(): Int {
        return cartlist.size
    }
}