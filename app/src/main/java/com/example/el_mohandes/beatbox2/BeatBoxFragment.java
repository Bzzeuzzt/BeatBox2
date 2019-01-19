package com.example.el_mohandes.beatbox2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BeatBoxFragment extends Fragment {
    RecyclerView Recycler;
    BeatBox TestBeatBox;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TestBeatBox = new BeatBox(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_beat_box,container,false);
        Recycler = v.findViewById(R.id.Recycler);
        Recycler.setLayoutManager(new GridLayoutManager(getActivity(),3));
        Recycler.setAdapter(new BeatBoxAdapter(getActivity(),TestBeatBox.getSounds()));
        return v;
    }
}
