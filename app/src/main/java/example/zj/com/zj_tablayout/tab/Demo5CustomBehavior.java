package example.zj.com.zj_tablayout.tab;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import example.zj.com.zj_tablayout.R;

/**
 * Title: Demo5CustomBehavior
 * Description:
 * Copyright:Copyright(c)2016
 * Company: 博智维讯信息技术有限公司
 * CreateTime:17/4/10  08:39
 *
 * @author 郑炯
 * @version 1.0
 */
public class Demo5CustomBehavior extends CoordinatorLayout.Behavior {
    private int headViewHeight;

    public Demo5CustomBehavior() {
    }

    public Demo5CustomBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        System.out.println("y=" + dependency.getY() + " ,top=" + dependency.getTop() + " dependency.height=" + dependency.getMeasuredHeight());
        View headView = child.findViewById(R.id.head_container);
        if (Math.abs(dependency.getY()) == 0 && headViewHeight == 0) {
            headViewHeight = headView.getMeasuredHeight();
        }
        System.out.println("headView.height=" + headView.getMeasuredHeight());
        float percent = (dependency.getMeasuredHeight() - Math.abs(dependency.getY())) / dependency.getMeasuredHeight();
        headView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, (int) (headViewHeight * percent)));
        return super.onDependentViewChanged(parent, child, dependency);
    }
}
