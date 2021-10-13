package edu.temple.fruitApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        // Set the title for the activity.
        // This can also be done in the manifest
        supportActionBar?.title = getString(R.string.Displayer)

        val imageView = findViewById<ImageView>(R.id.imageView)
        val textView = findViewById<TextView>(R.id.textView)

        // Fetch the intent used to launch this activity
        val item = intent.getParcelableExtra<Item>(SelectionActivity.ITEM_KEY)

        /**
         * Use Item object found in intent to set view values
         *
         * Using ?.let{} is equivalent to:
         *  if (item != null) {
         *      imageView.setImageResource(item.resourceId)
         *      textView.text = item.description
         *  }
         */

        item?.resourceId?.let { imageView.setImageResource(it) }
        item?.description?.let { textView.text = it }
    }
}