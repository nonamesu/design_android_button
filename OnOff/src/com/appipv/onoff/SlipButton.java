package com.appipv.onoff;

import com.appipv.onoff.R;
import com.appipv6.android.slipbutton.SlipClickButtonTpl;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.util.AttributeSet;

public class SlipButton extends SlipClickButtonTpl
{
	public SlipButton(Context context)
	{
		super(context);
		// TODO Auto-generated constructor stub
	}

	public SlipButton(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public SlipButton(Context context, AttributeSet attrs, int defStyle)
	{
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	
	public void init()
	{
		// TODO Auto-generated method stub
		
		bg_on=BitmapFactory.decodeResource(getResources(), R.drawable.on);
		bg_off=BitmapFactory.decodeResource(getResources(), R.drawable.off);
		bg_myButton=BitmapFactory.decodeResource(getResources(), R.drawable.my_btn);
		
		int tmp=bg_off.getWidth()/2;
		btn_On=new Rect(tmp, 0, bg_myButton.getWidth()+tmp, bg_myButton.getHeight());
		btn_Off=new Rect(bg_off.getWidth()-tmp-bg_myButton.getWidth(), 0, bg_off.getWidth()-tmp, bg_myButton.getHeight());
		setOnTouchListener(this);
		
	}
	
}
