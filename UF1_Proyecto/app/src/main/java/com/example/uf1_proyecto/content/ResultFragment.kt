package com.example.uf1_proyecto.content

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.uf1_proyecto.PeopleViewModel
import com.example.uf1_proyecto.R
import com.example.uf1_proyecto.data.Question
import com.example.uf1_proyecto.databinding.FragmentMeetMeBinding
import com.example.uf1_proyecto.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private var _binding : FragmentResultBinding? = null
    private val binding get() = _binding!!
    private lateinit var peopleViewModel: PeopleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultBinding.inflate(inflater,container,false)
        val view = binding.root
        peopleViewModel = ViewModelProvider(this).get(PeopleViewModel::class.java)
        var percent = peopleViewModel.getResult()
        var meet = peopleViewModel.meet
        var res: String= getString(R.string.intro_resul)
        res+="$percent%. User = ${peopleViewModel.userUse!!.userName} "
        if (percent<=50) {
            if (meet)
                res += getString(R.string.res_1)
            else
                res += getString(R.string.res_2)
        }else {
            if (percent <= 70) {
                if (meet)
                    res += getString(R.string.res_3)
                else
                    res += getString(R.string.res_4)
            }else {

                if (meet)
                    res += getString(R.string.res_5)
                else
                    res += getString(R.string.res_6)
            }
        }
        binding.infoRes.text = res

        return view
    }
}