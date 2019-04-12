package com.wirda61.wirdakurnia.sticker.activities.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.wirda61.wirdakurnia.sticker.R;
import com.wirda61.wirdakurnia.sticker.activities.helper.BottomNavigationViewHelper;

public class MainActivity extends AppCompatActivity{
    private static final String TAG = "MainActivity";
    TextView txtHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtHello = findViewById(R.id.textHello);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_arrow:

                        break;

                    case R.id.ic_add:
                        Intent intent2 = new Intent(MainActivity.this, ActivityAdd.class);
                        startActivity(intent2);
                        finish();
                        break;

                    case R.id.ic_home:
                        Intent intent1 = new Intent(MainActivity.this, ActivityHome.class);
                        startActivity(intent1);
                        finish();
                        break;

                    case R.id.ic_setting:
                        Intent intent3 = new Intent(MainActivity.this, ActivitySetting.class);
                        startActivity(intent3);
                        finish();
                        break;
                }

                return false;
            }
        });
    }
}
