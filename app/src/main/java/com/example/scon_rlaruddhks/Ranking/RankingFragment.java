package com.example.scon_rlaruddhks.Ranking;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scon_rlaruddhks.R;

import java.util.ArrayList;
import java.util.List;

public class RankingFragment extends Fragment {

    private Context mContext;
    private ArrayList<RankItem> list = new ArrayList<>();
    private int[] icons = {
            R.drawable.tot, R.drawable.liv, R.drawable.che, R.drawable.les, R.drawable.sos, R.drawable.evt, R.drawable.asv, R.drawable.weh,
            R.drawable.wol, R.drawable.man, R.drawable.cpa, R.drawable.asn, R.drawable.mac, R.drawable.led, R.drawable.nca, R.drawable.brt,
            R.drawable.bun, R.drawable.pul, R.drawable.wes, R.drawable.she
    };
    private String[] teamNames = {
            "토트넘", "리버풀", "첼시", "레스터 시티", "사우샘프턴", "애버턴", "애스턴 빌라", "웨스트 햄",
            "울브스", "맨유", "크리스털 팰리스", "아스널", "맨 시티", "리즈 유나이티드", "뉴캐슬", "브라이턴",
            "번리", "풀럼", "웨스트 브롬", "셰필드 유니이..."
    };

    RecyclerView recyclerView;
    RankingAdapter adapter;

    public static RankingFragment newInstance() {
        return new RankingFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ranking, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        adapter = new RankingAdapter(list);
        recyclerView.setAdapter(adapter);
        getData();

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    private void getData() {
        for (int i = 0; i < 20; i++) {
            Drawable icon = ContextCompat.getDrawable(mContext, icons[i]);
            list.add(new RankItem(Integer.toString(i + 1), teamNames[i], icon));
            if (adapter != null)
                adapter.notifyDataSetChanged();
        }

    }
}