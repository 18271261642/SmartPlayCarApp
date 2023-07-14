package com.app.playcarapp;


import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

import androidx.annotation.NonNull;

import com.app.playcarapp.action.DebugLoggerTree;
import com.app.playcarapp.ble.ConnStatus;
import com.app.playcarapp.ble.ConnStatusService;
import com.app.playcarapp.dialog.OkHttpRetryInterceptor;
import com.app.playcarapp.http.RequestHandler;
import com.app.playcarapp.http.RequestServer;
import com.app.playcarapp.utils.LanguageUtils;
import com.app.playcarapp.utils.MmkvUtils;
import com.blala.blalable.BleApplication;
import com.blala.blalable.BleOperateManager;
import com.hjq.http.EasyConfig;
import com.hjq.http.config.IRequestInterceptor;
import com.hjq.http.model.HttpHeaders;
import com.hjq.http.model.HttpParams;
import com.hjq.http.request.HttpRequest;
import com.hjq.toast.ToastUtils;
import com.tencent.mmkv.MMKV;
import org.litepal.LitePal;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import timber.log.Timber;

/**
 * Created by Admin
 * Date 2023/1/4
 * @author Admin
 */
public class BaseApplication extends BleApplication {


    /**连接状态枚举**/
    private ConnStatus connStatus = ConnStatus.NOT_CONNECTED;
    private static BaseApplication baseApplication;

    private ConnStatusService connStatusService;

    private String logStr;

    @Override
    public void onCreate() {
        super.onCreate();

        initApp();


    }


    public static BaseApplication getBaseApplication(){
        return baseApplication;
    }

    public BleOperateManager getBleOperate(){
        return BleOperateManager.getInstance();
    }

    private void initApp(){
        baseApplication = this;
        //log
        Timber.plant(new DebugLoggerTree());
        //数据库
        LitePal.initialize(this);
        //Toast
        ToastUtils.init(this);
        //mmkv
        MMKV.initialize(this);
        MmkvUtils.initMkv();

        initNet();

        Intent intent = new Intent(this, ConnStatusService.class);
        this.bindService(intent,serviceConnection, Context.BIND_AUTO_CREATE);

    }


    private void initNet(){
        OkHttpRetryInterceptor.Builder builder = new OkHttpRetryInterceptor.Builder();
        builder.build();
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(0, TimeUnit.SECONDS)
                .readTimeout(0,TimeUnit.SECONDS)
                .writeTimeout(0,TimeUnit.SECONDS)
//                .addInterceptor(new OkHttpRetryInterceptor(builder))
                .build();

        //是否是中文
        boolean isChinese = LanguageUtils.isChinese();
        EasyConfig.with(okHttpClient)
                // 是否打印日志
                .setLogEnabled(BuildConfig.DEBUG)
                // 设置服务器配置
                .setServer(new RequestServer())
                // 设置请求处理策略
                .setHandler(new RequestHandler(this))
                // 设置请求重试次数
                .setRetryCount(3)
                .setRetryCount(3)
                .setRetryTime(1000)
                // 添加全局请求参数
                //.addParam("token", "6666666")
                // 添加全局请求头
                //.addHeader("time", "20191030")
                .setInterceptor(new IRequestInterceptor() {
                    @Override
                    public void interceptArguments(@NonNull HttpRequest<?> httpRequest, @NonNull HttpParams params, @NonNull HttpHeaders headers) {
                        headers.put("Accept-Language", LanguageUtils.isChinese() ? "zh-CN" : "en");
                    }
                })
                // 启用配置
                .into();
    }

    public ConnStatusService getConnStatusService(){
        return connStatusService;
    }


    private final ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            connStatusService =( (ConnStatusService.ConnBinder)iBinder).getService();
            Timber.e("--------绑定服务="+(connStatusService == null));
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            connStatusService = null;
        }
    };


    //获取连接状态
    public ConnStatus getConnStatus(){
        return connStatus;
    }

    //设置连接状态
    public void setConnStatus(ConnStatus connStatus){
        this.connStatus = connStatus;
    }


    public String getLogStr() {
        String log = getBleOperate().getLog();
        return log;
    }

    private StringBuffer stringBuffer  = new StringBuffer();
    public void clearLog(){
        stringBuffer.delete(0,stringBuffer.length());
    }

    public void setLogStr(String logStr) {
        stringBuffer.append(logStr+"\n");
    }

    public String getAppLog(){
        return stringBuffer.toString();
    }
}
