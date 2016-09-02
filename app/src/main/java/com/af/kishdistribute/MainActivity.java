package com.af.kishdistribute;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.af.kishdistribute.Fragments.OffFragment;

public class MainActivity extends AppCompatActivity {

    public OffFragment offFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getFragmentManager();
        if (fm != null) {
            offFragment = new OffFragment().newInstance();
            fm.beginTransaction().replace(R.id.detail_fragment, offFragment).addToBackStack(null).commit();
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
