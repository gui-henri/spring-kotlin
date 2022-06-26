package com.gui.backend.dto

import com.gui.backend.domain.Categoria

data class CategoriaDTO(
    var id: Int? = null,
    var nome: String? = null
) {
    companion object Factory {
        fun createFromCategoria(categoria: Categoria) = CategoriaDTO(categoria.id, categoria.nome)
    }
}