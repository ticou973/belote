package com.example.thierrycouilleault.belotescore.Controller.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;

import com.example.thierrycouilleault.belotescore.R;

/**
 * Created by thierrycouilleault on 28/01/2018.
 */

public class SettingsFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);

    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

        //Surement inutile...

        if (key.equals("nb_points_gagnés")) {
            Preference connectionPref = findPreference(key);
            connectionPref.setDefaultValue(sharedPreferences.getString(key, ""));
        } else if (key.equals("nb_donnes_gagner")) {
            Preference connectionPref = findPreference(key);
            connectionPref.setDefaultValue(sharedPreferences.getString(key, ""));

        }
    }

    @Override
    public void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences()
                .registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences()
                .unregisterOnSharedPreferenceChangeListener(this);
    }


}
