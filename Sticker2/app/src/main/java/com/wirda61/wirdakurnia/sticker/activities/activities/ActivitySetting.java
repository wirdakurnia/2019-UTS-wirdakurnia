package com.wirda61.wirdakurnia.sticker.activities.activities;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.wirda61.wirdakurnia.sticker.R;
import com.wirda61.wirdakurnia.sticker.activities.Constant;
import com.wirda61.wirdakurnia.sticker.activities.helper.BottomNavigationViewHelper;

public class ActivitySetting extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(3);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_arrow:
                        Intent intent0 = new Intent(ActivitySetting.this, MainActivity.class);
                        startActivity(intent0);
                        finish();
                        break;

                    case R.id.ic_add:
                        Intent intent2 = new Intent(ActivitySetting.this, ActivityAdd.class);
                        startActivity(intent2);
                        finish();
                        break;

                    case R.id.ic_home:
                        Intent intent1 = new Intent(ActivitySetting.this, ActivityHome.class);
                        startActivity(intent1);
                        finish();
                        break;

                    case R.id.ic_setting:
                        break;
                }


                return false;
            }
        });
    }

}
