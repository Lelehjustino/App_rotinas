package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ButtonDefaults
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
            Text(
                "Gerenciador de tempo"
            )

            Column(
                modifier = Modifier.padding(8.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment =  Alignment.CenterHorizontally,
            ) {
                CardRotina(
                    "Rotina #1", "Tempo 1h30"
                )

                CardRotina(
                    "Rotina #2", "Tempo 1h30"
                )

                CardRotina(
                    "Rotina #3", "Tempo 1h30"
                )

                CardRotina(
                    "Rotina #4", "Tempo 1h30"
                )
            }

            // Botao de adicionar rotina
            Botao("Adicionar rotina +"){

            }

            // app bar
            AppBar()
        }
    }
}

@Composable
fun CardRotina(
    titulo: String,
    descricao: String
) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(225, 82, 82)),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = titulo,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = descricao,
                color = Color.LightGray
            )
        }
    }
}

@Composable
fun Botao(
    titulo: String,
    acao: () -> Unit
) {
    Row(
    ) {
        Button(
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp, horizontal = 8.dp),
            shape = RoundedCornerShape(16.dp),    // cor do texto
            onClick = acao
        ) {
            Text(text = titulo)
        }
    }

}

@Composable
fun AppBar(
    selectedTab: Int = 0, // 0: Rotinas, 1: Progresso, 2: Perfil
    onTabSelected: (Int) -> Unit = {}
) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF3EFE0)), // Fundo levemente bege/off-white da tela
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            NavItem(
                label = "Rotinas",
                icon = Icons.Default.Home,
                isSelected = selectedTab == 0,
                onClick = { onTabSelected(0) },
                modifier = Modifier.weight(1f)
            )
            NavItem(
                label = "Progresso",
                icon = Icons.Default.Poll,
                isSelected = selectedTab == 1,
                onClick = { onTabSelected(1) },
                modifier = Modifier.weight(1f)
            )
            NavItem(
                label = "Perfil",
                icon = Icons.Default.Person,
                isSelected = selectedTab == 2,
                onClick = { onTabSelected(2) },
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
private fun NavItem(
    label: String,
    icon: ImageVector,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val activeColor = Color(0xFF4CAF50) // Verde igual ao do botão na imagem
    val inactiveColor = Color(0xFF9E9E9E) // Cinza desativado
    val contentColor = if (isSelected) activeColor else inactiveColor

    Column(
        modifier = modifier.clickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = contentColor,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = label,
            color = contentColor,
            fontSize = 12.sp,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
        )
    }
}