package com.example.uf1_proyecto.content

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uf1_proyecto.PeopleViewModel
import com.example.uf1_proyecto.R
import com.example.uf1_proyecto.adapter.ItemAdapter
import com.example.uf1_proyecto.data.Datasource
import com.example.uf1_proyecto.data.Question
import com.example.uf1_proyecto.databinding.FragmentMeetMeBinding
import com.example.uf1_proyecto.databinding.FragmentTestBinding
import com.google.android.material.card.MaterialCardView

class MeetMeFragment : Fragment() {

    private var _binding : FragmentMeetMeBinding? = null
    private val binding get() = _binding!!
    private var myDataset: List<Question>? = null
    private lateinit var peopleViewModel: PeopleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMeetMeBinding.inflate(inflater,container,false)
        val view = binding.root

        peopleViewModel = ViewModelProvider(this).get(PeopleViewModel::class.java)

        myDataset = Datasource(requireContext()).loadQuestionsIvan().shuffled().take(6)
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val itemAdapter = ItemAdapter(myDataset!!)
        recyclerView.adapter = itemAdapter
        recyclerView.isNestedScrollingEnabled = false

        val button = binding.buttonResults
        button.setOnClickListener {
            val questions = (recyclerView.adapter as ItemAdapter).getQuestions()

            if (isCompleted(recyclerView,questions)) {
                var puntaje = 0

                for (i in 0 until recyclerView.childCount) {
                    val question = questions[i]

                    if (question.res==question.sol) {
                        puntaje++
                    }
                }
                Toast.makeText(requireContext(), "Resultado: $puntaje    numPreguntas: ${questions.size}", Toast.LENGTH_SHORT).show()
                peopleViewModel.setMeet()
                peopleViewModel.setResult(questions.size,puntaje)
                view.findNavController().navigate(R.id.action_meetMeFragment_to_resultFragment)
            }
        }

        return view
    }

    private fun isCompleted(
        recyclerView: RecyclerView,
        questions: List<Question>
    ): Boolean {
        var todasMarcadas = true
        for (i in 0 until recyclerView.childCount) {
            val question = questions[i]
            val cardView = recyclerView.getChildAt(i) as CardView
            val estaMarcada = question.res!=null

            if (!estaMarcada) {
                cardView.setCardBackgroundColor(Color.RED)

                todasMarcadas = false
            }
            else
                cardView.setCardBackgroundColor(Color.WHITE)
        }
        if (!todasMarcadas)
            Toast.makeText(requireContext(), getString(R.string.make_all_please), Toast.LENGTH_SHORT).show()
        return todasMarcadas
    }


}