package com.lukakldiashvili.androidfirebaseapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lukakldiashvili.androidfirebaseapp.R
import com.lukakldiashvili.androidfirebaseapp.databinding.ItemViewBinding

class CarRecyclerViewAdapter(val fruitList: MutableList<Car>) : RecyclerView.Adapter<CarRecyclerViewAdapter.CarViewHolder>() {

    var onClick : ((Car) -> Unit)? = null

    inner class CarViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val binding = ItemViewBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return CarViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {

        holder.binding.apply {
            carNameTV.text = fruitList[position].fruitName
            carDescriptionTV.text = fruitList[position].fruitDescription
        }
        holder.itemView.setOnClickListener {
            onClick?.invoke(Car(fruitList[position].fruitName,fruitList[position].fruitDescription))
        }
    }

    override fun getItemCount() = fruitList.size
}