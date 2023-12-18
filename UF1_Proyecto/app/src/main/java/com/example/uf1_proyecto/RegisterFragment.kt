package com.example.uf1_proyecto

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.uf1_proyecto.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    var _binding : FragmentRegisterBinding? = null
    val binding get() = _binding!!
    private lateinit var peopleViewModel: PeopleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater,container,false)
        var view = binding.root
        peopleViewModel = ViewModelProvider(this).get(PeopleViewModel::class.java)

        binding.buttonStart.setOnClickListener {
            var userName = binding.userNameRegister.text.toString()
            var userPass = binding.password.text.toString()
            var passValue = binding.repitPassword.text.toString()
            if (!userPass.equals(passValue)) {
                Toast.makeText(
                    activity,
                    getString(R.string.bad_password_toast),
                    Toast.LENGTH_LONG
                ).show()
                
            }else{
                peopleViewModel.addUser(userName,userPass)
                peopleViewModel.takeUser(userName,userPass)
                var intent = Intent(activity, ContentActivity::class.java)

                startActivity( intent)
            }
            binding.userNameRegister.setText("")
            binding.password.setText("")
            binding.repitPassword.setText("")
        }
        return view
    }
}