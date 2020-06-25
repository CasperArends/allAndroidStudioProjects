package com.example.studentportal

<<<<<<< HEAD

=======
>>>>>>> f1f0d67b7d848b16dd693c9e94172f803a42a252
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.portal_buttons.view.*

<<<<<<< HEAD
public class LinkAdapter(private val links: List<Link>, private val clickListener: (Link) -> Unit) :RecyclerView.Adapter<LinkAdapter.ViewHolder>() {
=======
public class LinkAdapter(private val links: List<Link>) :
    RecyclerView.Adapter<LinkAdapter.ViewHolder>() {
>>>>>>> f1f0d67b7d848b16dd693c9e94172f803a42a252

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.portal_buttons, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return links.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
<<<<<<< HEAD
        holder.bind(links[position], clickListener)
=======
        holder.bind(links[position])
>>>>>>> f1f0d67b7d848b16dd693c9e94172f803a42a252
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

<<<<<<< HEAD
        fun bind(link: Link, clickListener: (Link) -> Unit){
            itemView.button.text = link.name + "\n" + link.url
            itemView.button.setOnClickListener{
                clickListener(link)
            }
=======
        fun bind(link: Link){
            itemView.button.text = link.name
>>>>>>> f1f0d67b7d848b16dd693c9e94172f803a42a252
        }
    }
}