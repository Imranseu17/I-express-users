package com.app.i_express.view.adapter

import android.content.Context
import android.content.Intent
import android.view.*
import androidx.recyclerview.widget.RecyclerView

import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import com.app.i_express.R
import com.app.i_express.view.ui.parcel.ParcelDetailsActivity


class AdapterParcel(var context: Context) : RecyclerView.Adapter<AdapterParcel.HistoryViewHolder>() {


    inner class HistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var overflow  = itemView.findViewById<ImageView>(R.id.overflow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_parcel,parent, false))
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {

        holder.itemView.setOnClickListener {
            //Toast.makeText(context, "pressed!!!", Toast.LENGTH_SHORT).show()
            context.startActivity(Intent(context, ParcelDetailsActivity::class.java))
        }

        holder.overflow.setOnClickListener {
            showPopupMenu(it)
        }

    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
    private fun showPopupMenu(view: View) {

        val popup = PopupMenu(context, view)
        popup.getMenu().add("Delete")
        popup.getMenu().add("Track")
        popup.getMenu().add("Raise an issue")
        popup.setOnMenuItemClickListener {
            false;
        }
        popup.show()
    }

    override fun getItemCount(): Int {
        return 10;
    }
}