package com.example.uf1_proyecto.data

class Datasource {
    fun loadQuestions(): List<Question> {
        return listOf<Question>(
            Question("Pregunta", true, listOf("A", "B"), 0),
            Question("Pregunta2", true, listOf("c", "d"), 0),
            Question("Pregunta4", true, listOf("g", "h"), 0),
            Question("Pregunta3", true, listOf("m", "Bi"), 0)

        )
    }

}