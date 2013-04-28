/**   
 *    
 * �����ƣ�SlipButtonTpl   
 * ��������   �Զ���ť��ʵ�ֻ�����ť�͵����ť������ʵ��init��������ʼ���ڲ���Դ
 * �����ˣ�suzhenpeng  
 * ����ʱ�䣺2013-3-30 ����7:34:38   
 * �޸��ˣ�suzhenpeng 
 * �޸�ʱ�䣺2013-3-30 ����7:34:38   
 * @version  1.0 
 *    
 */
package com.appipv6.android.slipbutton;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/**
 * @author Administrator �Զ��尴ť�ӿ�
 */
public abstract class SlipClickButtonTpl extends View implements OnTouchListener
{
	/**
	 * @Fields nowChoose :��ǰ��ť״̬
	 */
	public boolean nowChoose = false;
	/**
	 * @Fields onSlip : �û��Ƿ��ڻ���
	 */
	public boolean onSlip = false;
	/**
	 * @Fields downX : ����ʱ��X����ʱ��X
	 */
	public float downX, nowX;
	/**
	 * @Fields btn_On : �򿪺͹ر�״̬�µģ��α��Rect
	 */
	public Rect btn_On, btn_Off;
	/**
	 * @Fields isChgLsnOn :�Ƿ�ע�����¼��ӿ�
	 */
	public boolean isChgLsnOn = false;
	/**
	 * @Fields ChgLsn :�¼��ӿ�
	 */
	public OnChangedListener ChgLsn;
	/**
	 * @Fields bg_on,bg_off,slip_btn : �򿪱������رձ�������ť����
	 */
	public Bitmap bg_on, bg_off, bg_myButton;
	/**
	 * @Fields SLIPBUTTON : ������ť
	 */
	public static String SLIPBUTTON = "slipbutton";
	/**
	 * @Fields ONCLICKBUTTON : �����ť
	 */
	public static String CLICKBUTTON = "clickbutton";
	/**
	 * @Fields buttonType : ��ť����
	 */
	public String buttonType = SLIPBUTTON;
	
	/** 
	* @Fields OKLEFT : OK�������
	*/ 
	public static String OKLEFT ="okleft";
	/** 
	* @Fields OKRIGHT : OK�����Ҳ�
	*/ 
	public static String OKRIGHT ="okright";

	/** 
	* @Fields btnLocationType : ȷ�ϼ���λ�ã�Ĭ��Ϊ�գ���Ҫ�û����ж���
	*/ 
	public String btnLocationType="null";
	
	public SlipClickButtonTpl(Context context, AttributeSet attrs, int defStyle)
	{
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		this.setOnTouchListener(this);
		init();
		addLocationRect();
	}

	public SlipClickButtonTpl(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		// TODO Auto-generated constructor stub
		this.setOnTouchListener(this);
		init();
		addLocationRect();
	}

	public SlipClickButtonTpl(Context context)
	{
		super(context);
		// TODO Auto-generated constructor stub
		this.setOnTouchListener(this);
		init();
		addLocationRect();
	}
	/**
	 * @Title: init
	 * @Description: �����ʼ����Դ Rect btn_On,btn_Off;Bitmap bg_on,bg_off,slip_btn;
	 * @param
	 * @return void
	 * @throws
	 */
	abstract public void init();

