package com.demo.host;

import android.app.Activity;
import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

/**
 * 
 * @author boyliang
 * 
 */
public final class MainActivity extends Activity {
	private static int sA = 1;

	public static void setA(int a) {
		sA = a;
	}

	public static int getA() {
		return sA;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ContentResolver resolver = getContentResolver();
		Uri uri = Uri.parse("content://demo_contentprovider");
		resolver.query(uri, null, null, null, null);

		new Thread() {

			public void run() {
				while (true) {
					Log.i("TTT", "" + getA());
					setA(getA() + 1);

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};

		}.start();
	}
}
