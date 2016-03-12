package com.changebooths.Jobs;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.changebooths.R;

public class JobsActivity extends AppCompatActivity {
    /**
     * A handler object, used for deferring UI operations.
     */
    private Handler mHandler = new Handler();

    /**
     * Whether or not we're showing the back of the card (otherwise showing the front).
     */
    private boolean mShowingBack = false;

    private View mContentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_jobs);

        mContentView = findViewById(R.id.jobs);

        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        if (savedInstanceState == null) {
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, new CardFrontFragment(ContextCompat.getDrawable(this, R.drawable.job_employer4), "Nepal Communitere", "Operations Director", "Kathmandu, Nepal", "test4"))
                    .add(R.id.container2, new CardFrontFragment(ContextCompat.getDrawable(this, R.drawable.job_employer1), "Kolpa World", "Store keeper", "Kathmandu, Nepal", "$" ))
                    .add(R.id.container3, new CardFrontFragment(ContextCompat.getDrawable(this, R.drawable.job_employer2), "Maiti Nepal", "Custodian", "Kathmandu, Nepal", "$1.00/hr"))
                    .add(R.id.container4, new CardFrontFragment(ContextCompat.getDrawable(this, R.drawable.job_employer3), "Amit’s Agriculture", "Farmer", "Kathmandu, Nepal", "$0.75/hr"))
                    .add(R.id.container5, new CardFrontFragment(ContextCompat.getDrawable(this, R.drawable.job_employer5), "Nepali Library", "Book keeper", "Kathmandu, Nepal", "$1.25/hr"))
                    .commit();

        }
    }

    public void flipCard(View v) {

        if (mShowingBack) {
            getFragmentManager().popBackStack();
            mShowingBack = false;
            return;
        }

        // Flip to the back.

        mShowingBack = true;

        // Create and commit a new fragment transaction that adds the fragment for
        // the back of the card, uses custom animations, and is part of the fragment
        // manager's back stack.

        getFragmentManager()
                .beginTransaction()
                .setCustomAnimations(
                        R.animator.card_flip_right_in,
                        R.animator.card_flip_right_out,
                        R.animator.card_flip_left_in,
                        R.animator.card_flip_left_out)
                .replace(v.getId(), new CardBackFragment())
                .addToBackStack(null)
                .commit();
    }

    /**
     * A fragment representing the front of the card.
     */
    public static class CardFrontFragment extends Fragment {

        public Drawable employerProfile;
        public String employerName;
        public String type;
        public String location;
        public String price;

        public CardFrontFragment() {}

        public CardFrontFragment( Drawable employerProfile, String employerName, String type, String location, String price ) {
            this.employerProfile = employerProfile;
            this.employerName = employerName;
            this.type = type;
            this.location = location;
            this.price = price;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_card_front, container, false);

            ImageView employerProfile = (ImageView)view.findViewById(R.id.employerProfile);
            employerProfile.setImageDrawable(this.employerProfile);

            TextView employerName = (TextView)view.findViewById(R.id.employerName);
            employerName.setText(this.employerName);

            TextView type = (TextView)view.findViewById(R.id.type);
            type.setText("Looking for: " + this.type);

            TextView location = (TextView)view.findViewById(R.id.location);
            location.setText("Location: " + this.location);

            TextView price = (TextView)view.findViewById(R.id.price);
            price.setText("Compensation: " + this.price);

            return view;
        }
    }

    /**
     * A fragment representing the back of the card.
     */
    public static class CardBackFragment extends Fragment {
        public CardBackFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_card_back, container, false);
        }
    }

    public void onClickBack(View v) {

        super.onBackPressed();

    }
}
