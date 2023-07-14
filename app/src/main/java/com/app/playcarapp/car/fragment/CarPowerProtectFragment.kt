package com.app.playcarapp.car.fragment

import com.app.playcarapp.R
import com.app.playcarapp.action.TitleBarFragment
import com.app.playcarapp.car.CarSysSetActivity

/**
 * 电瓶保护
 * Created by Admin
 *Date 2023/7/14
 */
class CarPowerProtectFragment : TitleBarFragment<CarSysSetActivity>(){


    companion object{
        fun getInstance() : CarPowerProtectFragment{
            return CarPowerProtectFragment()
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_car_power_protect_layout
    }

    override fun initView() {

    }

    override fun initData() {

    }
}