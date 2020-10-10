package skinfotech.com.quotes

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.NativeExpressAdView
import com.google.android.gms.ads.reward.RewardedVideoAd
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {
    lateinit var mAdView : AdView
    lateinit var adView1 : AdView
    private lateinit var mRewardedVideoAd: RewardedVideoAd
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

//        ca-app-pub-3643602219143275~7915088851


        //ca-app-pub-3643602219143275/7805593437     Banner


        //ca-app-pub-3643602219143275/5179430091   Interestial

//        ca-app-pub-3643602219143275/2553266757    Reward

        //ca-app-pub-3643602219143275/6774231723    Native ads
//        MobileAds.initialize(this) { }
//        MobileAds.initialize(this){}
        MobileAds.initialize(this,("ca-app-pub-3643602219143275~7915088851"))
        mAdView = findViewById(R.id.adView)
        adView1 = findViewById(R.id.adView1)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
        val dRequest = AdRequest.Builder().build()
        adView1.loadAd(dRequest)
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this)
        loadRewardedVideoAd()

        //Mobile Ads
        val adView = findViewById<AdView>(R.id.nativeadView)
        val dRequests = AdRequest.Builder().build()
        adView.loadAd(dRequests)


        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()
        navigationView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.about_app -> {
                    val intent = Intent(this@MainActivity, AboutApp::class.java)
                    startActivity(intent)
                }
                R.id.feedback -> {
                    val intent = Intent(this@MainActivity, FeedBack::class.java)
                    startActivity(intent)
                }
                R.id.rate_app -> {
                    val url = "https://play.google.com/store/apps/details?id=skinfotech.com.quotes"
                    val i = Intent(Intent.ACTION_VIEW)
                    i.data = Uri.parse(url)
                    startActivity(i)
                    Toast.makeText(this@MainActivity, "So Sweet :)", Toast.LENGTH_LONG).show()
                }
                R.id.share -> {
                    val shareIntent = Intent(Intent.ACTION_SEND)
                    shareIntent.type = "text/plain"
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Quotes")
                    var shareMessage = "\nLet me recommend you this application for lovely quotes and motivational quotes\n\n"
                    shareMessage = """
                        ${shareMessage}https://play.google.com/store/apps/details?id=${BuildConfig.APPLICATION_ID}""".trimIndent()
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
                    startActivity(Intent.createChooser(shareIntent, "choose one"))
                }
            }
            val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
            drawer.closeDrawer(GravityCompat.START)
            false
        }
        val b1 = findViewById<View>(R.id.button1) as Button
        b1.setOnClickListener {
            val intent = Intent(this@MainActivity, Motivational::class.java)
            startActivity(intent)
        }
        val b2 = findViewById<View>(R.id.button2) as Button
        b2.setOnClickListener {
            val intent = Intent(this@MainActivity, Friendship::class.java)
            startActivity(intent)
        }
        val b3 = findViewById<View>(R.id.button3) as Button
        b3.setOnClickListener {
            val intent = Intent(this@MainActivity, Funny::class.java)
            startActivity(intent)
        }
        val b4 = findViewById<View>(R.id.button4) as Button
        b4.setOnClickListener {
            val intent = Intent(this@MainActivity, Love::class.java)
            startActivity(intent)
        }
        val b5 = findViewById<View>(R.id.button5) as Button
        b5.setOnClickListener {
            val intent = Intent(this@MainActivity, Lessons::class.java)
            startActivity(intent)
        }
        val b6 = findViewById<View>(R.id.button6) as Button
        b6.setOnClickListener {
            val intent = Intent(this@MainActivity, Broken::class.java)
            startActivity(intent)
        }
        val b7 = findViewById<View>(R.id.button7) as Button
        b7.setOnClickListener {
            val intent = Intent(this@MainActivity, Dream::class.java)
            startActivity(intent)
        }
        val b8 = findViewById<View>(R.id.button8) as Button
        b8.setOnClickListener {
            val intent = Intent(this@MainActivity, Workout::class.java)
            startActivity(intent)
        }
        val b9 = findViewById<View>(R.id.button9) as Button
        b9.setOnClickListener {
            val intent = Intent(this@MainActivity, Music::class.java)
            startActivity(intent)
        }
        val b10 = findViewById<View>(R.id.button10) as Button
        b10.setOnClickListener {
            val intent = Intent(this@MainActivity, Sports::class.java)
            startActivity(intent)
        }
        val b11 = findViewById<View>(R.id.button11) as Button
        b11.setOnClickListener {
            val intent = Intent(this@MainActivity, Success::class.java)
            startActivity(intent)
        }

        //Images

        //Images
//        val bimages = findViewById<View>(R.id.b1) as Button
//        bimages.setOnClickListener {
//            val intent = Intent(this@MainActivity, Images::class.java)
//            startActivity(intent)
//        }

        //Submission Section

//        //Submission Section
//        val submit = findViewById<View>(R.id.submit) as Button
//        submit.setOnClickListener {
//            val email = Intent(Intent.ACTION_SEND)
//            email.putExtra(Intent.EXTRA_EMAIL, arrayOf("droidxp.com@gmail.com"))
//            email.putExtra(Intent.EXTRA_SUBJECT, "Quote Submission")
//            email.putExtra(Intent.EXTRA_TEXT, "Quote : ")
//            email.type = "message/rfc822"
//            startActivity(Intent.createChooser(email, "Choose an Email client"))
//        }
//        val submissions = findViewById<View>(R.id.submissions) as Button
//        submissions.setOnClickListener {
//            val intent = Intent(this@MainActivity, Submission::class.java)
//            startActivity(intent)
//        }

    }

    private fun loadRewardedVideoAd() {
        mRewardedVideoAd.loadAd("ca-app-pub-3643602219143275/2553266757",
                AdRequest.Builder().build())

    }

    override fun onBackPressed() {
        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            AlertDialog.Builder(this)
                    .setTitle("Really Exit ?")
                    .setMessage("Are you sure you want to exit ?")
                    .setIcon(R.drawable.door)
                    .setNegativeButton(android.R.string.no, null)
                    .setPositiveButton(R.string.yes) { arg0, arg1 ->
                        AlertDialog.Builder(this@MainActivity)
                                .setTitle("How about Rating us")
                                .setMessage("That Motivates Us ! Would you ?")
                                .setPositiveButton(R.string.abs) { dialog, Button ->
                                    val url = "https://play.google.com/store/apps/details?id=skinfotech.com.quotes"
                                    val i = Intent(Intent.ACTION_VIEW)
                                    i.data = Uri.parse(url)
                                    startActivity(i)
                                }
                                .setNegativeButton(R.string.no) { arg0, arg1 -> super@MainActivity.onBackPressed() }.create().show()
                    }.create().show()
        }
    }

}
