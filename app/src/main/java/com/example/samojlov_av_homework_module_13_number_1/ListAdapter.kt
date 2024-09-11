package com.example.samojlov_av_homework_module_13_number_1

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class ListAdapter(context: Context, listItem: MutableList<String>) :
    ArrayAdapter<String>(context, R.layout.list_item, listItem) {
    @SuppressLint("SetTextI18n")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val stroke: String? = getItem(position)
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        }

        val indexItemTV = view?.findViewById<TextView>(R.id.indexItemTV)
        val itemNameTV = view?.findViewById<TextView>(R.id.itemNameTV)

        indexItemTV?.text = "${position + 1}"
        itemNameTV?.text = stroke

        return view!!
    }
}