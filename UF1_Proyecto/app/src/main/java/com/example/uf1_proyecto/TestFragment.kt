package com.example.uf1_proyecto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.uf1_proyecto.adapter.ItemAdapter
import com.example.uf1_proyecto.data.Datasource
import com.example.uf1_proyecto.databinding.FragmentRegisterBinding
import com.example.uf1_proyecto.databinding.FragmentTestBinding

class TestFragment : Fragment() {

    var _binding : FragmentTestBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_introduce, container, false)
        _binding = FragmentTestBinding.inflate(inflater,container,false)
        var view = binding.root
        val myDataset = Datasource().loadQuestions()
        val recyclerView = binding.recyclerView

        //recyclerView.adapter = ItemAdapter (activity.context, myDataset)
        recyclerView.setHasFixedSize(true)
        return view
    }
}