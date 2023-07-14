package com.app.playcarapp.second

import com.app.playcarapp.R
import com.app.playcarapp.action.TitleBarFragment
import com.hjq.shape.view.ShapeTextView

/**
 * 设备页面
 */
class MenuDeviceFragment : TitleBarFragment<SecondHomeActivity>(){


    companion object{

        fun getInstance() : MenuDeviceFragment{
            return MenuDeviceFragment()
        }
    }

    override fun getLayoutId(): Int {
       return R.layout.fragment_menu_device_layout
    }

    override fun initView() {

        findViewById<ShapeTextView>(R.id.deviceNotifyTv).setOnClickListener {
            startActivity(NotifyOpenActivity::class.java)
        }
    }

    override fun initData() {

    }
}