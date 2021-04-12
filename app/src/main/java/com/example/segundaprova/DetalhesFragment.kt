package com.example.segundaprova

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.segundaprova.databinding.FragmentDetalhesBinding


class DetalhesFragment : Fragment() {

    lateinit var binding:FragmentDetalhesBinding
    lateinit var viewModel:DetalhesFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detalhes, container,false)
        val viewModelFactory = DetalhesFragmentViewModelFactory(activity!!.application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(DetalhesFragmentViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        val args = DetalhesFragmentArgs.fromBundle(arguments!!)
        viewModel.search(args.id)



        return binding.root
    }


}