package com.app.playcarapp.second

import android.widget.ImageView
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.playcarapp.R
import com.app.playcarapp.action.AppActivity
import com.app.playcarapp.adapter.SecondNotePadAdapter
import com.app.playcarapp.bean.NoteBookBean
import com.app.playcarapp.viewmodel.NoteBookViewModel



/**
 * Created by Admin
 *Date 2023/7/4
 */
class NotePadActivity : AppActivity() {

    private val viewModel by viewModels<NoteBookViewModel>()

    private var secondNoteRecyclerView : RecyclerView ?= null
    private var adapter : SecondNotePadAdapter ?= null
    private var list : MutableList<NoteBookBean> ?= null



    override fun getLayoutId(): Int {
       return R.layout.activity_note_pad_layout
    }

    override fun initView() {
        secondNoteRecyclerView = findViewById(R.id.secondNoteRecyclerView)
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        secondNoteRecyclerView?.layoutManager = linearLayoutManager
        list = ArrayList<NoteBookBean>()

        adapter = SecondNotePadAdapter(this, list as ArrayList<NoteBookBean>)
        secondNoteRecyclerView?.adapter = adapter

        findViewById<ImageView>(R.id.secondAddNoteImg).setOnClickListener {
            startActivity(SecondAddEditActivity::class.java)
        }
    }

    override fun initData() {
        viewModel.allNoteBookData.observe(this){
            list?.clear()
            list?.addAll(it)
            list?.sortByDescending { it.noteTimeLong }
            adapter?.notifyDataSetChanged()
        }
    }

    override fun onResume() {
        super.onResume()
        getAllDbData()
    }

    //查询所有的数据
    private fun getAllDbData(){
        viewModel.getAllDbData()
    }
}