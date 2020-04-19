package com.example.rockpaperscissors

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_history.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HistoryActivity : AppCompatActivity(){

    private val history = arrayListOf<RockPaperScissor>()
    private val historyAdapter = HistoryAdapter(history)
    private lateinit var historyRepository : HistoryRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        historyRepository = HistoryRepository(this)
        initViews()

    }

    private fun initViews(){
        rvScores.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rvScores.adapter = historyAdapter
        rvScores.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        getGamesFromDatabase()
    }

    private fun deleteHistory(){
        CoroutineScope(Dispatchers.Main).launch{
            withContext(Dispatchers.IO){
                historyRepository.deleteAllGames()
            }
            getGamesFromDatabase()
        }
    }

    private fun getGamesFromDatabase(){
        CoroutineScope(Dispatchers.Main).launch{
            val resultList = withContext(Dispatchers.IO){
                historyRepository.getAllGames()
            }
            this@HistoryActivity.history.clear()
            this@HistoryActivity.history.addAll(resultList)
            this@HistoryActivity.historyAdapter.notifyDataSetChanged()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.history_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.btnDelete -> {
                deleteHistory()
                true
            }
            android.R.id.home -> {
                val resultIntent = Intent()
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}