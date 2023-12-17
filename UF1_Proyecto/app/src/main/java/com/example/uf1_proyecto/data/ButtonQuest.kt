package com.example.uf1_proyecto.data

data class ButtonQuest (val ask: String, var options: List<String>,var solution:Int? = null): Question(ask, sol = solution) {
}