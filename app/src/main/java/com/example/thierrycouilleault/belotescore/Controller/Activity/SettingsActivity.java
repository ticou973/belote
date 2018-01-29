package com.example.thierrycouilleault.belotescore.Controller.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.thierrycouilleault.belotescore.Controller.Fragments.SettingsFragment;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Display the fragment as the main content.
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();
    }
}
