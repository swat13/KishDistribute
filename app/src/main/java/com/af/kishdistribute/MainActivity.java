package com.af.kishdistribute;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.af.kishdistribute.Fragments.MapsActivity;
import com.af.kishdistribute.Fragments.OffFragment;
import com.af.kishdistribute.Fragments.ProfileFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public OffFragment offFragment;
    public MapsActivity mapsActivity;
    public ProfileFragment profileFragment;
    private Button bt_off,bt_around,bt_media, bt_profile;
    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_off = (Button) findViewById(R.id.offButton);
        bt_around = (Button) findViewById(R.id.aroundButton);
        bt_media = (Button) findViewById(R.id.mediaButton);
        bt_profile = (Button) findViewById(R.id.profileButton);

        offFragment = new OffFragment().newInstance();

        fm = getFragmentManager();
        if (fm != null) {
            fm.beginTransaction().replace(R.id.detail_fragment, offFragment).addToBackStack(null).commit();
        }

        bt_off.setBackgroundResource(R.drawable.first_sel);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction ft;
        switch (v.getId()) {
            case R.id.offButton:
                bt_off.setBackgroundResource(R.drawable.first_sel);
                bt_around.setBackgroundResource(R.drawable.second);
                bt_media.setBackgroundResource(R.drawable.third);
                bt_profile.setBackgroundResource(R.drawable.fourth);

//                offFragment = new OffFragment().newInstance();
                ft = getFragmentManager().beginTransaction();
//                ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right);
                ft.replace(R.id.detail_fragment, offFragment).commit();

                break;
            case R.id.aroundButton:
                bt_off.setBackgroundResource(R.drawable.first);
                bt_around.setBackgroundResource(R.drawable.second_sel);
                bt_media.setBackgroundResource(R.drawable.third);
                bt_profile.setBackgroundResource(R.drawable.fourth);

                if (mapsActivity == null) {
                    mapsActivity = new MapsActivity().newInstance();
                }
                ft = getFragmentManager().beginTransaction();
//                ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right);
                ft.replace(R.id.detail_fragment, mapsActivity).commit();
                break;
            case R.id.mediaButton:
                bt_off.setBackgroundResource(R.drawable.first);
                bt_around.setBackgroundResource(R.drawable.second);
                bt_media.setBackgroundResource(R.drawable.third_sel);
                bt_profile.setBackgroundResource(R.drawable.fourth);
                break;
            case R.id.profileButton:

                if (profileFragment == null) {
                    profileFragment = new ProfileFragment().newInstance();
                }
                ft = getFragmentManager().beginTransaction();
//                ft.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right);
                ft.replace(R.id.detail_fragment, profileFragment).commit();

                bt_off.setBackgroundResource(R.drawable.first);
                bt_around.setBackgroundResource(R.drawable.second);
                bt_media.setBackgroundResource(R.drawable.third);
                bt_profile.setBackgroundResource(R.drawable.fourth_sel);





                break;
            default:
                break;

        }
    }
}
