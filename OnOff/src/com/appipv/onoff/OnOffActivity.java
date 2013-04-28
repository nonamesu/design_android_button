package com.appipv.onoff;

import com.appipv6.android.slipbutton.OnChangedListener;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class OnOffActivity extends Activity
{
	
	private SlipButton slipButton1;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		SlipButton slipButton = (SlipButton) findViewById(R.id.slipButton1);
		slipButton.setNowChoose(true);
		slipButton1 = (SlipButton) findViewById(R.id.slipButton2);
		slipButton1.setNowChoose(false);
		
		slipButton.setOnChangeListener(new OnChangedListener()
		{
			public void OnChanged(boolean CheckState, View v)
			{
				// TODO Auto-generated method stub
				String s;
				if(slipButton1.isNowChoose())
				{
					s="Button2打开了...";
				}else{
					s="Button2关闭了...";
				}
				if (CheckState)
					Toast.makeText(OnOffActivity.this, "Button1打开了..."+s,
							Toast.LENGTH_SHORT).show();
				else
					Toast.makeText(OnOffActivity.this, "Button1关闭了..."+s,
							Toast.LENGTH_SHORT).show();
			}
		});
	}
}