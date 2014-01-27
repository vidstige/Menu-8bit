package se.vidstige.menu_8bit;

import android.app.Activity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.Menu;

public class MainActivity extends Activity {

//	private SpannableString f(CharSequence cs)
//	{
//	    SpannableString s = new SpannableString(cs);
//	    s.setSpan(new TypefaceSpan(this, "retro_computer"), 0, s.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//	    return s;
//	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Tabs8bit tabs = (Tabs8bit)findViewById(R.id.tabs);
		tabs.add("files", null);
		tabs.add("play", null);
		tabs.add("settings", null);
	}

//	private Typeface typeFace;
//	private TextView createTextView(String string) {
//		LayoutInflater inflater = LayoutInflater.from(this);
//	    TextView tv = (TextView)inflater.inflate(R.layout.tab, null);
//	    
//		if (typeFace == null)
//			typeFace = Typeface.createFromAsset(getAssets(), "fonts/retro_computer.ttf");
//		tv.setTypeface(typeFace);
//		tv.setText(string);
//		return tv; 
//	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
