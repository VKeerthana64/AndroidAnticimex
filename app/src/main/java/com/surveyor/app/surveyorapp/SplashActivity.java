package com.surveyor.app.surveyorapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.surveyor.app.surveyorapp.utils.AppConstants;
import com.surveyor.app.surveyorapp.utils.SharedObjects;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 3000;

    String loginStatus;
    SharedObjects sharedObjects;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

             new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                sharedObjects = new SharedObjects(SplashActivity.this);
                loginStatus = sharedObjects.getPreference(AppConstants.STATUS);
                Intent intentLogin ;
                /*if (TextUtils.isEmpty(loginStatus)) {
                    intentLogin = new Intent(SplashActivity.this, LoginActivity.class);
                } else if (loginStatus.equals(AppConstants.STATUS_LOGOUT)) {
                    intentLogin = new Intent(SplashActivity.this, LoginActivity.class);
                } else {
                    intentLogin = new Intent(SplashActivity.this, DashboardActivity.class);
                }*/
                intentLogin = new Intent(SplashActivity.this, LoginActivity.class);
                intentLogin.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intentLogin);
                finish();
            }
        }, SPLASH_TIME_OUT);

    }

}
