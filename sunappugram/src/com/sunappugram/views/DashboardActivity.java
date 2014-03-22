package com.sunappugram.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.parse.ParseUser;
import com.sunappugram.R;

public class DashboardActivity extends Activity {

	private TextView firstName, lastName;
	private Button logout, settings, post;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dashboard);
		

		ParseUser currentUser = ParseUser.getCurrentUser();
		if (currentUser != null) {

			firstName = (TextView) findViewById(R.id.dashboard_firstname);
			lastName = (TextView) findViewById(R.id.dashboard_lastname);
			logout = (Button) findViewById(R.id.logout_button);
			settings = (Button) findViewById(R.id.settings_button);
			post = (Button) findViewById(R.id.post_button);

			firstName.setText(currentUser.getString("firstName"));
			lastName.setText(currentUser.getString("lastName"));

		} else {
			return;
		}
		
		createListeners();
	}
	
	public void createListeners() {
		logout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//terminate all executing threads
				//go back to loginView
				ParseUser.logOut();
				startActivity(new Intent(getApplicationContext(), SunappuGramActivity.class));
				overridePendingTransition(R.anim.right_slide_in, R.anim.right_slide_out);
			}
		});
		
		settings.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
				overridePendingTransition(R.anim.right_slide_in, R.anim.right_slide_out);
			}
		});
		
		post.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//pop up some new window
			}
		});
	}

	@Override
	public void onBackPressed() {
		return;
	}

}
