package com.example.studentportal

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    
    private val links = arrayListOf<Link>()
    private val linkAdapter = LinkAdapter(links)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews(){}

}
