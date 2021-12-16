package com.example.integration.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.integration.HistoryDepot
import com.example.integration.R

class HistoryDepotAdapter(private val historyList : ArrayList<HistoryDepot>) : RecyclerView.Adapter<HistoryDepotAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_history_depot,
            parent,false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val history = historyList[position]

        holder.action.text = history.action
        holder.date.text = history.date
        holder.points.text = history.points.toString()

    }

    override fun getItemCount(): Int {
        return historyList.size
    }


    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val action : TextView = itemView.findViewById(R.id.tvhistory_action_depot)
        val date : TextView = itemView.findViewById(R.id.tvhistory_date_depot)
        val points : TextView = itemView.findViewById(R.id.tvhistory_points_depot)

    }

}