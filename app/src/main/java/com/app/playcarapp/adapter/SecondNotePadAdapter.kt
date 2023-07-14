package com.app.playcarapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.playcarapp.R
import com.app.playcarapp.bean.NoteBookBean
import com.app.playcarapp.utils.BikeUtils


/**
 * 键盘二代记事本adapter
 * Created by Admin
 *Date 2023/7/4
 */
class SecondNotePadAdapter(val context: Context, val list: MutableList<NoteBookBean>) :
    RecyclerView.Adapter<SecondNotePadAdapter.NoteViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.item_second_note_pad_layout, parent, false)
        return NoteViewHolder(view)
    }
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
//        val view = LayoutInflater.from(context)
//            .inflate(R.layout.item_second_note_pad_layout, parent, false)
//        return NoteViewHolder(view)
//    }




    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val bean = list.get(position)
        holder.itemSecondNoteTitleTv.text = bean.noteTitle
        holder.itemSecondTimeTv.text = BikeUtils.getFormatDate(bean.noteTimeLong,"yyyy/MM/dd")
        holder.itemSecondContentTv.text = bean.noteContent
    }


    class NoteViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val itemSecondNoteTitleTv: TextView = view.findViewById(R.id.itemSecondNoteTitleTv)
        val itemSecondTimeTv: TextView = view.findViewById(R.id.itemSecondTimeTv)
        val itemSecondContentTv: TextView = view.findViewById(R.id.itemSecondContentTv)


    }
}