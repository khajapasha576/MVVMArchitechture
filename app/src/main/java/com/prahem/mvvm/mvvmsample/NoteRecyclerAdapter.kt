package com.prahem.mvvm.mvvmsample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class NoteRecyclerAdapter(
        val viewModel: MainViewModel,
        val arrayList: ArrayList<Blog>,
        private val context: Context
) : RecyclerView.Adapter<NoteRecyclerAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int,
    ): NoteRecyclerAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteRecyclerAdapter.MyViewHolder, position: Int) {
        holder.bind(arrayList[position])
    }

    override fun getItemCount(): Int {
        if (arrayList.size == 0) {
            Toast.makeText(context, "List is empty", Toast.LENGTH_LONG).show()
        }
        return arrayList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(blog: Blog) {
            itemView.findViewById<TextView>(R.id.title).text = blog.title
            itemView.findViewById<ImageButton>(R.id.delete).setOnClickListener {
                viewModel.remove(blog)
                notifyItemRemoved(arrayList.indexOf(blog))
            }
        }
    }
}