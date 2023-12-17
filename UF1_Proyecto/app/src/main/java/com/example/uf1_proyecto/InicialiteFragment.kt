package com.example.uf1_proyecto

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.findFragment
import androidx.navigation.findNavController
import com.example.uf1_proyecto.databinding.FragmentInicialiteBinding

class InicialiteFragment : Fragment() {


    var _binding : FragmentInicialiteBinding? = null
    val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInicialiteBinding.inflate(inflater,container,false)
        val view = binding.root

        binding.buttonRegister.setOnClickListener {
            view.findNavController().navigate(R.id.action_inicialiteFragment_to_registerFragment)
        }
        binding.buttonAccept.setOnClickListener {
            if (PeopleViewModel.takeUser(binding.inicialiteUsername.text.toString(), binding.inicialitePassword.text.toString()) != null){
            var intent = Intent(activity, ContentActivity::class.java)
            startActivity( intent)
            }else{
                Toast.makeText(
                    activity,
                    getString(R.string.bad_login_toast),
                    Toast.LENGTH_LONG
                ).show()
                binding.inicialiteUsername.setText("")
                binding.inicialitePassword.setText("")
            }
        }
        return view

    }

    override fun onResume() {
        super.onResume()
        binding.inicialiteUsername.setText("")
        binding.inicialitePassword.setText("")

    }

}