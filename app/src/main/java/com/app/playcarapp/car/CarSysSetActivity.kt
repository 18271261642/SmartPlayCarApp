package com.app.playcarapp.car

import androidx.fragment.app.FragmentManager
import com.app.playcarapp.R
import com.app.playcarapp.action.AppActivity
import com.app.playcarapp.car.fragment.CarSysFragment

/**
 * 系统设置
 * Created by Admin
 *Date 2023/7/14
 */
class CarSysSetActivity : AppActivity() {

    var fragmentManager : FragmentManager ?= null


    override fun getLayoutId(): Int {
        return R.layout.activity_sys_set_layout
    }

    override fun initView() {

    }

    override fun initData() {
        fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager!!.beginTransaction()
        fragmentTransaction.add(R.id.stsSetFrameLayout,CarSysFragment.getInstance())
        fragmentTransaction.commit()
    }
}