package com.example.lucie.recipes;

import android.app.Application;
import android.graphics.Typeface;

import com.parse.Parse;

/**
 * Created by Dmytro Denysenko on 5/6/15.
 */
public class App extends Application {
    private static final String CANARO_EXTRA_BOLD_PATH = "fonts/canaro_extra_bold.otf";
    public static Typeface canaroExtraBold;

    @Override
    public void onCreate() {
        super.onCreate();
        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "vPNdghWKPbYKtuBVy67rSfseUZydvaWjk0uBdGpy", "XwgHttUskG4ByiJb4ij5IphFN2tJOiXJ5sh7sLco");

        initTypeface();
    }

    private void initTypeface() {
        canaroExtraBold = Typeface.createFromAsset(getAssets(), CANARO_EXTRA_BOLD_PATH);

    }
}
