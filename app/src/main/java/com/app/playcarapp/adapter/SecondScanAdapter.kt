package com.app.playcarapp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.playcarapp.R
import com.app.playcarapp.bean.BleBean

/**
 * Created by Admin
 *Date 2023/7/12
 */
class SecondScanAdapter(private val context: Context,private val list : MutableList<BleBean>) : RecyclerView.Adapter<SecondScanAdapter.ScanDeviceViewHolder>() {

    private var onItemClickListener : OnCommItemClickListener ?= null

    fun setOnItemClick(click : OnCommItemClickListener){
        this.onItemClickListener = click
    }


    class ScanDeviceViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var itemScanName  = itemView.findViewById<TextView>(R.id.itemSecondNameTv)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScanDeviceViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_second_scan_layout,parent,false)
        return ScanDeviceViewHolder(view)
    }

    @SuppressLint("MissingPermission")
    override fun onBindViewHolder(holder: SecondScanAdapter.ScanDeviceViewHolder, position: Int) {

        holder.itemScanName.text = list[position].bluetoothDevice.name


        holder.itemView.setOnClickListener {
            val position = holder.layoutPosition
            onItemClickListener?.onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}