package com.app.playcarapp.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;

import com.app.playcarapp.R;
import com.bonlala.widget.view.SwitchButton;

/**
 * Created by Admin
 * Date 2022/9/15
 * @author Admin
 */
public class CheckButtonView extends LinearLayout {

    private TextView leftTv;
    private SwitchButton switchButton;
    private ImageView lefImgView;

    /**是否显示右侧图片及显示的图片**/
    private boolean isShowLeftImg;

    /**右侧图片**/
    private int rightImage;

    /**设置左侧的图片**/
    private int leftImgResource;

    /**是否显示右侧返回按钮**/
    private boolean isShowRightImg;
    private ImageView rightImg;

    /**设置左侧的文字描述**/
    private String leftTxt;


    public CheckButtonView(Context context) {
        super(context);

    }

    public CheckButtonView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initAttrs(context,attrs);
    }

    public CheckButtonView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(context,attrs);
    }


    private void initAttrs(Context context,AttributeSet attributeSet){
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet,R.styleable.CheckButtonView);
        isShowLeftImg = typedArray.getBoolean(R.styleable.CheckButtonView_is_show_left_img,false);
        leftImgResource = typedArray.getResourceId(R.styleable.CheckButtonView_left_img_resource,R.mipmap.ic_launcher);
        leftTxt = typedArray.getString(R.styleable.CheckButtonView_left_txt_name);
        isShowRightImg = typedArray.getBoolean(R.styleable.CheckButtonView_right_back_img,false);
        rightImage = typedArray.getResourceId(R.styleable.CheckButtonView_right_image,0);


        typedArray.recycle();

        initViews(context);
    }


    private void initViews(Context context){
        View view = LayoutInflater.from(context).inflate(R.layout.layout_check_btn_layout,this,true);
        leftTv = view.findViewById(R.id.leftTitleTv);
        switchButton = view.findViewById(R.id.rightCheckBtn);
        lefImgView = view.findViewById(R.id.leftImgView);
        rightImg = view.findViewById(R.id.rightBackImgView);

        lefImgView.setVisibility(isShowLeftImg ? View.VISIBLE : View.GONE);
        if(leftImgResource !=0){
            lefImgView.setImageResource(leftImgResource);
        }

        if(leftTxt != null){
            leftTv.setText(leftTxt);
        }

        if(rightImage != 0){
            rightImg.setImageResource(rightImage);
        }

        rightImg.setVisibility(isShowRightImg ? View.VISIBLE : View.GONE);

    }


    //设置左侧标题
    public void setLeftTitle(String title){
        if(leftTv == null)
            return;
        leftTv.setText(title);
    }

    /**
     * 设置图片
     */
    public void setLeftImgResource(int resource){
        if(lefImgView != null){
            lefImgView.setImageResource(resource);
        }
    }


    //设置开关状态
    public void setCheckStatus(boolean isChekc){
        if(switchButton == null)
            return;
        switchButton.setChecked(isChekc);
    }

    /**是否显示右侧的返回图片**/
    public void setIsShowRightImg(boolean isShow){
        if(rightImg != null){
            rightImg.setVisibility(isShow ? View.VISIBLE : View.INVISIBLE);
        }

    }

    public void setCheckListener(SwitchButton.OnCheckedChangeListener onCheckedChangeListener){
        if(switchButton == null)
            return;
        switchButton.setOnCheckedChangeListener(onCheckedChangeListener) ;
    }


    public interface OnCheckListener{
        void onChecked(SwitchButton button,boolean checked);
    }
}
