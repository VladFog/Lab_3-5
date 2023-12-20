package com.app.lab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.lab3.adapter.MyAdapter
import com.app.lab3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var vm: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val rv = binding.rvList
        rv.layoutManager = LinearLayoutManager(this)
        vm = ViewModelProvider(this)[MainViewModel::class.java]
        val myAdapter = MyAdapter(vm.myList)
        rv.adapter = myAdapter
        rv.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        vm.myList.observe(this){
            myAdapter.notifyDataSetChanged()
        }
    }
}