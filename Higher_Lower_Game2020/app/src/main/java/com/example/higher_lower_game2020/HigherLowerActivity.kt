package com.example.higher_lower_game2020

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class HigherLowerActivity : AppCompatActivity() {

    private var currentThrow: Int = 1;
    private var lastThrow: Int = 1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews();
    }

    fun updateUI(){
        LastThrowID.text = getString(R.string.last_throw, lastThrow)

        if (currentThrow == 1)
        imageDice.setImageResource(R.drawable.dice1)
        else if (currentThrow == 2)
            imageDice.setImageResource(R.drawable.dice2)
        else if (currentThrow == 3)
            imageDice.setImageResource(R.drawable.dice3)
        else if (currentThrow == 4)
            imageDice.setImageResource(R.drawable.dice4)
        else if (currentThrow == 5)
            imageDice.setImageResource(R.drawable.dice5)
        else if (currentThrow == 6)
            imageDice.setImageResource(R.drawable.dice6)

    }

    fun initViews(){
        higherButton.setOnClickListener{
            OnHigherClick()
        }
        equalButton.setOnClickListener{
            OnEquelClick()
        }
        lowerButton.setOnClickListener{
            OnLowerClick()
        }

        updateUI()
    }

    fun rollDice(){
        lastThrow = currentThrow;
        currentThrow = (1..6).random()
        updateUI()
    }

    private fun OnAnswerCorrect(){
        Toast.makeText(this, "oke Cool, that right", Toast.LENGTH_LONG).show()
    }
    private fun OnAnswerInCorrect(){
        Toast.makeText(this, "Sorry my dude, incorrect", Toast.LENGTH_LONG).show()
    }

    private fun OnLowerClick(){
        rollDice()
        if (currentThrow < lastThrow){
            OnAnswerCorrect()
        }
        else
            OnAnswerInCorrect()

    }

    private fun OnEquelClick(){
        rollDice()
        if (currentThrow == lastThrow){
            OnAnswerCorrect()
        }
        else
            OnAnswerInCorrect()
    }

    private fun OnHigherClick(){

        rollDice()
        if (currentThrow > lastThrow){
            OnAnswerCorrect()
        }
        else
            OnAnswerInCorrect()
    }


}
