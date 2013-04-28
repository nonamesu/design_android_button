/**   
*    
* 项目名称：OnOff   
* 类名称：SwitchButton   
* 类描述：   
* 创建人：suzhenpeng  
* 创建时间：2013-3-30 下午7:23:48   
* 修改人：suzhenpeng 
* 修改时间：2013-3-30 下午7:23:48   
* 修改备注：   
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
