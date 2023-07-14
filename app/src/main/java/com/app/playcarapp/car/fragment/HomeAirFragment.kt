package com.app.playcarapp.car.fragment

import android.os.Build
import android.view.KeyEvent
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import com.app.playcarapp.R
import com.app.playcarapp.action.TitleBarFragment
import com.app.playcarapp.car.CarHomeActivity
import timber.log.Timber

/**
 * Created by Admin
 *Date 2023/7/14
 */
class HomeAirFragment : TitleBarFragment<CarHomeActivity>(){

    companion object{
        fun getInstance() : HomeAirFragment{
            return HomeAirFragment()
        }
    }


    private var webView : WebView?= null


    override fun getLayoutId(): Int {
        return R.layout.fragment_home_air_layout
    }

    override fun initView() {
        webView = findViewById(R.id.webView)

        initWebSetting()
    }

    override fun initData() {

    }


    private fun initWebSetting() {
        val settings: WebSettings = webView!!.getSettings()
        // 允许文件访问
        settings.allowFileAccess = true
        // 允许网页定位
        settings.setGeolocationEnabled(true)
        // 允许保存密码
        //settings.setSavePassword(true);
        // 开启 JavaScript
        // 允许保存密码
        //settings.setSavePassword(true);
        // 开启 JavaScript
        settings.javaScriptEnabled = true
        // 允许网页弹对话框
        settings.javaScriptCanOpenWindowsAutomatically = true
        // 加快网页加载完成的速度，等页面完成再加载图片
        settings.loadsImagesAutomatically = true
        // 本地 DOM 存储（解决加载某些网页出现白板现象）
        settings.domStorageEnabled = true
        settings.cacheMode = WebSettings.LOAD_NO_CACHE

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // 解决 Android 5.0 上 WebView 默认不允许加载 Http 与 Https 混合内容
            settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        }

        webView?.setOnLongClickListener(View.OnLongClickListener {

            true
        })
    }


    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (event?.action == KeyEvent.KEYCODE_BACK || event?.action == KeyEvent.ACTION_DOWN) {

            if (webView?.canGoBack() == true) {
                webView?.goBack()
                return true
            } else {

                finish()
            }
        }
        return super.onKeyDown(keyCode, event)
    }

}