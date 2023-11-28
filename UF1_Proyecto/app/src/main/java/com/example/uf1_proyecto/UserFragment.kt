package com.example.uf1_proyecto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.uf1_proyecto.data.Person
import com.example.uf1_proyecto.databinding.FragmentRegisterBinding
import com.example.uf1_proyecto.databinding.FragmentUserBinding

class UserFragment : Fragment() {

    var _binding : FragmentUserBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_introduce, container, false)
        _binding = FragmentUserBinding.inflate(inflater,container,false)
        var view = binding.root
//        binding.profileUsername = Person.userName
//        binding.pictureUser.profilePicture = Person.picture
        return view
    }
}