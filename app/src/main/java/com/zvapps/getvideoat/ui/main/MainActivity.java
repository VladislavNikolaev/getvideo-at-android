package com.zvapps.getvideoat.ui.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.zvapps.getvideoat.R;
import com.zvapps.getvideoat.common.BaseActivity;

public class MainActivity extends BaseActivity {

    private static final String FRAGMENT_MAIN = "main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportFragmentManager().findFragmentByTag(FRAGMENT_MAIN) == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(android.R.id.content, new MainFragment(), FRAGMENT_MAIN)
                    .commit();
        }
    }
}
