package com.app.playcarapp.car.fragment

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.playcarapp.R
import com.app.playcarapp.action.TitleBarFragment
import com.app.playcarapp.car.CarSysSetActivity
import com.app.playcarapp.car.adapter.CarTimerAdapter
import com.app.playcarapp.car.bean.TimerBean

/**
 * 高度记忆设置
 * Created by Admin
 *Date 2023/7/18
 */
class CarHeightMemoryFragment : TitleBarFragment<CarSysSetActivity>(){

    companion object{
        fun getInstance() : CarHeightMemoryFragment{
            return CarHeightMemoryFragment()
        }
    }

    private var carHeightMemoryRy : RecyclerView ?= null
    private var list : MutableList<TimerBean> ?= null

    private var adapter : CarTimerAdapter?= null


    override fun getLayoutId(): Int {
       return R.layout.fragment_car_height_memory_layout
    }

    override fun initView() {
        carHeightMemoryRy = findViewById(R.id.carHeightMemoryRy)
        val linearLayoutManager = LinearLayoutManager(attachActivity)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        carHeightMemoryRy?.layoutManager = linearLayoutManager
        list = ArrayList<TimerBean>()
        adapter = CarTimerAdapter(attachActivity, list as ArrayList<TimerBean>)
        carHeightMemoryRy?.adapter = adapter
    }

    override fun initData() {
        list?.clear()
        val array = arrayListOf<TimerBean>(
            TimerBean("1",false),
            TimerBean("2",false),
            TimerBean("3",false),
            TimerBean("4",false),
        TimerBean("LOW",false))
        list?.addAll(array)
        adapter?.notifyDataSetChanged()
    }
}