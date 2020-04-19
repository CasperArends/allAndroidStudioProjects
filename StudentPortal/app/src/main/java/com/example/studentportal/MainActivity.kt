package com.example.studentportal


import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.*

import kotlinx.android.synthetic.main.activity_main.*

const val ADD_BUTTON_REQUEST_CODE = 100

class MainActivity : AppCompatActivity() {

    private val links = arrayListOf<Link>()
    private val linkAdapter = LinkAdapter(links) {linkItem: Link -> linkItemClicked(linkItem)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fabAddPortal.setOnClickListener{addPortal()}

        initViews()
    }

    private fun linkItemClicked(linkItem: Link) {
        val builder = CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
        builder.setToolbarColor(ContextCompat.getColor(this, R.color.colorPrimary))
        customTabsIntent.launchUrl(this, Uri.parse(linkItem.url))
    }

    private fun initViews(){
        rvButtons.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        rvButtons.adapter = linkAdapter
        rvButtons.addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))

        for (i in Link.LINK_LINKS.indices){
            links.add(Link(Link.LINK_TITLES[i], Link.LINK_LINKS[i]))
        }
        linkAdapter.notifyDataSetChanged()
    }

    private fun addPortal(){
        val addActivityIntent = Intent(this, startAddActivity::class.java)
        startActivity(addActivityIntent)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK){
            when (requestCode){
                ADD_BUTTON_REQUEST_CODE -> {
                    val button = data!!.getParcelableExtra<Link>(EXTRA_BUTTON)
                    links.add(button)
                    linkAdapter.notifyDataSetChanged()
                }
            }
        }
    }




}
