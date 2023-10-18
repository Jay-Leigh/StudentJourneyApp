package com.example.studentjourney.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studentjourney.R
import com.example.studentjourney.classs.Results

class RResultsAdapter(private val resultsList : ArrayList<Results>) : RecyclerView.Adapter<RResultsAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.results_card,
            parent,false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = resultsList[position]

        holder.Mname.text = currentitem.Mname
        holder.perc.text = currentitem.Percentage

    }

    override fun getItemCount(): Int {
        return resultsList.size
    }


    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val Mname : TextView = itemView.findViewById(R.id.tvModName)
        val perc : TextView = itemView.findViewById(R.id.tvPerc)

    }

}