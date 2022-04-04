package com.app.i_express.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.i_express.R
import com.bumptech.glide.Glide

class AdapterFinance(val context: Context?) :
    RecyclerView.Adapter<AdapterFinance.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val note = itemView.findViewById<TextView>(R.id.note);
        val time = itemView.findViewById<TextView>(R.id.timestmp);
        val thumb = itemView.findViewById<ImageView>(R.id.thumb);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_finance, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 10;
    }
}