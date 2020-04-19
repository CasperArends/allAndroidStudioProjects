package com.example.studentportal

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.add_portal.*

const val EXTRA_BUTTON = "EXTRA_REMINDER"

class startAddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_portal)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        initView()
    }

    private fun initView(){
        btnAddPortal.setOnClickListener{ onSaveClick()}
    }

    private fun onSaveClick(){
        if (etName.text.toString().isNotBlank()){
            val title = Link(etName.text.toString(), etURL.text.toString())
            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_BUTTON, title)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }else {
            Toast.makeText(this, "The title cannot be empty!", Toast.LENGTH_SHORT).show()
        }

        if (etURL.text.toString().isNotBlank()){
            val url = Link(etName.text.toString(), etURL.text.toString())
            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_BUTTON, url)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }else {
            Toast.makeText(this, "The URL cannot be empty!", Toast.LENGTH_SHORT).show()
        }


    }

}