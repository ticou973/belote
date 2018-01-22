package com.example.thierrycouilleault.belotescore.Controller.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thierrycouilleault.belotescore.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoFragment extends Fragment {


    public HistoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view=inflater.inflate(R.layout.fragment_histo, container, false);

        return view;
    }

}
