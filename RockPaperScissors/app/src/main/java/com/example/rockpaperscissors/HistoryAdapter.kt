package com.example.rockpaperscissors

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_history.view.*

public class HistoryAdapter(private val history: List<RockPaperScissor>) : RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return history.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(history[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_history, parent, false)
        )
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        fun bind(history: RockPaperScissor){
            itemView.tvDate.text = history.date

            when (history.computerChoice){
                1 -> itemView.ivComputer.setImageResource(R.drawable.rock)
                2 -> itemView.ivComputer.setImageResource(R.drawable.paper)
                3 -> itemView.ivComputer.setImageResource(R.drawable.scissors)
            }
            when (history.playerChoice) {
                1 -> itemView.ivPlayer.setImageResource(R.drawable.rock)
                2 -> itemView.ivPlayer.setImageResource(R.drawable.paper)
                3 -> itemView.ivPlayer.setImageResource(R.drawable.scissors)
            }
        }
    }
    }
