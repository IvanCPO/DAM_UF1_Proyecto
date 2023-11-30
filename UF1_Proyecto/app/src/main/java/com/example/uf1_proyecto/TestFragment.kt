package com.example.uf1_proyecto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uf1_proyecto.adapter.ItemAdapter
import com.example.uf1_proyecto.data.Datasource
import com.example.uf1_proyecto.data.Question
import com.example.uf1_proyecto.databinding.FragmentTestBinding

class TestFragment : Fragment() {

    private var _binding : FragmentTestBinding? = null
    private val binding get() = _binding!!
    private var myDataset: List<Question>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_introduce, container, false)
        _binding = FragmentTestBinding.inflate(inflater,container,false)
        val view = binding.root
        myDataset = Datasource().loadQuestionsCompatibility()
        val recyclerView = binding.root.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val itemAdapter = ItemAdapter(myDataset!!)
        recyclerView.adapter = itemAdapter
        recyclerView.isNestedScrollingEnabled = false
        binding.buttonResults.setOnClickListener {
            view.findNavController().navigate(R.id.action_testFragment_to_userFragment)
        }


//        val drawerLayout = binding.drawerLayout
//        val navController = binding.navView.findNavController()
//
//        val appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)
//        setupActionBarWithNavController(activity,navController,appBarConfiguration)

        return view
    }


}