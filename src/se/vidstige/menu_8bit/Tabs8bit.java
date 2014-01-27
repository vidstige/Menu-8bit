package se.vidstige.menu_8bit;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Tabs8bit extends FrameLayout {

	private final LinearLayout _tabs;
	private Typeface typeFace;
	
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
		TextView tv = createTextView(title);
		setMargins(tv, 16, 4, 16, 4);
		_tabs.addView(tv);
	}
	
	private void setMargins(View v, int left, int top, int right, int bottom)
	{
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		lp.setMargins(left, top, right, bottom);
		v.setLayoutParams(lp);
	}
	
	private TextView createTextView(CharSequence text)
	{
		TextView tv = new TextView(getContext());
		tv.setText(text);
		
		if (typeFace == null)
			typeFace = Typeface.createFromAsset(getContext().getAssets(), "fonts/retro_computer.ttf");
		tv.setTypeface(typeFace);
		
		return tv;
	}	
}
