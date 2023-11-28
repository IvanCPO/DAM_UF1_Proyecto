package com.example.uf1_proyecto.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.uf1_proyecto.R
import com.example.uf1_proyecto.data.ButtonQuest
import com.example.uf1_proyecto.data.LineQuest
import com.example.uf1_proyecto.data.Question

class ItemAdapter( private val questions: List<Question> )
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {



    override fun getItemViewType(position: Int): Int {
        return when (questions.get(position)){
            is ButtonQuest -> 0
            is LineQuest -> 1
            else -> -1
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        when (viewType) {
            0 -> {
                val view = inflater.inflate(R.layout.item_options, parent, false)
                return RadioViewHolder(view)
            }
            1 -> {
                val view = inflater.inflate(R.layout.item_levels, parent, false)
                return LineaViewHolder(view)
            }
            else -> throw IllegalArgumentException("Tipo de vista no reconocido")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val question = questions.get(position)
        when (holder.itemViewType){
            0 -> {
                val a = holder as RadioViewHolder
                a.bind(question as ButtonQuest)

            }
            1 -> {
                val a = holder as LineaViewHolder
                a.bind(question as LineQuest)
            }
        }
    }

    override fun getItemCount(): Int = questions.size

    class RadioViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val textViewPregunta: TextView = itemView.findViewById(R.id.title_question_options)
        private val radioGroupOpciones: RadioGroup = itemView.findViewById(R.id.radio_options)

        fun bind(pregunta: ButtonQuest) {
            textViewPregunta.text = pregunta.title

            // Limpiar opciones existentes para evitar duplicados al reciclar la vista
            radioGroupOpciones.removeAllViews()

            // Crear botones dinámicamente
            for (opcion in pregunta.options) {
                val radioButton = RadioButton(itemView.context)
                radioButton.text = opcion
                radioGroupOpciones.addView(radioButton)
            }
        }
    }

    class LineaViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.title_question_line)
        val line: SeekBar = view.findViewById(R.id.seekBar2)
        fun bind(pregunta: LineQuest) {
            title.text = pregunta.title

            line.max = pregunta.numLevels
        }
    }

}