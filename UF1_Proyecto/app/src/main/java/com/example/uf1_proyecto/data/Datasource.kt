package com.example.uf1_proyecto.data

class Datasource {
    fun loadQuestions(): List<Question> {
        return listOf<Question>(
            Question("Pregunta", true, options = listOf("A", "B")),
            Question("Pregunta2", true, options = listOf("A", "B")),
            Question("Pregunta4", true, options = listOf("A", "B")),
            Question("Pregunta3", true, options = listOf("A", "B"))

        )
    }

}