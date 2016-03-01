package com.example.david.changebooths;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;




public class Profile extends AppCompatActivity {

    //Initialize a dummy user
    String name = "Old MacDonald";
    String phone = "123-456-7890";
    String email = "email@changebooths.com";
    String education = "Rutgers University";
    ArrayList<String> skills = new ArrayList<String>();
    ArrayList<String> work = new ArrayList<String>();
    @Override
    // @TargetApi(16)
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);



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

            ((RelativeLayout) skillsLayout).addView(skillButton);
        }


    }



/*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    */
}
