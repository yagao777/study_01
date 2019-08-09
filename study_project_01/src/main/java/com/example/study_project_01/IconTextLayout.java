package com.example.study_project_01;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class IconTextLayout extends RelativeLayout {

    private ImageView mIvIcon;
    private TextView mTvContent, mTvRight;


    public IconTextLayout(Context context) {
        this(context, null);
    }

    public IconTextLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public IconTextLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.view_icon_text_more, this, true);
        mIvIcon = findViewById(R.id.iv_icon);
        mTvContent = findViewById(R.id.tv_content);
        mTvRight = findViewById(R.id.tv_right);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.IconTextLayout);
        int icon = typedArray.getResourceId(R.styleable.IconTextLayout_icon, 0);
        if (icon != 0) {
            mIvIcon.setImageResource(icon);
            mIvIcon.setVisibility(VISIBLE);
        }

        float density = getResources().getDisplayMetrics().density;

        String content = typedArray.getString(R.styleable.IconTextLayout_contentText);
        int contentSize = (int) typedArray.getDimension(R.styleable.IconTextLayout_contentTextSize, 15 * density);
        if (!TextUtils.isEmpty(content)) {
            mTvContent.setText(content);
            mTvContent.setTextSize(TypedValue.COMPLEX_UNIT_PX, contentSize);
        }
        String right = typedArray.getString(R.styleable.IconTextLayout_rightText);
        int rightSize = (int) typedArray.getDimension(R.styleable.IconTextLayout_rightTextSize, 15 * density);
        if (!TextUtils.isEmpty(right)) {
            mTvRight.setText(right);
            mTvRight.setTextSize(TypedValue.COMPLEX_UNIT_PX, rightSize);
        }
        boolean showRightArrow = typedArray.getBoolean(R.styleable.IconTextLayout_showRightArrow, true);
        if (!showRightArrow) {
            mTvRight.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        }
        typedArray.recycle();
    }

    public void setRightText(int rightTextId) {
        mTvRight.setText(rightTextId);
    }

    public void setRightText(String text) {
        mTvRight.setText(text);
    }

    //设置红点
    public void setRedotRight(boolean showRedDot) {
        if (showRedDot) {
            Drawable drawable = getResources().getDrawable(R.drawable.ic_message_ico);
            mTvContent.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);
        } else {
            mTvContent.setCompoundDrawables(null, null, null, null);
        }
    }
}
