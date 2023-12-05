package com.example.uf1_proyecto.content

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.uf1_proyecto.PeopleViewModel
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
        binding.profileUsername.setText(PeopleViewModel.userUse!!.userName)
        binding.pictureUser.profilePicture.setImageResource(PeopleViewModel.userUse!!.picture)
        return view
    }
}