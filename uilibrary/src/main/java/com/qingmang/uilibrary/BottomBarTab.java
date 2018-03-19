package com.qingmang.uilibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;

/**
 * Created by YoKeyword on 16/6/3.
 */
public class BottomBarTab extends FrameLayout {
    private ImageView mIcon;
    private Context mContext;
    private int mTabPosition = -1;
    private int selecIcon;
    private int icon;

    public BottomBarTab(Context context, @DrawableRes int icon,int selecIcon) {
        this(context, null, icon,selecIcon);
    }

    public BottomBarTab(Context context, AttributeSet attrs, int icon,int selecIcon) {
        this(context, attrs, 0, icon,selecIcon);
    }

    public BottomBarTab(Context context, AttributeSet attrs, int defStyleAttr, int icon,int selecIcon) {
        super(context, attrs, defStyleAttr);
        this.selecIcon = selecIcon;
        this.icon = icon;
        init(context, icon);
    }

    private void init(Context context, int icon) {
        mContext = context;
        TypedArray typedArray = context.obtainStyledAttributes(new int[]{R.attr.selectableItemBackgroundBorderless});
        Drawable drawable = typedArray.getDrawable(0);
        setBackgroundDrawable(drawable);
        typedArray.recycle();

        mIcon = new ImageView(context);
        int size = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 27, getResources().getDisplayMetrics());
        LayoutParams params = new LayoutParams(size, size);
        params.gravity = Gravity.CENTER;
        mIcon.setImageResource(icon);
        mIcon.setLayoutParams(params);
//        mIcon.setColorFilter(ContextCompat.getColor(context, R.color.tab_unselect));
        addView(mIcon);
    }

    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        if (selected) {
            if (selecIcon!=0){
                mIcon.setImageResource(selecIcon);
            }
//            mIcon.setColorFilter(ContextCompat.getColor(mContext, R.color.tab_select));
        } else {
            mIcon.setImageResource(icon);
//            mIcon.setColorFilter(ContextCompat.getColor(mContext, R.color.tab_unselect));
        }
    }

    public void setTabPosition(int position) {
        mTabPosition = position;
        if (position == 0) {
            setSelected(true);
        }
    }

    public int getTabPosition() {
        return mTabPosition;
    }
}
