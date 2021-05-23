package com.example.navfrag;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navfrag.rv.*;

import java.util.ArrayList;

public class fragmentlist extends Fragment {

    private RecyclerView rvBuah;
    private ArrayList<com.example.navfrag.rv.buahModel> listBuah = new ArrayList<>();

    public fragmentlist() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragmentlist, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvBuah = view.findViewById(R.id.rv_target);
        rvBuah.setHasFixedSize(true);
        listBuah.addAll(com.example.navfrag.rv.buahData.getBuahList());

        showRecyclerList();
    }

    private void showRecyclerList()  {
        rvBuah.setLayoutManager(new LinearLayoutManager(getActivity()));
        buahAdapter buahAdapter = new buahAdapter(com.example.navfrag.rv.buahData.getBuahList(), getActivity());
        buahAdapter.setBuahModels(listBuah);
        rvBuah.setAdapter(buahAdapter);


    }
}