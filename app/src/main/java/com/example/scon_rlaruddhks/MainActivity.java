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

        bottomNavigationView = findViewById(R.id.bottom_nav);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_home:
                    ChangeFragment(HomeFragment.newInstance());
                    Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_ranking:
                    ChangeFragment(RankingFragment.newInstance());
                    Toast.makeText(MainActivity.this, "Ranking", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_highlight:
                    ChangeFragment(HighLightFragment.newInstance());
                    Toast.makeText(MainActivity.this, "Highlight", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_toto:
                    ChangeFragment(TotoFragment.newInstance());
                    Toast.makeText(MainActivity.this, "Toto", Toast.LENGTH_SHORT).show();
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
}