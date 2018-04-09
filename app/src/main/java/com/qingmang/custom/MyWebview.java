package com.qingmang.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;

import com.qingmang.baselibrary.utils.LogManager;

/**
 * Created by xiejingbao on 2018/3/30.
 */

public class MyWebview extends WebView {
    private ScrollInterface scrollInterface;
    int lastX = -1;
    int lastY = -1;
    private boolean isTop;

    public void setScrollInterface(ScrollInterface scrollInterface) {
        this.scrollInterface = scrollInterface;
    }

    public MyWebview(Context context) {
        this(context,null);
    }

    public MyWebview(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyWebview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        LogManager.i("getScrollY"+getScrollY());
//        getScaleY()
        if(getScrollY()==0){
            isTop = true;
            getParent().requestDisallowInterceptTouchEvent(false);
        }else {
            isTop = false;
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        return false;

//        int x = (int) ev.getRawX();
//        int y = (int) ev.getRawY();
//        int dealtX = 0;
//        int dealtY = 0;
//
//        switch (ev.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                dealtX = 0;
//                dealtY = 0;
//                // 保证子View能够接收到Action_move事件
//                getParent().requestDisallowInterceptTouchEvent(true);
////                requestDisallowInterceptTouchEvent(true);
//                break;
//            case MotionEvent.ACTION_MOVE:
//                dealtX += Math.abs(x - lastX);
//                dealtY += Math.abs(y - lastY);
////                Log.i("--x--", "dealtX:=" + dealtX);
////                Log.i("---y--", "dealtY:=" + dealtY);
//                // 这里是够拦截的判断依据是左右滑动，读者可根据自己的逻辑进行是否拦截
//                if (dealtX >= dealtY) {
//                    getParent().requestDisallowInterceptTouchEvent(false);
//                } else {
//                    if(isTop){
//                        LogManager.i(isTop+"------");
//                        getParent().requestDisallowInterceptTouchEvent(false);
//                        return false;
//                    }
//
//                }
//                lastX = x;
//                lastY = y;
//
//
//                break;
//            case MotionEvent.ACTION_UP:
//                break;
//        }
//
//
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
                int x = (int) ev.getRawX();
        int y = (int) ev.getRawY();
        int dealtX = 0;
        int dealtY = 0;

        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                dealtX = 0;
                dealtY = 0;
                // 保证子View能够接收到Action_move事件
                getParent().requestDisallowInterceptTouchEvent(true);
//                requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
//                dealtX += Math.abs(x - lastX);
//                dealtY += Math.abs(y - lastY);
////                Log.i("--x--", "dealtX:=" + dealtX);
////                Log.i("---y--", "dealtY:=" + dealtY);
//                // 这里是够拦截的判断依据是左右滑动，读者可根据自己的逻辑进行是否拦截
//                if (dealtX >= dealtY) {
//                    getParent().requestDisallowInterceptTouchEvent(false);
//                } else {
//                    if(isTop){
//                        LogManager.i(isTop+"------");
//                        getParent().requestDisallowInterceptTouchEvent(false);
//                        return false;
//                    }
//
//                }
//                lastX = x;
//                lastY = y;
                //在MOVE事件中，我们确定两种情况Scroll是需要ScrollView来执行
                //如果WebView中的内容滑到顶部，这时就由ScrollView来执行
                //Scroll动作。如果WebView中的内容滑到底部，这时就由
                //ScrollView来执行Scroll动作。其他情况Scroll动作都由WebView
                //来执行。
                if (getScrollY()==0) {     //是否滑到顶部
                    getParent().getParent().requestDisallowInterceptTouchEvent(false);
                    if(null!=scrollInterface)
                    scrollInterface.onTop();
                }else
                {
                    getParent().getParent().requestDisallowInterceptTouchEvent(true);

                }



                break;
            case MotionEvent.ACTION_UP:
                break;
        }

        return super.onTouchEvent(ev);
    }


    public interface ScrollInterface {

        public void onTop() ;
    }
}
