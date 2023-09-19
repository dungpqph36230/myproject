package com.example.myproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.example.myproject.Ui.BlankFragment;
import com.example.myproject.Ui.BlankFragment2;
import com.example.myproject.Ui.BlankFragment3;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    ArrayList<Product> list = new ArrayList<>();

    ProductAdapter productAdapter;

    BottomNavigationView bottomNavigationView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new BlankFragment()).commit();
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                if (item.getItemId() == R.id.menu_seed) {
                    fragment = new BlankFragment3();

                } else if (item.getItemId() == R.id.menu_content) {
                    fragment = new BlankFragment2();
                } else if (item.getItemId() == R.id.menu_market) {
                    fragment = new BlankFragment();
                } else if (item.getItemId() == R.id.menu_message) {
                    fragment = new BlankFragment2();
                } else if (item.getItemId() == R.id.menu_userOptions) {
                    fragment = new BlankFragment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
                return true;
            }
        });
    }
}