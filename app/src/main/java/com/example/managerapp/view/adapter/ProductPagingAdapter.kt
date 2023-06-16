package com.example.managerapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.paging.DifferCallback
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.managerapp.R
import com.example.managerapp.Results

class ProductPagingAdapter:PagingDataAdapter<Results, ProductPagingAdapter.PagingViewHolder>(
    comparator) {

    class PagingViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        val name= itemView.findViewById<TextView>(R.id.page_txt)
    }


    override fun onBindViewHolder(holder: PagingViewHolder, position: Int) {
        val item=getItem(position)
        holder.name.setText(item?.content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagingViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.page_list,parent,false)
        return PagingViewHolder(view)
    }


    companion object{
        private val comparator=object :DiffUtil.ItemCallback<Results>(){
            override fun areItemsTheSame(oldItem: Results, newItem: Results): Boolean {
                return oldItem.Id==newItem.Id
            }

            override fun areContentsTheSame(oldItem: Results, newItem: Results): Boolean {
                return oldItem==newItem
            }

        }
    }
}