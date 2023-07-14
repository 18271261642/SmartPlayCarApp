package com.app.playcarapp.car.fragment

import com.app.playcarapp.R
import com.app.playcarapp.action.TitleBarFragment
import com.app.playcarapp.car.CarSysSetActivity

/**
 * 气罐压力
 * Created by Admin
 *Date 2023/7/14
 */
class CarGassPressureFragment : TitleBarFragment<CarSysSetActivity>(){

    companion object{
        fun getInstance() : CarGassPressureFragment{
            return CarGassPressureFragment()
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_car_gass_pressure_layout
    }

    override fun initView() {

    }

    override fun initData() {

    }
}