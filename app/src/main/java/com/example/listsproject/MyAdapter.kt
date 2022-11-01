package com.example.listsproject

import android.content.res.ColorStateList
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.listsproject.model.Response
import com.squareup.picasso.Picasso

class MyAdapter(private val data: Response) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {



    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {}




    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.list_item, viewGroup, false)

        return MyViewHolder(view)
    }



    override fun onBindViewHolder(viewHolder: MyViewHolder, position: Int) {

        val myImage = viewHolder.itemView.findViewById<ImageView>(R.id.image)
        val myTitle = viewHolder.itemView.findViewById<TextView>(R.id.title)
        val overView = viewHolder.itemView.findViewById<TextView>(R.id.overView)


        Picasso.get()
            .load(data.results[position].poster_path)
            .into(myImage)


        myTitle.text = data.results[position].title

        overView.text = data.results[position].overview
    }


    override fun getItemCount() = data.results.size

}
