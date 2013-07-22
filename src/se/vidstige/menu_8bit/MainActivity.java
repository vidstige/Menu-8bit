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

	    filesTab.setTabListener(new TabListener<FilesFragment>(this, "files", FilesFragment.class));
	    playTab.setTabListener(new TabListener<PlayFragment>(this, "play", PlayFragment.class));
	    settingsTab.setTabListener(new TabListener<SettingsFragment>(this, "settings", SettingsFragment.class));

	    bar.addTab(filesTab);
	    bar.addTab(playTab);
	    bar.addTab(settingsTab);
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
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	private class TabListener<T extends Fragment> implements ActionBar.TabListener {
	    private Fragment fragment;
	    private final Activity activity;
	    private final String tag;
	    private final Class<T> clazz;

	    /** Constructor used each time a new tab is created.
	      * @param activity  The host Activity, used to instantiate the fragment
	      * @param tag  The identifier tag for the fragment
	      * @param clz  The fragment's Class, used to instantiate the fragment
	      */
	    public TabListener(Activity activity, String tag, Class<T> clazz) {
	        this.activity = activity;
	        this.tag = tag;
	        this.clazz = clazz;
	    }

	    /* The following are each of the ActionBar.TabListener callbacks */
	    public void onTabSelected(Tab tab, FragmentTransaction ft) {
	        // Check if the fragment is already initialized
	        if (fragment == null) {
	            // If not, instantiate and add it to the activity
	        	fragment = Fragment.instantiate(activity, clazz.getName());
	            ft.add(android.R.id.content, fragment, tag);
	        } else {
	            // If it exists, simply attach it in order to show it
	            ft.attach(fragment);
	        }
	    }

	    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
	        if (fragment != null) {
	            // Detach the fragment, because another one is being attached
	            ft.detach(fragment);
	        }
	    }

	    public void onTabReselected(Tab tab, FragmentTransaction ft) {
	        // User selected the already selected tab. Usually do nothing.
	    }
	}
}
