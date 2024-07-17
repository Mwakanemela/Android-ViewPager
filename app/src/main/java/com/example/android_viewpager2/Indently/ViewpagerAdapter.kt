package com.example.android_viewpager2.Indently

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_viewpager2.R

private const val TAG = "ViewpagerAdapter"

class ViewpagerAdapter(private var images: List<Int>) :
    RecyclerView.Adapter<ViewpagerAdapter.Pager2ViewHolder>() {
    inner class Pager2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val images: ImageView = itemView.findViewById(R.id.img)


        init {
            images.setOnClickListener {
                val position = adapterPosition
                Log.d(TAG, "${position + 1}: ")
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewpagerAdapter.Pager2ViewHolder {
        return Pager2ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewpagerAdapter.Pager2ViewHolder, position: Int) {

        holder.images.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return images.size
    }


}