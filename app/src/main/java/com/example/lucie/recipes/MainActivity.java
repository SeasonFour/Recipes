package com.example.lucie.recipes;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.example.lucie.recipes.R;
import com.yalantis.guillotine.animation.GuillotineAnimation;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {
        private static final long RIPPLE_DURATION = 250;

<<<<<<< HEAD
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Vegetarian.class);
                startActivity(i);

            }
        });
    }
}
=======
        @InjectView(R.id.toolbar)
        Toolbar toolbar;
        @InjectView(R.id.root)
        RelativeLayout root;
        @InjectView(R.id.content_hamburger)
        View contentHamburger;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.content_main);
            ButterKnife.inject(this);


            if (toolbar != null) {
                setSupportActionBar(toolbar);
                getSupportActionBar().setTitle(null);
            }

            View guillotineMenu = LayoutInflater.from(this).inflate(R.layout.guillotine_menu, null);
            root.addView(guillotineMenu);

            new GuillotineAnimation.GuillotineBuilder(guillotineMenu, guillotineMenu.findViewById(R.id.guillotine_hamburger), contentHamburger)
                    .setStartDelay(RIPPLE_DURATION)
                    .setActionBarViewForAnimation(toolbar)
                    .setClosedOnStart(true)
                    .build();
        }

    }



>>>>>>> c9b802e5c16ef2f149b501bb3d262014dd9dcf1c
