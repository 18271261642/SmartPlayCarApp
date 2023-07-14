package com.app.playcarapp.car.fragment

import com.app.playcarapp.R
import com.app.playcarapp.action.TitleBarFragment
import com.app.playcarapp.car.CarHomeActivity

/**
 * Created by Admin
 *Date 2023/7/14
 */
class HomeControlFragment : TitleBarFragment<CarHomeActivity>() {

    companion object{
        fun getInstance() : HomeControlFragment{
            return HomeControlFragment()
        }
    }


    override fun getLayoutId(): Int {
        return R.layout.fragment_home_control_layut
    }

    override fun initView() {

    }

    override fun initData() {

    }
}