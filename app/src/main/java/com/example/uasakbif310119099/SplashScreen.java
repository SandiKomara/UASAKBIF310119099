package com.example.uasakbif310119099;
/*

NIM   : 10119099
Nama  : Sandi Komara
Kelas : IF-3

 */
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.uasakbif310119099.Login.Login;
import com.example.uasakbif310119099.ViewPager.ViewPager;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        if (getSupportActionBar() != null)
        {
            getSupportActionBar().hide();
        }
        // set lama splash screen tampil
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this, ViewPager.class));
                finish();
            }
        }, 4000);

    }
}