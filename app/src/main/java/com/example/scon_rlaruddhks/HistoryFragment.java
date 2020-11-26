package com.example.scon_rlaruddhks;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.Comparator;

public class HistoryFragment extends Fragment {

    private FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();

    TextView historyText;
    Button refreshBtn;

    public static HistoryFragment newInstance() {
        return new HistoryFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        GetData();
        historyText = view.findViewById(R.id.history_text);
        refreshBtn = view.findViewById(R.id.refreshBtn);
        refreshBtn.setOnClickListener(view1 -> {
            historyText.setText("");
            GetData();
        });
        return view;
    }

    private void GetData() {
        firebaseFirestore.collection("scores")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            ScorePrediction item = document.toObject(ScorePrediction.class);

                            String text = item.getTeam1() + " (" + item.getScore1() + ") : " + item.getTeam2() + " (" + item.getScore2() + ") \n";
                            historyText.append(text);
                        }
                    }
                });
    }
}