package se.vidstige.menu_8bit;

import se.vidstige.menu_8bit.fragments.FilesFragment;
import se.vidstige.menu_8bit.fragments.PlayFragment;
import se.vidstige.menu_8bit.fragments.SettingsFragment;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

public class MainActivity extends Activity {

	private SpannableString f(CharSequence cs)
	{
	    SpannableString s = new SpannableString(cs);
	    s.setSpan(new TypefaceSpan(this, "retro_computer"), 0, s.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
	    return s;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ActionBar bar = getActionBar();
	    bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	    

	    bar.setTitle(f("Title!"));
	    ActionBar.Tab filesTab = bar.newTab();
	    ActionBar.Tab playTab = bar.newTab();
	    ActionBar.Tab settingsTab = bar.newTab();
	    
	    filesTab.setCustomView(createTextView("Files"));
	    playTab.setCustomView(createTextView("Play"));
	    settingsTab.setCustomView(createTextView("Settings"));

	    filesTab.setTabListener(new TabNavigator(new FilesFragment()));
	    playTab.setTabListener(new TabNavigator(new PlayFragment()));
	    settingsTab.setTabListener(new TabNavigator(new SettingsFragment()));

	    bar.addTab(filesTab);
	    bar.addTab(playTab);
	    bar.addTab(settingsTab);
		
//		TextView myTextView=(TextView)findViewById(R.id.mytext);
//		Typeface typeFace=Typeface.createFromAsset(getAssets(), "fonts/retro_computer.ttf");
//		myTextView.setTypeface(typeFace);
	}

	private Typeface typeFace;
	private TextView createTextView(String string) {
		LayoutInflater inflater = LayoutInflater.from(this);
	    TextView tv = (TextView)inflater.inflate(R.layout.tab, null);
	    
		if (typeFace == null)
			typeFace = Typeface.createFromAsset(getAssets(), "fonts/retro_computer.ttf");
		tv.setTypeface(typeFace);
		tv.setText(string);
		return tv; 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	private static class TabNavigator implements ActionBar.TabListener
	{
	    private Fragment navigationTarget;

	    public TabNavigator(Fragment fragment) {
	        this.navigationTarget = fragment;
	    }

	    public void onTabReselected(Tab tab, FragmentTransaction ft) {
	    }

	    public void onTabSelected(Tab tab, FragmentTransaction ft) {
	        ft.add(R.id.fragment_container, navigationTarget, null);
	    }

	    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
	        ft.remove(navigationTarget);
	    }
	}
}
