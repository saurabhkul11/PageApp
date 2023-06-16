package com.example.managerapp.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.managerapp.R
import com.example.managerapp.databinding.ItemListBinding
import com.example.managerapp.model.ProductData

class ProductAdapter(var context:Context,var data: List<ProductData> ):
    RecyclerView.Adapter<ProductAdapter.MyViewHolder>() {
    lateinit var binding: ItemListBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            binding=DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.item_list,parent,false)
            return MyViewHolder(binding)
    }

    override fun getItemCount()=data.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val curr=data[position]
       holder.binding.data= curr

    }
    class MyViewHolder(val binding: ItemListBinding):RecyclerView.ViewHolder(binding.root) {
    }
}
