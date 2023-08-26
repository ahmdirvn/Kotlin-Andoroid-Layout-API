package com.example.tugasandroidstechoq

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RVadapter(

    private val context: Context,
    private val dataList: ArrayList<userModel>
) : RecyclerView.Adapter<RVadapter.MyViewHolder>() {

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val tvIDCard = view.findViewById<TextView>(R.id.id_Card)
        val tvDescription = view.findViewById<TextView>(R.id.description)
        val tvUrl = view.findViewById<TextView>(R.id.url)
        val ivThumbnail = view.findViewById<ImageView>(R.id.thumbnailUrl)
        val cvMain = view.findViewById<CardView>(R.id.cvMain)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.items_main, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = dataList[position]

        holder.tvIDCard.text = item.albumId.toString()
        holder.tvDescription.text = item.title
        holder.tvUrl.text = item.url

        // Load thumbnailUrl into ImageView using Glide
        Glide.with(context)
            .load(item.thumbnailUrl)
            .placeholder(R.drawable.placeholder_image) // Placeholder image while loading
            .error(R.drawable.error_image) // Image to show if loading fails
            .into(holder.ivThumbnail)

        holder.cvMain.setOnClickListener {
            Toast.makeText(context, item.title, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = dataList.size

    fun setData(data: ArrayList<userModel>) {
        dataList.clear()
        dataList.addAll(data)
        notifyDataSetChanged()
    }
}
