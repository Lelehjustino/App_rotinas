package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun telaListaRotinas(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        // modifier = Modifier.fillMaxWidth().height(50.dp) -> so largura preenche tudo
        shape = RoundedCornerShape(20.dp),
        // minha cor nao funciona
        color = Color(52, 86, 96, 0)
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment =  Alignment.CenterHorizontally,
        ) {
            // card 1

            // card 2

            // card 3
        }
    }
}