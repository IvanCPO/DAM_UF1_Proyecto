package com.example.uf1_proyecto.content

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
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

        binding.buttonChange.setOnClickListener {
            binding.layoutChangeProfile.visibility = View.VISIBLE
        }
        binding.buttonChangeCancel.setOnClickListener {
            binding.layoutChangeProfile.visibility = View.INVISIBLE
        }
        binding.buttonChangeAcept.setOnClickListener {
            if (binding.passwordLast.text.toString().equals(PeopleViewModel.userUse!!.password)){
                if (binding.newPasswordConfig.text.toString().equals(binding.repitPasswordConfig.text.toString())){
                    takeConfigNew()
                    activity?.recreate()
                }else
                    Toast.makeText(requireContext(), "La nueva contraseña no se ha escrito bien. Vuelve a intentarlo", Toast.LENGTH_SHORT).show()
            }else
                Toast.makeText(requireContext(), "La antigua contraseña no es correcta, pruebalo de nuevo", Toast.LENGTH_SHORT).show()
        }


        return view
    }

    private fun takeConfigNew() {
        var username = binding.usernameConfig.text.toString()
        if (username.equals(""))
            username=binding.profileUsername.text.toString()
        PeopleViewModel.configUser(username,binding.newPasswordConfig.text.toString())
    }
}