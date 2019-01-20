package com.example.el_mohandes.beatbox2;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class BeatBoxFragment extends Fragment {
    RecyclerView Recycler;
    BeatBox TestBeatBox;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        TestBeatBox = new BeatBox(Objects.requireNonNull(getActivity()));
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

    public class BeatBoxAdapter extends RecyclerView.Adapter<BeatBoxAdapter.BeatHolder> {

        Context AdapterContext;
        ArrayList<Sound> AdapterList;

        public BeatBoxAdapter(Context context , ArrayList<Sound> mSounds) {
            AdapterContext = context;
            AdapterList =  mSounds;
        }

        @NonNull
        @Override
        public BeatHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            LayoutInflater inflater = LayoutInflater.from(AdapterContext);
            return new BeatHolder( inflater.inflate(R.layout.recycler_item,viewGroup,false) );
        }

        @Override
        public void onBindViewHolder(@NonNull BeatHolder beatHolder, int position) {
            Sound sound = AdapterList.get(position);
            beatHolder.RecyclerButton.setText( sound.getmAssetName() );

        }

        @Override
        public int getItemCount() {
            return AdapterList.size();
        }

        class BeatHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            Button RecyclerButton;
            public BeatHolder(@NonNull View itemView) {
                super(itemView);
                RecyclerButton = itemView.findViewById(R.id.recycler_button);
                RecyclerButton.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                int position = getLayoutPosition();
                Sound sound = TestBeatBox.getSounds().get(position);
                TestBeatBox.playSound(sound);
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        TestBeatBox.release();
    }
}
