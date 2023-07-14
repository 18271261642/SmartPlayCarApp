package com.app.playcarapp.car.fragment

import android.os.Build
import com.app.playcarapp.R
import com.app.playcarapp.action.TitleBarFragment
import com.app.playcarapp.adapter.OnItemCheckedListener
import com.app.playcarapp.car.CarFaultNotifyActivity
import com.app.playcarapp.car.CarHomeActivity
import com.app.playcarapp.car.view.HomeBottomCheckView
import com.app.playcarapp.widget.CusVerticalScheduleView
import com.app.playcarapp.widget.CusVerticalTextScheduleView
import com.app.playcarapp.widget.VerticalSeekBar
import com.app.playcarapp.widget.VerticalSeekBar.OnSeekBarChangeListener

/**
 * Created by Admin
 *Date 2023/7/14
 */
class HomeControlFragment : TitleBarFragment<CarHomeActivity>() {


    private var cusVerticalView : CusVerticalScheduleView ?= null
    private var cusVerticalTxtView : CusVerticalTextScheduleView ?= null
    private var homeLeftAirSeekBar : VerticalSeekBar?= null

    private var homeBottomCheckView : HomeBottomCheckView ?= null

    companion object{
        fun getInstance() : HomeControlFragment{
            return HomeControlFragment()
        }
    }


    override fun getLayoutId(): Int {
        return R.layout.fragment_home_control_layut
    }

    override fun initView() {
        homeLeftAirSeekBar = findViewById(R.id.homeLeftAirSeekBar)
        cusVerticalTxtView= findViewById(R.id.cusVerticalTxtView)
        cusVerticalView = findViewById(R.id.cusVerticalView)
        homeBottomCheckView = findViewById(R.id.homeBottomCheckView)

        homeBottomCheckView?.setOnItemCheck(object : OnItemCheckedListener{
            override fun onItemCheck(position: Int, isChecked: Boolean) {
               if(position == 2){
                   startActivity(CarFaultNotifyActivity::class.java)
               }
            }

        })

        cusVerticalView?.allScheduleValue = 150F


        cusVerticalTxtView?.allScheduleValue = 150F


        homeLeftAirSeekBar?.max = 150
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            homeLeftAirSeekBar?.min = 0
        }
        homeLeftAirSeekBar?.progress = 100
        showSchedule(100)
        homeLeftAirSeekBar?.setOnSeekBarChangeListener(object : OnSeekBarChangeListener{
            override fun onProgressChanged(VerticalSeekBar: VerticalSeekBar?, progress: Int) {
                showSchedule(progress)
            }

            override fun onStartTrackingTouch(VerticalSeekBar: VerticalSeekBar?) {

            }

            override fun onStopTrackingTouch(VerticalSeekBar: VerticalSeekBar?) {

            }

        })
    }

    private fun showSchedule(value : Int){
        cusVerticalView?.setCurrScheduleValue(value.toFloat())
        cusVerticalTxtView?.setCurrScheduleValue(value)
    }

    override fun initData() {

    }
}