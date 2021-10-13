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

    companion object {
        val ITEM_KEY = "key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Selector"

        val items = generateTestData()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)


        recyclerView.layoutManager = GridLayoutManager(this, 3)

        val onClickListener = View.OnClickListener {
            val itemPosition = recyclerView.getChildAdapterPosition(it)

            // Item object can be placed directly inside Intent because
            // the Item class implements the Parcelable interface
            val launchIntent = Intent(this, DisplayActivity::class.java)
                .putExtra(ITEM_KEY, items[itemPosition])

            startActivity(launchIntent)
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