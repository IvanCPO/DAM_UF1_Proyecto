package com.example.uf1_proyecto.data

data class LineQuest (val ask: String, val numLevels: Int,var solution:Int? = null): Question(ask, sol = solution) {
}