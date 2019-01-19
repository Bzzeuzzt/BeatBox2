package com.example.el_mohandes.beatbox2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

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

    class BeatHolder extends RecyclerView.ViewHolder {
        Button RecyclerButton;
        public BeatHolder(@NonNull View itemView) {
            super(itemView);
            RecyclerButton = itemView.findViewById(R.id.recycler_button);
        }
    }
}
