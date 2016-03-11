package com.changebooths.Profile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.changebooths.Profile.Models.User;
import com.changebooths.R;

import java.util.ArrayList;

public class Profile extends AppCompatActivity {

    //Initialize a dummy user
    String name = "Old MacDonald";
    String phone = "123-456-7890";
    String email = "email@changebooths.com";
    String education = "Rutgers University";
    ArrayList<String> skills = new ArrayList<String>();
    ArrayList<String> work = new ArrayList<String>();

    private View mContentView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mContentView = findViewById(R.id.profile);
        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        skills.add("Farmer");
        skills.add("Handyman");
        skills.add("Carpenter");
        User user = new User(name,phone,email,education,skills);

        View skillsLayout = findViewById(R.id.skillsLayout);
        // Drawable roundButton = getResources().getDrawable(R.drawable.round_button);
        for (String skill: user.skills)
        {
            TextView skillButton = new TextView(this);
            skillButton.setText(skill);
            skillButton.setFocusable(false);
            //  skillButton.setBackground(roundButton);
            skillButton.setWidth(120);
            skillButton.setHeight(120);

            //((RelativeLayout) skillsLayout).addView(skillButton);
        }

    }

    public void onClickBack(View v) {
        super.onBackPressed();
    }

}
