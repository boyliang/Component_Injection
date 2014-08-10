package com.demo.inject;

import java.lang.reflect.Method;
import java.util.Timer;
import java.util.TimerTask;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

public final class DemoContentProvider extends ContentProvider {

	@Override
	public int delete(Uri arg0, String arg1, String[] arg2) {
		return 0;
	}

	@Override
	public String getType(Uri arg0) {
		return null;
	}

	@Override
	public Uri insert(Uri arg0, ContentValues arg1) {
		return null;
	}

	@Override
	public boolean onCreate() {
		Context context = getContext();
		Log.i("TTT", context.getPackageName() + " starts.");
		return false;
	}

	@Override
	public Cursor query(Uri arg0, String[] arg1, String arg2, String[] arg3, String arg4) {

		final Timer timer = new Timer("demo");
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				try {
					Log.i("TTT", ">>>>>>>>>>>>>I am in, I am a bad boy!!!!<<<<<<<<<<<<<<\n");
					//Class<?> MainActivity_class = Class.forName("com.demo.host.MainActivity");
					Context context = ContexHunter.getContext();
					ClassLoader classloader = context.getClass().getClassLoader();
					Class<?> MainActivity_class = classloader.loadClass("com.demo.host.MainActivity");
					Method setA_method = MainActivity_class.getDeclaredMethod("setA", int.class);
					setA_method.invoke(null, 998);
				} catch (Exception e) {
					e.printStackTrace();
				}

				timer.cancel();
			}

		}, 5000);
		
		return null;
	}

	@Override
	public int update(Uri arg0, ContentValues arg1, String arg2, String[] arg3) {

		return 0;
	}
	
}


