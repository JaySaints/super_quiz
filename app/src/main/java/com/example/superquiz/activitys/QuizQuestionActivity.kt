package com.example.superquiz.activitys

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.superquiz.R
import com.example.superquiz.data.ListOfQuestions
import com.example.superquiz.data.Question
import com.example.superquiz.utils.Const

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {
    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mQuestionsList = ListOfQuestions.getQuestions()

        setQuestion()

        val txtOptionOne = findViewById<TextView>(R.id.quiz_txt_option_one)
        val txtOptionTwo = findViewById<TextView>(R.id.quiz_txt_option_two)
        val txtOptionThree = findViewById<TextView>(R.id.quiz_txt_option_three)
        val txtOptionFour = findViewById<TextView>(R.id.quiz_txt_option_four)

        txtOptionOne.setOnClickListener(this)
        txtOptionTwo.setOnClickListener(this)
        txtOptionThree.setOnClickListener(this)
        txtOptionFour.setOnClickListener(this)
    }

    private fun setQuestion() {
        mCurrentPosition = 1
        val question = mQuestionsList!![mCurrentPosition - 1]

        defaultOptionView()

        val pbrProgressBar = findViewById<ProgressBar>(R.id.quiz_pbr_progressBar)
        val txtProgress = findViewById<TextView>(R.id.quiz_txt_progress)
        val txtQuestion = findViewById<TextView>(R.id.quiz_txt_question)
        val txtOptionOne = findViewById<TextView>(R.id.quiz_txt_option_one)
        val txtOptionTwo = findViewById<TextView>(R.id.quiz_txt_option_two)
        val txtOptionThree = findViewById<TextView>(R.id.quiz_txt_option_three)
        val txtOptionFour = findViewById<TextView>(R.id.quiz_txt_option_four)

        pbrProgressBar.progress = mCurrentPosition
        txtProgress.text = "$mCurrentPosition" + "/" + pbrProgressBar.max
        txtQuestion.text = question!!.question
        txtOptionOne.text = question.optionOne
        txtOptionTwo.text = question.optionTwo
        txtOptionThree.text = question.optionThree
        txtOptionFour.text = question.optionFour
    }

    private fun defaultOptionView() {
        val options = ArrayList<TextView>()
        val txtOptionOne = findViewById<TextView>(R.id.quiz_txt_option_one)
        val txtOptionTwo = findViewById<TextView>(R.id.quiz_txt_option_two)
        val txtOptionThree = findViewById<TextView>(R.id.quiz_txt_option_three)
        val txtOptionFour = findViewById<TextView>(R.id.quiz_txt_option_four)

        options.add(0, txtOptionOne)
        options.add(1, txtOptionTwo)
        options.add(2, txtOptionThree)
        options.add(3, txtOptionFour)

        for(option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }
    }

    override fun onClick(v: View?) {
        val txtOptionOne = findViewById<TextView>(R.id.quiz_txt_option_one)
        val txtOptionTwo = findViewById<TextView>(R.id.quiz_txt_option_two)
        val txtOptionThree = findViewById<TextView>(R.id.quiz_txt_option_three)
        val txtOptionFour = findViewById<TextView>(R.id.quiz_txt_option_four)

        when(v?.id) {
            R.id.quiz_txt_option_one -> {
                selectedOptionView(txtOptionOne, 1)
            }
            R.id.quiz_txt_option_two -> {
                selectedOptionView(txtOptionTwo, 2)
            }
            R.id.quiz_txt_option_three -> {
                selectedOptionView(txtOptionThree, 3)
            }
            R.id.quiz_txt_option_four -> {
                selectedOptionView(txtOptionFour, 4)
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)

    }
}