package se.vidstige.menu_8bit;

import android.app.Fragment;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Tabs8bit extends FrameLayout {

	private final LinearLayout _tabs;
	
	public Tabs8bit(Context context) {
		super(context);
		_tabs = createAndAdd();
	}
	
	public Tabs8bit(Context context, AttributeSet attrs) {
		super(context, attrs);
		_tabs = createAndAdd();
	}
	
	public Tabs8bit(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		_tabs = createAndAdd();
	}
	
	private LinearLayout createAndAdd()
	{		
		LinearLayout tabs = new LinearLayout(getContext());
		addView(tabs);
		return tabs;
	}

	public void add(CharSequence title, Fragment fragment)
	{
		_tabs.addView(createLabel(title));
	}
	
	private TextView createLabel(CharSequence text)
	{
		TextView tv = new TextView(getContext());
		tv.setText(text);
		return tv;
	}
//	
//	@Override
//	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//		setMeasuredDimension(100, 100);
//	}
//    
//	@Override
//	protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
//	}
}
