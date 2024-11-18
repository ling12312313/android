package com.example.wechat_ac.realac;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.wechat_ac.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Fragment> list;

    BottomNavigationView bottomNavigation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigation = findViewById(R.id.bottomNavigation);

        list = new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new AddressFragment());
        list.add(new DiscoverFragment());
        list.add(new MeFragment());

        showFragment(list.get(0));


        //
        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.menu_message) {
                    showFragment(list.get(0));
                } else if (item.getItemId() == R.id.menu_address_book) {
                    showFragment(list.get(1));
                }else if (item.getItemId() == R.id.menu_discovery) {
                    showFragment(list.get(2));
                }else if (item.getItemId() == R.id.menu_me) {
                    showFragment(list.get(3));
                }
                return true;
            }
        });

    }


    private void showFragment(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container,fragment);
        ft.commit();
    }

}