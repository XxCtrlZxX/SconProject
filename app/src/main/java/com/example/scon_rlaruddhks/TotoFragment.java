package com.example.scon_rlaruddhks;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.firebase.firestore.FirebaseFirestore;

public class TotoFragment extends Fragment {

    public static TotoFragment newInstance() {
        return new TotoFragment();
    }

    private Context mContext;

    NumberPicker score1, score2;
    Button submit;

    private FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_toto, container, false);

        score1 = view.findViewById(R.id.score_pick1);
        score2 = view.findViewById(R.id.score_pick2);

        score1.setMaxValue(20);
        score1.setMinValue(0);
        score2.setMaxValue(20);
        score2.setMinValue(0);

        submit = view.findViewById(R.id.submit);
        submit.setOnClickListener(view1 -> {
            Toast.makeText(mContext, score1.getValue() + " : " + score2.getValue(), Toast.LENGTH_SHORT).show();
        });

        return view;
    }

    private void LoadScore() {

    }
}
