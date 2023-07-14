package com.app.playcarapp.car.fragment

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.app.playcarapp.R
import com.app.playcarapp.action.TitleBarFragment
import com.app.playcarapp.car.CarSysSetActivity

/**
 * 最低行驶气压保护
 * Created by Admin
 *Date 2023/7/14
 */
class CarLowestAirFragment : TitleBarFragment<CarSysSetActivity>() {


    companion object{
        fun getInstance() : CarLowestAirFragment{
            return CarLowestAirFragment()
        }
    }

    private var carAddImgView : ImageView ?= null
    private var carAirAddTv : TextView ?= null
    private var carRemoveImgView : ImageView ?= null

    private var carRearAddImgView : ImageView ?= null
    private var carRearAirAddTv : TextView ?= null
    private var carRearRemoveImgView : ImageView ?= null

    override fun getLayoutId(): Int {
        return R.layout.fragment_car_lowest_air
    }

    override fun initView() {
        carAddImgView = findViewById(R.id.carAddImgView)
        carAirAddTv = findViewById(R.id.carAirAddTv)
        carRemoveImgView = findViewById(R.id.carRemoveImgView)
        carRearAddImgView = findViewById(R.id.carRearAddImgView)
        carRearAirAddTv = findViewById(R.id.carRearAirAddTv)
        carRearRemoveImgView = findViewById(R.id.carRearRemoveImgView)

        carAddImgView?.setOnClickListener(this)
        carRemoveImgView?.setOnClickListener(this)
        carRearAddImgView?.setOnClickListener(this)
        carRearRemoveImgView?.setOnClickListener(this)
    }

    override fun initData() {

    }

    override fun onClick(view: View?) {
        super.onClick(view)

        val id = view?.id

        when (id){
            R.id.carAddImgView->{
                frontAddOrRemove(true)
            }
            R.id.carRemoveImgView->{
                frontAddOrRemove(false)
            }
            R.id.carRearAddImgView->{
                rearAddOrRemove(true)
            }

            R.id.carRearRemoveImgView->{
                rearAddOrRemove(false)
            }
        }
    }

    private var frontCountNumber = 30

    private fun frontAddOrRemove(isAdd : Boolean){
        carAirAddTv?.text = if(isAdd) frontCountNumber--.toString() else frontCountNumber++.toString()
    }

    var rearCountNumber = 30
    private fun rearAddOrRemove(isAdd : Boolean){
        carRearAirAddTv?.text = if(isAdd) rearCountNumber--.toString() else rearCountNumber++.toString()
    }
}