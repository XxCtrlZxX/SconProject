package com.example.scon_rlaruddhks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;

import com.example.scon_rlaruddhks.Ranking.RankingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            ChangeFragment(item.getItemId());
            return true;
        });
    }

    private void ChangeFragment(int itemId) {
        FragmentTransaction tran = getSupportFragmentManager().beginTransaction();

        switch (itemId) {
            case R.id.nav_ranking:
                tran.replace(R.id.container, RankingFragment.newInstance());
                break;
            case R.id.nav_highlight:
                tran.replace(R.id.container, HighLightFragment.newInstance());
                break;
            case R.id.nav_toto:
                tran.replace(R.id.container, TotoFragment.newInstance());
                break;
            case R.id.nav_history:
                tran.replace(R.id.container, HistoryFragment.newInstance());
                break;
        }
        tran.commit();
    }

    private void init() {
        bottomNavigationView = findViewById(R.id.bottom_nav);
        ChangeFragment(bottomNavigationView.getSelectedItemId());
    }
}