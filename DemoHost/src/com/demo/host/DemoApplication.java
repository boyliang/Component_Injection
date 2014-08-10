package com.demo.host;

import android.app.Application;
import android.util.Log;

public final class DemoApplication extends Application {
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		Log.i("TTT", getPackageName() + " starts");
	}
}
