package com.example.superquiz.activitys

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.superquiz.R
import com.example.superquiz.utils.Const
import org.w3c.dom.Text

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val username = intent.getStringExtra(Const.USER_NAME)
        val txtUsername = findViewById<TextView>(R.id.result_txt_username)
        txtUsername.text = username

        val correctAnswers = intent.getIntExtra(Const.CORRECT_ANSWERS, 0)
        val totalQuestions = intent.getIntExtra(Const.TOTAL_QUESTIONS, 0)

        val txtScore = findViewById<TextView>(R.id.result_txt_score)
        txtScore.text = "Você acertou: $correctAnswers de $totalQuestions"

        val btnFinish = findViewById<Button>(R.id.result_btn_finish)
        btnFinish.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        val btnSearch = findViewById<Button>(R.id.result_btn_search)
        btnSearch.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_TEXT, "Veja minha pontuação no Super Quiz! $username acertou $correctAnswers de $totalQuestions perguntas.")
            intent.setType("text/plain")
            intent.setPackage("com.whatsapp")
            startActivity(intent)
        }
    }
}