package com.example.managerapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.managerapp.R

class LoadAdapter:LoadStateAdapter<LoadAdapter.LoadViewHolder>() {

    class LoadViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val progressbar=itemView.findViewById<ProgressBar>(R.id.progress)

        fun bind(loadState: LoadState){
            progressbar.isVisible=loadState is LoadState.Loading

        }
    }

    override fun onBindViewHolder(holder: LoadViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.load_item,parent,false)
        return LoadViewHolder(view)
    }
}