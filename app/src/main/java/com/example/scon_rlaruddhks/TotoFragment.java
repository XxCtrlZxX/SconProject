package com.example.scon_rlaruddhks;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class TotoFragment extends Fragment {
    public static TotoFragment newInstance() {
        return new TotoFragment();
    }

    ImageButton lup,ldown,rup,rdown;
    TextView ltext, rtext;
    int left_num = 0, right_num = 0;
    private Context mContext;
    Button submit;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_toto, container, false);

        lup = view.findViewById(R.id.left_up);
        rup = view.findViewById(R.id.right_up);
        ldown = view.findViewById(R.id.left_down);
        rdown = view.findViewById(R.id.right_down);

        ltext = view.findViewById(R.id.score_num1);
        rtext = view.findViewById(R.id.score_num2);

        submit = view.findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ltext, rtext를 파이어배이스로 전달
            }
        });

        lup.setOnClickListener(v -> {
            left_num++;
            ltext.setText(left_num + "");
        });
        ldown.setOnClickListener(v -> {

            if(left_num > 0){
                left_num--;
            }
            else {
                Toast.makeText(mContext, "점수는 음수가 될 수 없습니다", Toast.LENGTH_SHORT).show();
            }
            ltext.setText(left_num + "");
        });
        rup.setOnClickListener(v -> {
            right_num++;
            rtext.setText(right_num+ "");
        });
        rdown.setOnClickListener(v -> {
            if (right_num > 0) {
                right_num--;
            }
            else {
                Toast.makeText(mContext, "점수는 음수가 될 수 없습니다", Toast.LENGTH_SHORT).show();
            }
            rtext.setText(right_num+ "");
        });
        

        return view;
    }
}
