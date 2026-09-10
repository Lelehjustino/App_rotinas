package com.example.myapplication.ui.theme

class Rotina(
    var idRotina: Int = 0,
    var nomeRotina: String = "",
    var tempoMinutosRotina: Double = 0.0
)

// Lista contendo as rotinas
val listaRotinas: MutableList<Rotina> = mutableListOf()