package se.vidstige.menu_8bit;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity {	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Tabs8bit tabs = (Tabs8bit)findViewById(R.id.tabs);
		tabs.add("files", null);
		tabs.add("play", null);
		tabs.add("settings", null);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
