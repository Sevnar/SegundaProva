package com.example.segundaprova

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.segundaprova.databinding.FragmentCadastraBinding


class CadastraFragment : Fragment() {
    lateinit var binding:FragmentCadastraBinding
    lateinit var viewModel:CadastraFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cadastra, container, false)
        var viewModelFactory = CadastraFragmentViewModelFactory(activity!!.application)
        viewModel = ViewModelProvider(this,viewModelFactory).get(CadastraFragmentViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }


}