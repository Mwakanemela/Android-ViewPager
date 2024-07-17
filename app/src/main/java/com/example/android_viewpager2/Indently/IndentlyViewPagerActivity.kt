package com.example.android_viewpager2.Indently

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.android_viewpager2.R
import me.relex.circleindicator.CircleIndicator3

class IndentlyViewPagerActivity : AppCompatActivity() {

    private var imagesList = mutableListOf<Int>()

    private lateinit var viewPager2: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_indently_view_pager)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        postToList()

        viewPager2 = findViewById(R.id.viewPager)

        viewPager2.adapter = ViewpagerAdapter(imagesList)
        viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        val indicator = findViewById<CircleIndicator3>(R.id.circleIndicator)
        indicator.setViewPager(viewPager2)
    }

    private fun addToList(image: Int) {
        imagesList.add(image)
    }

    private fun postToList() {
        for(i in 1..5) {
            addToList(R.mipmap.ic_launcher_round)
        }
    }
}