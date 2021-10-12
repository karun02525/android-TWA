package com.texweb

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent





class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val edt = findViewById<EditText>(R.id.url)
        edt.setText("https://rest-apis-web.herokuapp.com")

       val  url = edt.text.toString()


        val fab = findViewById<Button>(R.id.btn)

        fab.setOnClickListener {
            CustomTabsIntent.Builder().build().launchUrl(this, Uri.parse(url))

           // launchNativeApi30(this,Uri.parse(url))

        }
    }




    private fun launchNativeApi30(context: Context, uri: Uri?): Boolean {
        val nativeAppIntent = Intent(Intent.ACTION_VIEW, uri)
            .addCategory(Intent.CATEGORY_BROWSABLE)
            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_REQUIRE_NON_BROWSER)
        return try {
            context.startActivity(nativeAppIntent)
            true
        } catch (ex: ActivityNotFoundException) {
            false
        }
    }

}