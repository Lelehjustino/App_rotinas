package com.example.myapplication.ui.theme

data class Atividade(
    var idAtividade: Int = 0,
    var idRotina: Int = 0,
    var nomeAtividade: String = "",
    var duracaoMinutos: Double = 0.0
)

// Lista para armazenar as atividades
val listaAtividades = mutableListOf<Atividade>()