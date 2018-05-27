package com.khinthirisoe.test.second

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.khinthirisoe.test.R
import com.khinthirisoe.test.core.model.Service
import kotlinx.android.synthetic.main.service_lists.view.*

class RecyclerAdapter(private val mContext: Context, private val lists: List<Service>) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val name = itemView.tv_name
        val currencyName = itemView.tv_currency
        val price = itemView.tv_price
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = mContext.layoutInflater.inflate(R.layout.service_lists, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.currencyName.text = lists[position].label
        holder.name.text = lists[position].name
        holder.price.text = lists[position].price.toString()

    }

    override fun getItemCount(): Int {
        return lists.size
    }
}