	/** 
	* @Title: addLocationRect 
	* @Description:�û�ѡ��ȷ�ϼ�λ�ú���Զ����λ�÷���
	* @param 
	* @return void
	* @throws 
	*/ 
	public void addLocationRect()
	{
		if(btnLocationType.equals(OKLEFT))
		{
			btn_On=new Rect(0, 0, bg_myButton.getWidth(), bg_myButton.getHeight());
			btn_Off=new Rect(bg_off.getWidth()-bg_myButton.getWidth(), 0, bg_off.getWidth(), bg_myButton.getHeight());
			
		}else if(btnLocationType.equals(OKRIGHT))
		{
			btn_Off=new Rect(0, 0, bg_myButton.getWidth(), bg_myButton.getHeight());
			btn_On=new Rect(bg_off.getWidth()-bg_myButton.getWidth(), 0, bg_off.getWidth(), bg_myButton.getHeight());
		}
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
	{
		// TODO Auto-generated method stub
		setMeasuredDimension(bg_on.getWidth(), bg_on.getHeight());
	}

	@Override
	public void onDraw(Canvas canvas)
	{
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		Matrix matrix = new Matrix();
		Paint paint = new Paint();
		if (buttonType.equals(SLIPBUTTON))
		{
			float x;

			if (onSlip)
			{
				if (nowX >= bg_on.getWidth())
				{
					x = bg_on.getWidth() - bg_myButton.getWidth() / 2;
				} else
				{
					x = nowX - bg_myButton.getWidth() / 2;
				}
			} else
			{
				if (nowChoose)
				{
					x = btn_On.left;
				} else
				{
					x = btn_Off.left;
				}
			}

			if (nowX < (bg_on.getWidth() / 2))
			{
				canvas.drawBitmap(bg_off, matrix, paint);
			} else
			{
				canvas.drawBitmap(bg_on, matrix, paint);
			}

			if (x < 0)
			{
				x = 0;
			} else if (x > bg_on.getWidth() - bg_myButton.getWidth())
			{
				x = bg_on.getWidth() - bg_myButton.getWidth();
			}

			canvas.drawBitmap(bg_myButton, x, 0, paint);
		} else if (buttonType.equals(CLICKBUTTON))
		{
			if (nowChoose)
			{
				canvas.drawBitmap(bg_on, matrix, paint);
				canvas.drawBitmap(bg_myButton, btn_On.left, 0, paint);
			} else
			{
				canvas.drawBitmap(bg_off, matrix, paint);
				canvas.drawBitmap(bg_myButton,btn_Off.left , 0, paint);
			}
		}
	}

	/**
	 * ��Ļ�����¼�
	 */
	public boolean onTouch(View v, MotionEvent event)
	{
		// TODO Auto-generated method stub
		if (buttonType.equals(SLIPBUTTON))
		{
			switch (event.getAction())
			{
			case MotionEvent.ACTION_MOVE:
				nowX = event.getX();
				break;
			case MotionEvent.ACTION_DOWN:
				if (event.getX() > bg_on.getWidth()
						|| event.getY() > bg_on.getHeight())
				{
					return false;
				}
				onSlip = true;
				downX = event.getX();
				nowX = downX;
				break;
			case MotionEvent.ACTION_UP:
				onSlip = false;
				boolean lastChoose = nowChoose;
				if (event.getX() >= (bg_on.getWidth() / 2))
				{
					nowChoose = true;
				} else
				{
					nowChoose = false;
				}
				if (isChgLsnOn && (lastChoose != nowChoose))
				{
					ChgLsn.OnChanged(nowChoose, v);
				}

				break;
			default:
				break;
			}
		} else if (buttonType.equals(CLICKBUTTON))
		{
			if(event.getAction()==MotionEvent.ACTION_DOWN)
			{
				if(nowChoose)
				{
					nowChoose=false;
				}else{
					nowChoose=true;
				}
				if (isChgLsnOn)
				{
					ChgLsn.OnChanged(nowChoose, v);
				}
				
			}
		}
		invalidate();
		return true;
	}

	/** 
	* @Title: setOnChangeListener 
	* @Description:��ȡ�ı�ʱ��ĺ���
	* @param @param l
	* @return void
	* @throws 
	*/ 
	public void setOnChangeListener(OnChangedListener l)
	{
		isChgLsnOn = true;
		ChgLsn = l;
	}

	/** 
	* @Title: isNowChoose 
	* @Description:��ȡ��ǰ��ť״̬
	* @param @return
	* @return boolean
	* @throws 
	*/ 
	public boolean isNowChoose()
	{
		return nowChoose;
	}

	/** 
	* @Title: setNowChoose 
	* @Description:���õ�ǰ��ť״̬
	* @param @param nowChoose
	* @return void
	* @throws 
	*/ 
	public void setNowChoose(boolean nowChoose)
	{
		this.nowChoose = nowChoose;
		if(nowChoose)
		{
			nowX = btn_On.left;
		}else{
			nowX = btn_Off.left;
		}
		invalidate();
	}
	
	/** 
	* @Title: getBitmap 
	* @Description: ��ȡͼƬ��Դ
	* @param @param ͼƬIDid
	* @return Bitmap
	* @throws 
	*/ 
	public Bitmap getBitmap(int id)
	{
		return BitmapFactory.decodeResource(getResources(), id);
	}

}