package com.example.superquiz.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.superquiz.R
import com.example.superquiz.data.ListOfQuestions
import com.example.superquiz.utils.Const

class QuizQuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        val questionsList = ListOfQuestions.getQuestions()

        Log.i(Const.TAG, "${questionsList.size}")
    }
}