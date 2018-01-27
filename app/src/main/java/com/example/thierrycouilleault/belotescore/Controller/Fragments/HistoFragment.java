package com.example.thierrycouilleault.belotescore.Controller.Fragments;


import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thierrycouilleault.belotescore.Model.BDD.AppDatabase;
import com.example.thierrycouilleault.belotescore.Model.BDD.Partie;
import com.example.thierrycouilleault.belotescore.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoFragment extends Fragment {

    public RecyclerView recyclerView;
    public RecyclerView.Adapter adapter;
    public List<Partie> parties;


    public HistoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view=inflater.inflate(R.layout.fragment_histo, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView=getActivity().findViewById(R.id.recycler_view_histo);



        //Gestion de la DB

        final AppDatabase db = Room.databaseBuilder(getActivity().getApplicationContext(), AppDatabase.class, "production")
                .allowMainThreadQueries()
                .build();

        //Création partie courante

        parties =db.partieDao().getAllParties();

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));

        adapter = new HistoAdapter(parties);

        recyclerView.setAdapter(adapter);


    }

}
