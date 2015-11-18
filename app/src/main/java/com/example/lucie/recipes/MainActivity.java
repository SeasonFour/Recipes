package com.example.lucie.recipes;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;


import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.yalantis.guillotine.animation.GuillotineAnimation;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {
        private static final long RIPPLE_DURATION = 250;

    private RecyclerView fRecyclerView;
    private RecyclerView.Adapter fAdapter;
    private RecyclerView.LayoutManager fLayoutManager;
    private String[] fDataset = {"chicken nuggets", "chicken, bread crumbs, oil", "dip the chicken in the bread crumbs, deep fry in oil"};

        @InjectView(R.id.toolbar)
        Toolbar toolbar;
        @InjectView(R.id.root)
        FrameLayout root;
        @InjectView(R.id.content_hamburger)
        View contentHamburger;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);



            setContentView(R.layout.content_main);
            fRecyclerView = (RecyclerView) findViewById(R.id.food_recycler_view);
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            fRecyclerView.setHasFixedSize(true);

            // use a linear layout manager
            fLayoutManager = new LinearLayoutManager(this);
            fRecyclerView.setLayoutManager(fLayoutManager);

            // specify an adapter
            fAdapter = new FoodAdapter(fDataset);
            fRecyclerView.setAdapter(fAdapter);

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

            ParseQuery<ParseObject> query = ParseQuery.getQuery("Food");
            query.getInBackground("1Y4VJGJzXv", new GetCallback<ParseObject>() {
                public void done(ParseObject object, ParseException e) {
                    ParseObject food = new ParseObject("Food");
                    if (e == null) {
                        Log.d("parse retrieve", "success");

                        String name = object.getString("name");
                        String ingredients =object.getString("ingredients");
                        String cooking = object.getString("cooking_method");

                        Log.d("name", ""+name);
                        Log.d("ingredient", ""+ingredients);
                        Log.d("method", ""+cooking);
                    } else {
                        // something went wrong
                        Log.d("parse retrieve", "fail");
                    }
                }
            });
        }

    public void featuredClick(View view){
        Intent intent = new Intent(this, Featured.class);
        startActivity(intent);

    }

    public void vegetarianClick(View view){
        Intent intent = new Intent(this, Vegetarian.class);
        startActivity(intent);

    }


    public void nonveganClick(View view){
        Intent i = new Intent(this, NonVegeterian.class);
        startActivity(i);
    }

    public void saladsClick(View v){
        Intent i = new Intent(this,Salads.class);
        startActivity(i);
    }

    public void regionClick(View v){
        Intent i = new Intent(this,Regions.class);
        startActivity(i);
    }

    }

