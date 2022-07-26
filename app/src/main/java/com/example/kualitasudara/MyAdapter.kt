package com.example.kualitasudara

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter (private val fpList: ArrayList<dataSensor>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.item_history_data, parent, false)
        return MyViewHolder(item)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val currentItem = fpList[position]

        holder.waktu.text = currentItem.waktu
        holder.status.text = currentItem.status
        holder.co2.text = currentItem.gas
        holder.pm.text = currentItem.debu
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val waktu = itemView.findViewById<TextView>(R.id.tvWaktuRiwayatVal)
        val status = itemView.findViewById<TextView>(R.id.tvStatusRiwayatPemakaianVal)
        val co2 = itemView.findViewById<TextView>(R.id.tvGasVal)
        val pm = itemView.findViewById<TextView>(R.id.tvDebuVal)
    }

    override fun getItemCount(): Int {
        return fpList.size
    }
//
//    fun updateData(viewModels: ArrayList<ViewModel?>?) {
//        item.clear()
//        item.addAll(viewModels)
//        notifyDataSetChanged()
//    }
}