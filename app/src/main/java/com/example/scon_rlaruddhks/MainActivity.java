package com.example.scon_rlaruddhks;

import androidx.appcompat.app.AppCompatActivity;
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

        FragmentTransaction tran = getSupportFragmentManager().beginTransaction();
        bottomNavigationView = findViewById(R.id.bottom_nav);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_home:
                    tran.replace(R.id.container, HomeFragment.newInstance());
                    Toast.makeText(MainActivity.this, String.valueOf(item.getItemId()), Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_ranking:
                    tran.replace(R.id.container, RankingFragment.newInstance());
                    Toast.makeText(MainActivity.this, String.valueOf(item.getItemId()), Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_highlight:
                    tran.replace(R.id.container, HighLightFragment.newInstance());
                    Toast.makeText(MainActivity.this, String.valueOf(item.getItemId()), Toast.LENGTH_SHORT).show();
                    break;
                case R.id.nav_toto:
                    tran.replace(R.id.container, TotoFragment.newInstance());
                    Toast.makeText(MainActivity.this, String.valueOf(item.getItemId()), Toast.LENGTH_SHORT).show();
                    break;
            }
            return true;
        });
    }
}