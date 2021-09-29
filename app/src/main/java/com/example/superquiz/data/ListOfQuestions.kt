package com.example.superquiz.data

object ListOfQuestions {
    fun getQuestions() : ArrayList<Questions> {
        val questionsList = ArrayList<Questions>()

        val que1 = Questions(1,
            "Qual dos seguintes super heróis não é da DC Comics?",
            1,
            "Lanterna Verde",
            "Homem-aranha",
            "Superman",
            "Aquaman",
            2
        )
        questionsList.add(que1)

        val que2 = Questions(2,
            "Qual o verdadeiro nome do Superman?",
            2,
            "Michael Caio",
            "João Mecias",
            "Clark Kent",
            "Kal-el",
            3
        )
        questionsList.add(que2)

        val que3 = Questions(3,
            "Quem matou os pais do Batman?",
            3,
            "Coringa",
            "Chapolim Colorado",
            "Joe-Chill",
            "Pinguim",
            1
        )
        questionsList.add(que3)

        return questionsList
    }
}