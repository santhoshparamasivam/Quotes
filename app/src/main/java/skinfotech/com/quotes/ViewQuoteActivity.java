package skinfotech.com.quotes;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardedVideoAd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ViewQuoteActivity extends AppCompatActivity {


    private RewardedVideoAd mRewardedVideoAd;
    AdView belowAd,adView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_single_funny);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        belowAd=findViewById(R.id.belowAd);
        adView=findViewById(R.id.adView);
        //Mobile Ads
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd.loadAd("ca-app-pub-3643602219143275/2553266757",
                new AdRequest.Builder().build());
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        AdRequest dRequest = new AdRequest.Builder().build();
        belowAd.loadAd(dRequest);
        TextView txtProduct = (TextView) findViewById(R.id.product_label);

        Intent i = getIntent();
        // getting attached intent data
        final String product = i.getStringExtra("product");
        // displaying selected product name
        txtProduct.setText(product);

        LinearLayout l1 = (LinearLayout) findViewById(R.id.l1);
        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Status", product);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(ViewQuoteActivity.this, "Copied Successfully", Toast.LENGTH_LONG).show();
            }
        });

        LinearLayout l2 = (LinearLayout) findViewById(R.id.l2);
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/html");
                sharingIntent.putExtra(Intent.EXTRA_TEXT,product+"\n \nShared Using Awesome Quotes App . get it Here ::  https://play.google.com/store/apps/details?id=skinfotech.com.quotes");
                startActivity(Intent.createChooser(sharingIntent,"Share using"));
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.rate) {
            String url = "https://play.google.com/store/apps/details?id=skinfotech.com.quotes";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
            Toast.makeText(this, "So Sweet :)", Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }



}
