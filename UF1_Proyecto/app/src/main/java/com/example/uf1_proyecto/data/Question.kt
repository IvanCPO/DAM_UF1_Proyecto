package com.example.uf1_proyecto.data

data class Question (val title: String, val  isRadio: Boolean, var options: List<String>?=null , val level: Int?=null, var  sol: Int? = null){


}