package com.example.swipequiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    private val questions = arrayListOf<Questions>()
    private val questionAdapter = QuestionAdapter(questions)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews(){
        rvQuestions.layoutManager = StaggeredGridLayoutManager(1,
            LinearLayoutManager.VERTICAL)
        rvQuestions.adapter = questionAdapter

        for (i in Questions.QUESTION.indices){
            questions.add(Questions(Questions.QUESTION[i], Questions.ANSWER[i]))
        }
//        Log.e("indices", Questions.QUESTION.indices.toString())
        createItemTouchHelper().attachToRecyclerView(rvQuestions)
        questionAdapter.notifyDataSetChanged()
    }


    private fun createItemTouchHelper (): ItemTouchHelper{

        val callback = object: ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }
            //Called when user swipes an item
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                var position = viewHolder.adapterPosition
                if (direction == ItemTouchHelper.RIGHT) checkAnswer(true, position)
                if (direction == ItemTouchHelper.LEFT) checkAnswer(false, position)

                questionAdapter.notifyDataSetChanged()
            }

        }
        return ItemTouchHelper(callback)

    }
    private fun checkAnswer(chosenvalue: Boolean, position: Int){
        val message = if (chosenvalue == Questions.ANSWER[position]) {
            "Right answer"
        } else {
            "Wrong answer"
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


}
