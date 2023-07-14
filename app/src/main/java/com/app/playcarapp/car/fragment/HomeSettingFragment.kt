package com.app.playcarapp.car.fragment

import com.app.playcarapp.R
import com.app.playcarapp.action.TitleBarFragment
import com.app.playcarapp.car.CarAboutActivity
import com.app.playcarapp.car.CarHomeActivity
import com.app.playcarapp.car.CarSysSetActivity
import com.app.playcarapp.car.CarSystemCheckActivity
import com.app.playcarapp.second.SecondScanActivity
import com.bonlala.widget.layout.SettingBar

/**
 * Created by Admin
 *Date 2023/7/14
 */
class HomeSettingFragment : TitleBarFragment<CarHomeActivity>() {


    companion object{
        fun getInstance() : HomeSettingFragment{
            return HomeSettingFragment()
        }
    }

    override fun getLayoutId(): Int {
       return R.layout.fragment_home_setting_layout
    }

    override fun initView() {
        findViewById<SettingBar>(R.id.sysConnDeviceBar).setOnClickListener {
            startActivity(SecondScanActivity::class.java)
        }
        findViewById<SettingBar>(R.id.sysSysBar).setOnClickListener {
            startActivity(CarSysSetActivity::class.java)
        }
        findViewById<SettingBar>(R.id.sysCheckBar).setOnClickListener {
            startActivity(CarSystemCheckActivity::class.java)
        }
        findViewById<SettingBar>(R.id.sysAboutBar).setOnClickListener {
            startActivity(CarAboutActivity::class.java)
        }
    }

    override fun initData() {

    }
}