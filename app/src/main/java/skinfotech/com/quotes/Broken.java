package skinfotech.com.quotes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Broken extends AppCompatActivity {

ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        listView=findViewById(R.id.listView);
        InterstitialAd  mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3643602219143275/5179430091");
        AdRequest Request = new AdRequest.Builder()
                .build();
        mInterstitialAd.loadAd(Request);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
        String[] arr = getResources().getStringArray(R.array.sad);
        listView.setAdapter(new ArrayAdapter<String>(this, R.layout.activity_motivational, R.id.motivational, arr));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String product = ((TextView) view).getText().toString();
                Intent i = new Intent(getApplicationContext(), ViewQuoteActivity.class);
                // sending data to new activity
                i.putExtra("product", product);
                startActivity(i);

            }
        });
    }


}