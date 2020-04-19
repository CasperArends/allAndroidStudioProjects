package com.example.studentportal


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.portal_buttons.view.*

public class LinkAdapter(private val links: List<Link>, private val clickListener: (Link) -> Unit) :RecyclerView.Adapter<LinkAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.portal_buttons, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return links.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(links[position], clickListener)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bind(link: Link, clickListener: (Link) -> Unit){
            itemView.button.text = link.name + "\n" + link.url
            itemView.button.setOnClickListener{
                clickListener(link)
            }
        }
    }
}