package com.example.myapplication

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.myapplication.ui.theme.Meta

class MetasViewModel : ViewModel() {

    // Lista de metas
    private val _metas = mutableStateListOf<Meta>()

    val metas: List<Meta>
        get() = _metas

    // Adicionar uma meta
    fun adicionarMeta(
        nome: String,
        descricao: String
    ) {

        val novoId =
            if (_metas.isEmpty()) {
                1
            } else {
                _metas.maxOf { it.idMeta } + 1
            }

        _metas.add(
            Meta(
                idMeta = novoId,
                nomeMeta = nome,
                descricaoMeta = descricao,
                concluida = false
            )
        )
    }

    // Marcar ou desmarcar uma meta
    fun alternarMeta(meta: Meta) {

        meta.concluida = !meta.concluida

        val index = _metas.indexOfFirst {
            it.idMeta == meta.idMeta
        }

        if (index != -1) {

            _metas[index] = Meta(
                idMeta = meta.idMeta,
                nomeMeta = meta.nomeMeta,
                descricaoMeta = meta.descricaoMeta,
                concluida = meta.concluida
            )
        }
    }

    // Excluir uma meta
    fun removerMeta(meta: Meta) {

        _metas.removeAll {
            it.idMeta == meta.idMeta
        }
    }
}
