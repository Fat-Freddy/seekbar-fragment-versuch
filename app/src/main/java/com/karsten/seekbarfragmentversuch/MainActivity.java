package com.karsten.seekbarfragmentversuch;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.SeekBar;

import com.karsten.seekbarfragmentversuch.fragments.SectionsPagerAdapter;
import com.karsten.seekbarfragmentversuch.fragments.SharedViewModel;

public class MainActivity extends AppCompatActivity {

    private SharedViewModel viewModel;
    //private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);

        tabs.setupWithViewPager(viewPager);
        SeekBar seekBar= findViewById(R.id.seekBar);

        viewModel = ViewModelProviders.of(this).get(SharedViewModel.class);
        seekBar.setMax(100);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                String jaja= String.valueOf(i);

                viewModel.setText(jaja);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


       // viewModel = new ViewModelProvider(MainActivity.this).get(SharedViewModel.class);

    }
}