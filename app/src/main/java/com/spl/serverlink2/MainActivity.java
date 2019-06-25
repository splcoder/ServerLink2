package com.spl.serverlink2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
