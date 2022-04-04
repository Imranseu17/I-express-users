package com.app.i_express.view.adapter

import android.content.Context
import android.content.Intent
import android.view.*
import androidx.recyclerview.widget.RecyclerView
import com.app.i_express.R
import com.app.i_express.view.ui.parcel.ParcelDetailsActivity
import com.app.i_express.view.ui.profile.shop.ShopDetailsActivity


class AdapterShop(var context: Context) : RecyclerView.Adapter<AdapterShop.HistoryViewHolder>() {

    inner class HistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_shop,parent, false))
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            context.startActivity(Intent(context, ShopDetailsActivity::class.java))
        }

    }

    override fun getItemCount(): Int {
        return 3
    }
}