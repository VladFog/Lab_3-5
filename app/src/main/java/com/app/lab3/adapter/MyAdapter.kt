package com.app.lab3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.app.lab3.databinding.StudentItemBinding
import com.app.lab3.model.Student

class MyAdapter(private val myList: LiveData<List<Student>>) :
    RecyclerView.Adapter<MyAdapter.MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyHolder {
        return StudentHolder(
            StudentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyAdapter.MyHolder, position: Int) {
        return holder.bind(myList.value?.get(position) ?: return)
    }

    override fun getItemCount(): Int {
        return myList.value?.size ?: 0
    }

    abstract class MyHolder(itemBinding: ViewBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        abstract fun bind(item: Student)
    }

    class StudentHolder(private val itemBinding: StudentItemBinding) : MyHolder(itemBinding) {
        override fun bind(item: Student) {
            itemBinding.studentFirstName.text = item.firstName
            itemBinding.studentSecondName.text = item.secondName
            itemBinding.studentBirthDate.text = item.birthDate.toString()
//            itemBinding.studentPhoneNumber.text = item.phoneNumber
//            itemBinding.studentAverageRating.text = item.averageRating.toString()
        }

    }
}
