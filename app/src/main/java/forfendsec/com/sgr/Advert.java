package forfendsec.com.sgr;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

/**
 * Created by Joshua Munaweza on 11/24/17.
 */

public class Advert extends AppCompatActivity {

    private String TAG = Advert.class.getSimpleName();
    InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mInterstitialAd = new InterstitialAd(this);


        mInterstitialAd.setAdUnitId("ca-app-pub-1093144503922289/7138613527");

        AdRequest adRequest = new AdRequest.Builder().build();

        mInterstitialAd.loadAd(adRequest);

        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                showInterstitial();

            }
        });
    }

        private void showInterstitial(){
            if (mInterstitialAd.isLoaded()){
                mInterstitialAd.show();
            }
    }
    }



