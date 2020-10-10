package skinfotech.com.quotes


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


class FeedBack : AppCompatActivity() {
    lateinit var btn_send:Button
    lateinit var email:EditText
    lateinit var title:EditText
    lateinit var message:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed_back)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        btn_send=findViewById(R.id.btn_send)
        email=findViewById(R.id.email)
        title=findViewById(R.id.title)
        message=findViewById(R.id.message)
        btn_send.setOnClickListener{
            sendFeedback()
        }
    }
    private fun sendFeedback() {
        val _Intent = Intent(Intent.ACTION_SEND)
        _Intent.type = "text/html"
        _Intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("sandhoshparamasivam@gmail.com"))
        _Intent.putExtra(Intent.EXTRA_SUBJECT, title.text.toString())
        _Intent.putExtra(Intent.EXTRA_TEXT,message.text.toString())
        startActivity(Intent.createChooser(_Intent, getString(R.string.title_send_feedback)))
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}