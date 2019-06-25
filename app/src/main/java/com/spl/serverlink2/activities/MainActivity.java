package com.spl.serverlink2.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.spl.serverlink2.R;
import com.spl.serverlink2.classes.HelloServer;

public class MainActivity extends AppCompatActivity {

	HelloServer helloServer = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		helloServer = HelloServer.main( new String[]{} );
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

		if( helloServer != null )	helloServer.stop();
	}
}
