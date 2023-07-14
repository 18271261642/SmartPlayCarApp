package com.app.playcarapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.playcarapp.bean.DbManager
import com.app.playcarapp.bean.NoteBookBean

/**
 * Created by Admin
 *Date 2023/1/10
 */
class NoteBookViewModel : ViewModel() {

    //查询所有的记事本数据
    var allNoteBookData = MutableLiveData<List<NoteBookBean>>()


    //查询所有的记事本数据
    fun getAllDbData(){
        val list = DbManager.getInstance().queryAllNoteBook()
        allNoteBookData.postValue(list)
    }
}