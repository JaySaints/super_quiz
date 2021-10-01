package com.example.superquiz.activitys

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.superquiz.R
import com.example.superquiz.data.ListOfQuestions
import com.example.superquiz.data.Question
import com.example.superquiz.utils.Const

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {
    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0
    private var mUserName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mUserName = intent.getStringExtra(Const.USER_NAME)

        // Está variavel irá receber a lista de perguntas contidas no arquivo ListOfQuestions
        mQuestionsList = ListOfQuestions.getQuestions()

        setQuestion()

        val btnSubmit = findViewById<Button>(R.id.quiz_btn_submit)
        val txtOptionOne = findViewById<TextView>(R.id.quiz_txt_option_one)
        val txtOptionTwo = findViewById<TextView>(R.id.quiz_txt_option_two)
        val txtOptionThree = findViewById<TextView>(R.id.quiz_txt_option_three)
        val txtOptionFour = findViewById<TextView>(R.id.quiz_txt_option_four)

        txtOptionOne.setOnClickListener(this)
        txtOptionTwo.setOnClickListener(this)
        txtOptionThree.setOnClickListener(this)
        txtOptionFour.setOnClickListener(this)
        btnSubmit.setOnClickListener(this)
    }

    // Pega a questão com suas informações e atribui nos elementos da tela
    private fun setQuestion() {
        // mCurrentPosition = 1

        val question = mQuestionsList!![mCurrentPosition - 1]

        defaultOptionView()



        val pbrProgressBar = findViewById<ProgressBar>(R.id.quiz_pbr_progressBar)
        val txtProgress = findViewById<TextView>(R.id.quiz_txt_progress)
        val txtQuestion = findViewById<TextView>(R.id.quiz_txt_question)
        val txtOptionOne = findViewById<TextView>(R.id.quiz_txt_option_one)
        val txtOptionTwo = findViewById<TextView>(R.id.quiz_txt_option_two)
        val txtOptionThree = findViewById<TextView>(R.id.quiz_txt_option_three)
        val txtOptionFour = findViewById<TextView>(R.id.quiz_txt_option_four)
        val btnSubmit = findViewById<Button>(R.id.quiz_btn_submit)

        pbrProgressBar.progress = mCurrentPosition
        txtProgress.text = "$mCurrentPosition" + "/" + pbrProgressBar.max
        txtQuestion.text = question!!.question
        txtOptionOne.text = question.optionOne
        txtOptionTwo.text = question.optionTwo
        txtOptionThree.text = question.optionThree
        txtOptionFour.text = question.optionFour

        if(mCurrentPosition == mQuestionsList!!.size) {
            btnSubmit.text = "FIM"
        } else {
            btnSubmit.text = "RESPONDER"
        }
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

    // Implementa evento onclick para realizar a seleção das resposta
    override fun onClick(v: View?) {
        val txtOptionOne = findViewById<TextView>(R.id.quiz_txt_option_one)
        val txtOptionTwo = findViewById<TextView>(R.id.quiz_txt_option_two)
        val txtOptionThree = findViewById<TextView>(R.id.quiz_txt_option_three)
        val txtOptionFour = findViewById<TextView>(R.id.quiz_txt_option_four)
        val btnSubmit = findViewById<Button>(R.id.quiz_btn_submit)

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
            R.id.quiz_btn_submit -> {
                if(mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                        } else -> {
                            //Toast.makeText(this, "Você completou o Super Quiz com sucesso!", Toast.LENGTH_LONG).show()
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Const.USER_NAME, mUserName)
                            intent.putExtra(Const.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Const.TOTAL_QUESTIONS, mQuestionsList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question = mQuestionsList?.get(mCurrentPosition - 1)
                    if(question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }else {
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if(mCurrentPosition == mQuestionsList!!.size) {
                        btnSubmit.text = "FIM"
                    } else {
                        btnSubmit.text = "Próxima Pergunta"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        val txtOptionOne = findViewById<TextView>(R.id.quiz_txt_option_one)
        val txtOptionTwo = findViewById<TextView>(R.id.quiz_txt_option_two)
        val txtOptionThree = findViewById<TextView>(R.id.quiz_txt_option_three)
        val txtOptionFour = findViewById<TextView>(R.id.quiz_txt_option_four)

        when(answer) {
            1 -> {
                txtOptionOne.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 -> {
                txtOptionTwo.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 -> {
                txtOptionThree.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 -> {
                txtOptionFour.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }

    // Função responsável por fazer a seleção dos TextView
    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)

    }
}