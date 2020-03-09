package com.application.schedulerz.ui.main.List

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.application.urbandictionary.R
import com.application.urbandictionary.data.models.Definition

class DefinitionListAdapter(
    private var list: MutableList<Definition> = mutableListOf()
) : RecyclerView.Adapter<DefinitionListViewHolder>() {

    fun add(item: Definition) {
        list.add(item)
    }

    fun set(items: List<Definition>) {
        list.clear()
        list.addAll(items)
        super.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DefinitionListViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_definition, parent, false)
        return DefinitionListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: DefinitionListViewHolder, position: Int) {
        holder.bind(list[position])
    }

}