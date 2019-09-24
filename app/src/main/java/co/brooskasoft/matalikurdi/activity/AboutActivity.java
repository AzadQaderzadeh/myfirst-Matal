package co.brooskasoft.matalikurdi.activity;

import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import co.brooskasoft.matalikurdi.R;

public class AboutActivity extends AppCompatActivity {

    //    private InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

//        MobileAds.initialize(this, Key.AD_UNIT_ID);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_about);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary));
        }
//        AdView mAdView1 = findViewById(R.id.adView_About_one);
//        AdView mAdView2 = findViewById(R.id.adView_About_two);
//
//        AdView adView = new AdView(this);
//        adView.setAdSize(AdSize.BANNER);
//
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView1.loadAd(adRequest);
//        mAdView2.loadAd(adRequest);
//
//        mInterstitialAd = newInterstitialAd();
//        loadInterstitial();
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
//        showInterstitial();
    }
//
//    private InterstitialAd newInterstitialAd() {
//        InterstitialAd interstitialAd = new InterstitialAd(this);
//        interstitialAd.setAdUnitId(Key.Miyani_MatalKurdi);
//        interstitialAd.setAdListener(new AdListener() {
//            @Override
//            public void onAdLoaded() {
//            }
//
//            @Override
//            public void onAdFailedToLoad(int errorCode) {
//            }
//
//            @Override
//            public void onAdClosed() {
//                // Proceed to the next level.
//            }
//        });
//        return interstitialAd;
//    }
//
//    private void showInterstitial() {
//        // Show the ad if it's ready. Otherwise toast and reload the ad.
//        if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
//            mInterstitialAd.show();
//        }
////        else {
////            Toast.makeText(getContext(), "Ad did not load", Toast.LENGTH_SHORT).show();
////        }
//    }
//
//    private void loadInterstitial() {
//        // Disable the next level button and load the ad.
//        AdRequest adRequest = new AdRequest.Builder()
//                .setRequestAgent("android_studio:ad_template").build();
//        mInterstitialAd.loadAd(adRequest);
//    }
}


