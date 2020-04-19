package com.example.rockpaperscissors

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class MainActivity : AppCompatActivity() {

   private lateinit var historyRepository: HistoryRepository

    private var computerState: Int = 0
    private var playerState: Int = 0
    private var wins: Int = 0
    private var loses: Int = 0
    private var draw: Int = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Rock, Paper, Scissors Kotlin"
        historyRepository = HistoryRepository(this)
        initViews()
    }


    private fun initViews() {
        ibRock.setOnClickListener() {
            onRockClick()
        }
        ibPaper.setOnClickListener() {
            onPaperClick()
        }
        ibScissors.setOnClickListener() {
            onScissorsClick()
        }
    }

    private fun addGamesToDatabase() {
        CoroutineScope(Dispatchers.Main).launch {
            val rps = RockPaperScissor(
                win = wins,
                lose = loses,
                draw = draw,
                playerChoice = playerState,
                computerChoice = computerState,
                date = Date().toString()
            )
            withContext(Dispatchers.IO) {
                historyRepository.insertGame(rps)
            }


        }
    }

    private fun changeHand() {
        // computerState 0 == rock
        // computerState 1 == paper
        // computerState 2 == scissors

        computerState = (0..2).random()

        if (computerState == 0) {
            ivComputer.setImageResource(R.drawable.rock)
        } else if (computerState == 1) {
            ivComputer.setImageResource(R.drawable.paper)
        } else if (computerState == 2) {
            ivComputer.setImageResource(R.drawable.scissors)
        }
    }

    private fun updateScore() {
        //draw
        if (playerState == computerState) {
            draw++
            tvScore.setText(R.string.draw)
        }

        //rock
        else if (playerState == 0) {
            if (computerState == 1) {
                loses++
                tvScore.setText(R.string.lose)
            } else if (computerState == 2) {
                wins++
                tvScore.setText(R.string.win)
            }
        }

        //paper
        else if (playerState == 1) {
            if (computerState == 2) {
                loses++
                tvScore.setText(R.string.lose)
            } else if (computerState == 0) {
                wins++
                tvScore.setText(R.string.win)
            }
        }

        //scissors
        else if (playerState == 2) {
            if (computerState == 0) {
                loses++
                tvScore.setText(R.string.lose)
            } else if (computerState == 1) {
                wins++
                tvScore.setText(R.string.win)
            }
        }

        tvStatistics.text =
            ("Your all time staticstics\nWin: " + wins + "Draw: " + draw + "Lose: " + loses)

    }

    private fun onRockClick() {
        changeHand()
        playerState = 0
        ivPlayer.setImageResource(R.drawable.rock)
        updateScore()
        addGamesToDatabase()
    }

    private fun onPaperClick() {
        changeHand()
        playerState = 1
        ivPlayer.setImageResource(R.drawable.paper)
        updateScore()
        addGamesToDatabase()
    }

    private fun onScissorsClick() {
        changeHand()
        playerState = 2
        ivPlayer.setImageResource(R.drawable.scissors)
        updateScore()
        addGamesToDatabase()
    }

    private fun goToHistory() {
        val intent = Intent(this, HistoryActivity::class.java)
        startActivity(intent)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.btnDelete -> {
                goToHistory()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
