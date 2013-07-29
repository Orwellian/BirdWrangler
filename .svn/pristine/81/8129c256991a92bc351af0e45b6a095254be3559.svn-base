package com.catalyst.birdwrangler.activities;

import com.catalyst.birdwrangler.R;
import com.catalyst.birdwrangler.R.layout;
import com.catalyst.birdwrangler.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	
	Intent i;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void navigateToSubmissionActivity(View v){
		i = new Intent(this, SubmissionActivity.class);
		startActivity(i);
	}
	
	public void navigateToRecordsActivity(View v){
		i = new Intent(this, RecordsActivity.class);
		startActivity(i);
	}

}
