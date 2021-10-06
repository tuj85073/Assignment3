package edu.temple.fruitApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class SelectionActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = generateTestData()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val textView = findViewById<TextView>(R.id.textView)

        recyclerView.layoutManager = GridLayoutManager(this, 3)

        // View.OnClickListener is created in the activity
        // and then passed to adapter
        // This allows the onClick() callback
        // to have access to the activity's members
            val onClickListener = View.OnClickListener {
            val itemPosition = recyclerView.getChildAdapterPosition(it)

            imageView.setImageResource(items[itemPosition].resourceId)
            textView.text = items[itemPosition].description

        }



        recyclerView.adapter = ImageAdapter(items, onClickListener)
    }

    // Test data
    fun generateTestData(): Array<Item> {
        return arrayOf(Item(R.drawable.apple, "Apple")
            , Item(R.drawable.banana,"Banana")
            , Item(R.drawable.kiwi,"Kiwi")
            , Item(R.drawable.peach,"Peach")
            , Item(R.drawable.mango,"Mango")
            , Item(R.drawable.lemon,"Lemon")
            , Item(R.drawable.lychee,"Lychee")
            , Item(R.drawable.pears,"Pears")
            , Item(R.drawable.watermelon,"Watermelon")
            , Item(R.drawable.dragon,"Dragon Fruit"))
    }


}