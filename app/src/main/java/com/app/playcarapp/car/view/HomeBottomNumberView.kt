package com.app.playcarapp.car.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.app.playcarapp.R

/**
 * Created by Admin
 *Date 2023/7/18
 */
class HomeBottomNumberView : LinearLayout {


    //1
    private var bot1Layout : FrameLayout ?= null
    private var botBg1Img : ImageView ?= null
    private var botAboveImg1 : ImageView ?= null


    private var bot2Layout : FrameLayout ?= null
    private var botBg2Img : ImageView ?= null
    private var botAboveImg2 : ImageView ?= null

    private var bot3Layout : FrameLayout ?= null
    private var botBg3Img : ImageView ?= null
    private var botAboveImg3 : ImageView ?= null

    private var bot4Layout : FrameLayout ?= null
    private var botBg4Img : ImageView ?= null
    private var botAboveImg4 : ImageView ?= null


    constructor(context: Context) : super (context){
        initViews(context)
    }


    constructor(context: Context, attribute : AttributeSet) : super (context,attribute){
        initViews(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super (context, attrs, defStyleAttr){
        initViews(context)
    }


    private fun initViews(context: Context){
        val view = LayoutInflater.from(context).inflate(R.layout.view_car_home_bottom_number_layout,this,true)
        findVies(view)


        bot1Layout?.setOnClickListener {
            setClickIndex(0)
        }
        bot2Layout?.setOnClickListener {
            setClickIndex(1)
        }
        bot3Layout?.setOnClickListener {
            setClickIndex(2)
        }
        bot4Layout?.setOnClickListener {
            setClickIndex(3)
        }
    }


    private fun findVies(v : View){
        bot1Layout = v.findViewById(R.id.bot1Layout)
        bot2Layout = v.findViewById(R.id.bot2Layout)
        bot3Layout = v.findViewById(R.id.bot3Layout)
        bot4Layout = v.findViewById(R.id.bot4Layout)

        botBg1Img = v.findViewById(R.id.botBg1Img)
        botBg2Img = v.findViewById(R.id.botBg2Img)
        botBg3Img = v.findViewById(R.id.botBg3Img)
        botBg4Img = v.findViewById(R.id.botBg4Img)


        botAboveImg1 = v.findViewById(R.id.botAboveImg1)
        botAboveImg2 = v.findViewById(R.id.botAboveImg2)
        botAboveImg3 = v.findViewById(R.id.botAboveImg3)
        botAboveImg4 = v.findViewById(R.id.botAboveImg4)



    }



    private fun clearAllClick(){
        botBg1Img?.visibility = View.INVISIBLE
        botBg2Img?.visibility = View.INVISIBLE
        botBg3Img?.visibility = View.INVISIBLE
        botBg4Img?.visibility = View.INVISIBLE


        botAboveImg1?.visibility = View.INVISIBLE
        botAboveImg2?.visibility = View.INVISIBLE
        botAboveImg3?.visibility = View.INVISIBLE
        botAboveImg4?.visibility = View.INVISIBLE

    }


    //选中
    private fun setClickIndex(index : Int){
        clearAllClick()
        botBg1Img?.visibility = if(index==0) View.VISIBLE else View.INVISIBLE
        botBg2Img?.visibility =  if(index==1) View.VISIBLE else View.INVISIBLE
        botBg3Img?.visibility =  if(index==2) View.VISIBLE else View.INVISIBLE
        botBg4Img?.visibility = if(index==3) View.VISIBLE else View.INVISIBLE


        botAboveImg1?.visibility = if(index==0) View.VISIBLE else View.INVISIBLE
        botAboveImg2?.visibility =if(index==1) View.VISIBLE else View.INVISIBLE
        botAboveImg3?.visibility =if(index==2) View.VISIBLE else View.INVISIBLE
        botAboveImg4?.visibility = if(index==3) View.VISIBLE else View.INVISIBLE
    }
}