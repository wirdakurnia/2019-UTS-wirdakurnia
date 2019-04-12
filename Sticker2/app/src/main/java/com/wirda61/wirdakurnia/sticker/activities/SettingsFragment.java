package com.wirda61.wirdakurnia.sticker.activities;

import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;

import com.wirda61.wirdakurnia.sticker.R;

public class SettingsFragment extends PreferenceFragmentCompat{

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.settings_pref);
    }
}
