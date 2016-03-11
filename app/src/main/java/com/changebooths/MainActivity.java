package com.changebooths;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.changebooths.Jobs.JobsActivity;
import com.changebooths.Profile.Profile;
import com.changebooths.R;
import com.changebooths.Services.LocalServicesActivity;

public class MainActivity extends AppCompatActivity {

    private View mContentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mContentView = findViewById(R.id.fullscreen_content);

        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }

    public void onLocalServicesClick(View v) {

        Intent intent = new Intent(this, LocalServicesActivity.class);
        startActivity(intent);

    }
    public void onProfileClick(View v) {

        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);

    }

    public void onJobsClick(View v) {

        Intent intent = new Intent(this, JobsActivity.class);
        startActivity(intent);

    }

}