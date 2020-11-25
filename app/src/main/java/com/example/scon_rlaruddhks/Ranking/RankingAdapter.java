package com.example.scon_rlaruddhks.Ranking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scon_rlaruddhks.R;

import java.util.ArrayList;

public class RankingAdapter extends RecyclerView.Adapter<RankingAdapter.ItemViewHolder> {

    private ArrayList<RankItem> mData = null;

    RankingAdapter(ArrayList<RankItem> list) {
        mData = list;
    }

    @NonNull
    @Override
    public RankingAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.rank_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RankingAdapter.ItemViewHolder holder, int position) {
        RankItem item = mData.get(position);

        holder.rankNumText.setText(item.getRankNum());
        holder.teamIcon.setImageDrawable(item.getTeamIconDrawable());
        holder.teamNameText.setText(item.getTeamName());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView rankNumText, teamNameText;
        ImageView teamIcon;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            rankNumText = itemView.findViewById(R.id.rank_num_txt);
            teamNameText = itemView.findViewById(R.id.team_name_txt);
            teamIcon = itemView.findViewById(R.id.team_icon_img);
        }
    }
}
