/**   
*    
* ��Ŀ���ƣ�OnOff   
* �����ƣ�SwitchButton   
* ��������   
* �����ˣ�suzhenpeng  
* ����ʱ�䣺2013-3-30 ����7:23:48   
* �޸��ˣ�suzhenpeng 
* �޸�ʱ�䣺2013-3-30 ����7:23:48   
* �޸ı�ע��   
* @version    
*    
*/
package com.appipv.onoff;
import com.appipv.onoff.R;
import com.appipv6.android.slipbutton.SlipClickButtonTpl;

import android.content.Context;
import android.util.AttributeSet;

/**
 * @author Administrator
 *
 */
public class SwitchButton extends SlipClickButtonTpl
{

	public SwitchButton(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public SwitchButton(Context context)
	{
		super(context);
		// TODO Auto-generated constructor stub
	}

	public SwitchButton(Context context, AttributeSet attrs, int defStyle)
	{
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void init()
	{
		// TODO Auto-generated method stub
		this.buttonType=CLICKBUTTON;
		this.btnLocationType=OKRIGHT;
		bg_on=getBitmap(R.drawable.switchson);
		bg_off=getBitmap(R.drawable.switchsoff);
		bg_myButton=getBitmap(R.drawable.switchbutton);
			
	}
	
}
