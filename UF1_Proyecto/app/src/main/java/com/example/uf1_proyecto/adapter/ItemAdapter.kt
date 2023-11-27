package com.example.uf1_proyecto.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.uf1_proyecto.R
import com.example.uf1_proyecto.data.Question

class ItemAdapter(private val context: Context,
                  private val dataset: List<Question>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
        when (viewType) {
            0 -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_options, parent, false)
                return RadioViewHolder(view)
            }
            1 -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_levels, parent, false)
                return LineaViewHolder(view)
            }
            else -> throw IllegalArgumentException("Tipo de vista no reconocido")
        }
    }

    override fun getItemCount(): Int = dataset.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val question = dataset.get(position)
        when (holder.itemViewType){
            0 -> {
                val a = holder as RadioViewHolder
                a.title.setText(question.title)

            }
            1 -> {

            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if(dataset.get(position).options != null) 0 else 1
    }

//    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
//        val title: TextView = view.findViewById(R.id.item_title)
//    }

    class RadioViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.title_question)
        val radios: TextView = view.findViewById(R.id.radio_options)
    }

    class LineaViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.title_question)
        val radios: TextView = view.findViewById(R.id.seekBar2)
    }

}