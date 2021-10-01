package com.example.superquiz.data

import com.example.superquiz.R

object ListOfQuestions {
    fun getQuestions() : ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val que1 = Question(1,
            "Qual dos seguintes super heróis não é da DC Comics?",
            R.drawable.img_whenis,
            "Lanterna Verde",
            "Homem-aranha",
            "Superman",
            "Aquaman",
            2
        )
        questionsList.add(que1)

        val que2 = Question(2,
            "Qual o verdadeiro nome do Superman?",
            R.drawable.img_superman,
            "Michael Caio",
            "João Mecias",
            "Clark Kent",
            "Kal-el",
            3
        )
        questionsList.add(que2)

        val que3 = Question(3,
            "Quem matou os pais do Batman?",
            R.drawable.img_batman,
            "Coringa",
            "Chapolim Colorado",
            "Joe-Chill",
            "Pinguim",
            1
        )
        questionsList.add(que3)


        val que4 = Question(4,
            "O que tira os super poderes do Superman?",
            R.drawable.img_superman_2,
            "Espinafre",
            "Criptonita",
            "Arroz e Feijão",
            "Sol Amarelo",
            2
        )
        questionsList.add(que4)

        val que5 = Question(5,
            "Quem é o protetor de Kahndaq?",
            R.drawable.img_whenis,
            "Lanterna Verde",
            "Adão Negro",
            "Homem-aranha",
            "Aquaman",
            2
        )
        questionsList.add(que5)

        val que6 = Question(6,
            "O que Billy Batson faz para se tornar Shazam?",
            R.drawable.img_shazam,
            "Gritando Shazam",
            "Quando sua adrenalina sobe",
            "Absorvendo energia solar",
            "Se torna Shazam quando é morto",
            1
        )
        questionsList.add(que6)

        return questionsList
    }
}