package com.uk.mediumui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

/**
 * This viewpager was created to deal with the height issues the viewpager has when put
 * in a scrollview/nested scrollview.
 */

public class CustomViewPager extends ViewPager {
	public CustomViewPager(@NonNull Context context) {
		super(context);
	}
	
	public CustomViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int currentPagePosition = 0;
		try {
			
			View child = getChildAt(currentPagePosition);
			
			if (child != null) {
				
				child.measure(widthMeasureSpec,View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED));
				int h = child.getMeasuredHeight();
				heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(h,View.MeasureSpec.EXACTLY);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}
}

