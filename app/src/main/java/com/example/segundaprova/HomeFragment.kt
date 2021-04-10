package com.example.segundaprova

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.segundaprova.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    lateinit var binding:FragmentHomeBinding
    lateinit var viewModel:HomeFragmentViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        val viewModelFactory = HomeFragmentViewModelFactory(activity!!.application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(HomeFragmentViewModel::class.java)

        val adapter = IgrejaAdapter()
        viewModel.igrejas.observe(this, Observer {
            adapter.igrejas = it
        })

        binding.recyclerview.adapter = adapter

        val layout = LinearLayoutManager(this@HomeFragment.context!!, LinearLayoutManager.VERTICAL, false)
        binding.recyclerview.layoutManager = layout
        return binding.root
    }
}