package com.application.schedulerz.ui.main.List

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.application.urbandictionary.R
import com.application.urbandictionary.data.models.Definition

class DefinitionListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val tvDefinition: TextView = view.findViewById(R.id.tv_definition)
    val tvThumbsUp: TextView = view.findViewById(R.id.tv_thumbs_up)
    val tvThumbsDown: TextView = view.findViewById(R.id.tv_thumbs_down)

    fun bind(task: Definition) {
        tvDefinition.text = task.definition ?: ""
        tvThumbsUp.text = task.thumbs_up.toString()
        tvThumbsDown.text = task.thumbs_down.toString()
    }
}