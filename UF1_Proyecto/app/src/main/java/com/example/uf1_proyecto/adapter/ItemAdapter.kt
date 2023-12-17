package com.example.uf1_proyecto.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.uf1_proyecto.R
import com.example.uf1_proyecto.data.ButtonQuest
import com.example.uf1_proyecto.data.LineQuest
import com.example.uf1_proyecto.data.Question
import kotlin.coroutines.coroutineContext

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


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        val question = questions.get(position)
        when (holder.itemViewType){
            0 -> {
                val a = holder as RadioViewHolder
                a.bind(question as ButtonQuest)

                a.getRadioGroupOption().setOnCheckedChangeListener { group, checkedId ->
                    val radioButton = holder.itemView.findViewById<RadioButton>(checkedId)
                    val textoSeleccionado = radioButton.text.toString()
                    for (i in 0 until question.options.size){
                        if (question.options[i].equals(textoSeleccionado))
                            question.res=i
                    }
                }

            }
            1 -> {
                val a = holder as LineaViewHolder
                a.bind(question as LineQuest)
                a.getLine().setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
                    override fun onProgressChanged(
                        seekBar: SeekBar?,
                        progress: Int,
                        fromUser: Boolean
                    ) {
                        questions.get(position).res=progress
                    }
                    override fun onStartTrackingTouch(seekBar: SeekBar?) {}
                    override fun onStopTrackingTouch(seekBar: SeekBar?) {}
                })

            }
        }

    }

    override fun getItemCount(): Int = questions.size



    class RadioViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val textViewPregunta: TextView = itemView.findViewById(R.id.title_question_options)
        private val radioGroupOpciones: RadioGroup = itemView.findViewById(R.id.radio_options)

        fun bind(pregunta: ButtonQuest) {
            textViewPregunta.text = pregunta.title
            radioGroupOpciones.removeAllViews()

            for (opcion in pregunta.options) {
                val radioButton = RadioButton(itemView.context)
                radioButton.text = opcion
                radioGroupOpciones.addView(radioButton)
            }

        }
        fun getRadioGroupOption():RadioGroup {
            return radioGroupOpciones
        }
    }

    class LineaViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val title: TextView = view.findViewById(R.id.title_question_line)
        private val line: SeekBar = view.findViewById(R.id.seekBar2)
        fun bind(pregunta: LineQuest) {
            title.text = pregunta.title

            line.max = pregunta.numLevels
        }
        fun getLine():SeekBar {
            return line
        }
    }

    fun getQuestions():List<Question>{
        return questions
    }

}