package com.example.scon_rlaruddhks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_home:
                    ChangeFragment(HomeFragment.newInstance());
                    break;
                case R.id.nav_ranking:
                    ChangeFragment(RankingFragment.newInstance());
                    break;
                case R.id.nav_highlight:
                    ChangeFragment(HighLightFragment.newInstance());
                    break;
                case R.id.nav_toto:
                    ChangeFragment(TotoFragment.newInstance());
                    break;
            }
            return true;
        });
    }

    private void ChangeFragment(Fragment fragment) {
        FragmentTransaction tran = getSupportFragmentManager().beginTransaction();
        tran.replace(R.id.container, fragment);
        tran.commit();
    }

    private void init() {
        bottomNavigationView = findViewById(R.id.bottom_nav);
        ChangeFragment(HomeFragment.newInstance());
    }
}