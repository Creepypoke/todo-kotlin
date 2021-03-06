package com.example.todo_kotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class NotesAdapter(private val myDataset: ArrayList<Note>) : RecyclerView.Adapter<NotesAdapter.ViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just a string in this case that is shown in a TextView.
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val txtTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        val txtDescription = itemView.findViewById<TextView>(R.id.tvContent)
    }


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesAdapter.ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.note, parent, false)
        return ViewHolder(v)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder?.txtTitle?.text = listNotes[position].title
        holder?.txtDescription?.text = listNotes[position].content
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myDataset.size
}