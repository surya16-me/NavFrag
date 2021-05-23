package com.example.navfrag.rv;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.navfrag.R;

import java.util.ArrayList;

public class buahAdapter extends RecyclerView.Adapter<buahAdapter.ViewHolder>{


    private Context context;
    private ArrayList<buahModel> buahModels = new ArrayList<>();

    public buahAdapter(ArrayList<buahModel> buahLis, Context context) {
        this.context = context;
    }

    public ArrayList<buahModel> getBuahModels() {
        return buahModels;
    }

    public void setBuahModels(ArrayList<buahModel> buahModels) {
        this.buahModels = buahModels;
    }

    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from((parent.getContext())).inflate(R.layout.item_detail, parent, false);
        return new ViewHolder((itemRow));
    }

    @Override
    public void onBindViewHolder(@NonNull  buahAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(getBuahModels().get(position).getBuahImage()).into(holder.imageBuah);
        holder.tvNama.setText(getBuahModels().get(position).getNamaBuah());
        holder.btShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String buahName = "Buah " + getBuahModels().get(position).getNamaBuah();
                intent.putExtra(Intent.EXTRA_TEXT, buahName);
                context.startActivity(Intent.createChooser(intent, "Share Using"));
            }
        });
        holder.btLihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailBuah.class);
                intent.putExtra("img_url", getBuahModels().get(position).getBuahImage());
                intent.putExtra("title", getBuahModels().get(position).getNamaBuah());
                intent.putExtra("detail", getBuahModels().get(position).getDetailBuah());
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return getBuahModels().size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageBuah;
        private TextView tvNama;
        private Button btLihat, btShare;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageBuah = itemView.findViewById(R.id.itemDetail_image);
            tvNama = itemView.findViewById(R.id.itemDetail_tvNama);
            btLihat = itemView.findViewById(R.id.itemBtLihat);
            btShare = itemView.findViewById(R.id.itemBtShare);

        }
    }
}

