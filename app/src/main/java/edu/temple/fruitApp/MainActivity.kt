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


class MainActivity : AppCompatActivity() {

    companion object {
        val ITEM_KEY = "key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lateinit var fragment1: SelectionFragment
        lateinit var displayFragment: DisplayFragment
        supportActionBar?.title = getString(R.string.Selector)

        val items = generateTestData()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)


        recyclerView.layoutManager = GridLayoutManager(this, 3)

        val onClickListener = View.OnClickListener {
            val itemPosition = recyclerView.getChildAdapterPosition(it)

            // Item object can be placed directly inside Intent because
            // the Item class implements the Parcelable interface



        }

        recyclerView.adapter = ImageAdapter(items, onClickListener)
    }

    // Test data
    fun generateTestData(): Array<Item> {
        return arrayOf(Item(R.drawable.apple, getString(R.string.Apple))
            , Item(R.drawable.banana,getString(R.string.Banana))
            , Item(R.drawable.kiwi,getString(R.string.Kiwi))
            , Item(R.drawable.peach,getString(R.string.Peach))
            , Item(R.drawable.mango,getString(R.string.Mango))
            , Item(R.drawable.lemon,getString(R.string.Lemon))
            , Item(R.drawable.lychee,getString(R.string.Lychee))
            , Item(R.drawable.pears,getString(R.string.Pears))
            , Item(R.drawable.watermelon,getString(R.string.Watermelon))
            , Item(R.drawable.dragon,getString(R.string.DragonFruit)))
    }


}