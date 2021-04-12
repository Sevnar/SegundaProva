package com.example.segundaprova

import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
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

        binding.recyclerview.addOnItemTouchListener(RecyclerViewClickListener(this@HomeFragment.context!!, binding.recyclerview,
        object :RecyclerViewClickListener.OnItemClickListener{

            override fun onItemClick(v: View, position: Int) {
                var igreja = viewModel.igrejas.value!!.get(position)
                Navigation.findNavController(binding.recyclerview).navigate(HomeFragmentDirections.actionHomeFragmentToDetalhesFragment(igreja.id))

            }

            override fun onItemlongClick(v: View, position: Int) {
                TODO("Not yet implemented")
            }

        }))

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.ajuda_menu, menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,this.findNavController()) || super.onOptionsItemSelected(item)
    }
}