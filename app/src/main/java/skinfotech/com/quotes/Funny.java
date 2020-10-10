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

public class Funny extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        InterstitialAd mInterstitialAd = new InterstitialAd(this);
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
        ListView listView=findViewById(R.id.listView);


        // storing string resources into Array
        String[] arr = getResources().getStringArray(R.array.funny);
        listView.setAdapter(new ArrayAdapter<String>(this, R.layout.activity_motivational, R.id.motivational, arr));
        // Binding resources Array to ListAdapter
//        this.setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_motivational, R.id.motivational, arr));

//        Window window = getWindow();
//        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

//        ListView lv = getListView();
//        lv.setBackgroundResource(R.color.colorPrimary);
//        window.setStatusBarColor(ContextCompat.getColor(this,R.color.colorPrimary));
        // listening to single list item on click
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // selected item
                String product = ((TextView) view).getText().toString();

                // Launching new Activity on selecting single List Item
                Intent i = new Intent(getApplicationContext(), ViewQuoteActivity.class);
                // sending data to new activity
                i.putExtra("product", product);
                startActivity(i);

            }
        });
    }

}