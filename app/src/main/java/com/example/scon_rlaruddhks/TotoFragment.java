package com.example.scon_rlaruddhks;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class TotoFragment extends Fragment {

    public static TotoFragment newInstance() {
        return new TotoFragment();
    }

    private Context mContext;

    EditText team1_text, team2_text;
    NumberPicker score1_pick, score2_pick;
    Button submit;

    private FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_toto, container, false);

        score1_pick = view.findViewById(R.id.score_pick1);
        score2_pick = view.findViewById(R.id.score_pick2);
        team1_text = view.findViewById(R.id.team1_text);
        team2_text = view.findViewById(R.id.team2_text);

        score1_pick.setMaxValue(20);
        score1_pick.setMinValue(0);
        score2_pick.setMaxValue(20);
        score2_pick.setMinValue(0);

        submit = view.findViewById(R.id.submit);
        submit.setOnClickListener(view1 -> LoadScore());

        return view;
    }

    private void LoadScore() {
        String team1 = team1_text.getText().toString().trim();
        String team2 = team2_text.getText().toString().trim();
        int score1 = score1_pick.getValue();
        int score2 = score2_pick.getValue();

        ScorePrediction scorePrediction = new ScorePrediction(user.getUid(), team1, team2, score1, score2);

        firebaseFirestore
                .collection("scores")
                .document()
                .set(scorePrediction)
                .addOnSuccessListener(command -> Toast.makeText(mContext, "올리기 성공", Toast.LENGTH_SHORT).show())
                .addOnFailureListener(command -> Toast.makeText(mContext, "올리기 실패", Toast.LENGTH_SHORT).show());
    }
}
