package com.example.myapplication

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Atividade(val nome: String, val duracao: String)

@Preview(showBackground = true)
@Composable
fun TelaCriacao() {
    val begeFundo = Color(0xFFF3EFE0)
    val verdeCampo = Color(0xFF38B560)
    val verdeTexto = Color(0xFF7D8C7A)

    val context = LocalContext.current

    var nomeRotina by remember { mutableStateOf("Rotina #6") }
    var inicio by remember { mutableStateOf("08:00") }
    var fim by remember { mutableStateOf("09:00") }
    var nomeAtividade by remember { mutableStateOf("") }
    var duracaoAtividade by remember { mutableStateOf("") }
    val atividades = remember { mutableStateListOf<Atividade>() }

    Surface(modifier = Modifier.fillMaxSize(), color = begeFundo) {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { },
                    modifier = Modifier.size(40.dp)
                        .background(Color(0xFFE2DDD0), shape = CircleShape)
                ) {
                    Icon(Icons.AutoMirrored.Filled.KeyboardArrowLeft, "Voltar", tint = Color.Black)
                }

                Text(
                    text = nomeRotina.ifBlank { "Sem nome" },
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Button(
                    onClick = {
                        val msg = if (nomeRotina.isBlank())
                            "Dê um nome à rotina"
                        else
                            "Rotina \"$nomeRotina\" salva com ${atividades.size} atividade(s)"
                        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF5252)),
                    shape = RoundedCornerShape(12.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    Text("Salvar rotina", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 14.sp)
                }
            }

            Spacer(Modifier.height(16.dp))

            CampoTexto(
                valor = nomeRotina,
                aoMudar = { nomeRotina = it },
                placeholder = "Nome da rotina",
                cor = verdeCampo
            )

            Spacer(Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Column(Modifier.weight(1f)) {
                    Text("Início", fontSize = 12.sp, color = verdeTexto,
                        modifier = Modifier.padding(bottom = 4.dp))
                    CampoTexto(
                        valor = inicio,
                        aoMudar = { inicio = it },
                        placeholder = "00:00",
                        cor = verdeCampo,
                        icone = { Icon(Icons.Default.List, "Horário início", tint = Color.Black) }
                    )
                }
                Column(Modifier.weight(1f)) {
                    Text("Fim", fontSize = 12.sp, color = verdeTexto,
                        modifier = Modifier.padding(bottom = 4.dp))
                    CampoTexto(
                        valor = fim,
                        aoMudar = { fim = it },
                        placeholder = "00:00",
                        cor = verdeCampo,
                        icone = { Icon(Icons.Default.List, "Horário fim", tint = Color.Black) }
                    )
                }
            }

            Spacer(Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    CampoTexto(nomeAtividade, { nomeAtividade = it }, "Nome atividade:", verdeCampo)
                    CampoTexto(
                        duracaoAtividade,
                        { duracaoAtividade = it.filter { c -> c.isDigit() } },
                        "Duração (min):",
                        verdeCampo,
                        somenteNumeros = true
                    )
                }

                Row(
                    modifier = Modifier.size(width = 64.dp, height = 108.dp)
                        .background(verdeCampo, shape = RoundedCornerShape(12.dp)),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = {
                        if (nomeAtividade.isBlank() || duracaoAtividade.isBlank()) {
                            Toast.makeText(context, "Preencha nome e duração", Toast.LENGTH_SHORT).show()
                        } else {
                            atividades.add(Atividade(nomeAtividade, duracaoAtividade))
                            Toast.makeText(context, "\"$nomeAtividade\" adicionada", Toast.LENGTH_SHORT).show()
                            nomeAtividade = ""
                            duracaoAtividade = ""
                        }
                    }) {
                        Icon(Icons.Default.Add, "Adicionar", tint = Color.White,
                            modifier = Modifier.size(32.dp))
                    }
                }
            }

            Spacer(Modifier.height(16.dp))

            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                items(atividades) { a ->
                    Row(
                        modifier = Modifier.fillMaxWidth().height(44.dp)
                            .background(Color(0xFFE2DDD0), RoundedCornerShape(12.dp))
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(a.nome, color = Color.Black, fontWeight = FontWeight.Bold)
                        Text("${a.duracao} min", color = verdeTexto)
                    }
                }
            }
        }
    }
}

@Composable
private fun CampoTexto(
    valor: String,
    aoMudar: (String) -> Unit,
    placeholder: String,
    cor: Color,
    somenteNumeros: Boolean = false,
    icone: (@Composable () -> Unit)? = null
) {
    Row(
        modifier = Modifier.fillMaxWidth().height(48.dp)
            .background(cor, shape = RoundedCornerShape(12.dp))
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(Modifier.weight(1f)) {
            if (valor.isEmpty()) {
                Text(placeholder, color = Color.White.copy(alpha = 0.6f), fontSize = 16.sp)
            }
            BasicTextField(
                value = valor,
                onValueChange = aoMudar,
                singleLine = true,
                textStyle = TextStyle(
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                ),
                cursorBrush = SolidColor(Color.White),
                keyboardOptions = KeyboardOptions(
                    keyboardType = if (somenteNumeros) KeyboardType.Number else KeyboardType.Text,
                    capitalization = KeyboardCapitalization.Sentences
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }
        icone?.invoke()
    }
}