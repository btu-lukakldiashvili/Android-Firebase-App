package com.lukakldiashvili.androidfirebaseapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.lukakldiashvili.androidfirebaseapp.R
import com.lukakldiashvili.androidfirebaseapp.adapters
import com.lukakldiashvili.androidfirebaseapp.databinding.FragmentImageBinding
import com.lukakldiashvili.androidfirebaseapp.models.Car
import com.lukakldiashvili.androidfirebaseapp.adapters.CarRecyclerViewAdapter

class CarFragment : Fragment() {

    private lateinit var _binding : FragmentImageBinding
    private val binding get() = _binding

    lateinit var myAdapter: CarRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentImageBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myAdapter = CarRecyclerViewAdapter(getData())
        val navigation = findNavController()

        binding.apply {
            myRecyclerView.adapter = myAdapter
            myRecyclerView.layoutManager = LinearLayoutManager(context)

            myAdapter.onClick = {
                val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(it.fruitName!!, it.fruitDescription!!)
                navigation.navigate(action)
            }
        }

    }

    private fun getData(): MutableList<Car> {
        var fruitArray = arrayListOf<Car>()
        fruitArray.add(Car("car1","description1"))
        fruitArray.add(Car("car2","description2"))
        fruitArray.add(Car("car3","description3"))
        fruitArray.add(Car("car4","description4"))
        return fruitArray
    }
}