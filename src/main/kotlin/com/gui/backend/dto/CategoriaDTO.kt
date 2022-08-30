package com.gui.backend.dto

import com.gui.backend.domain.Categoria
import org.hibernate.validator.constraints.Length
import javax.validation.constraints.NotEmpty

data class CategoriaDTO(
    var id: Int? = null,

    @get:NotEmpty(message = "Preenchimento obrigatório")
    @get:Length(min = 5, max = 80, message = "O tamanho deve ser entre 5 e 80 caracteres")
    var nome: String? = null
) {
    companion object Factory {
        fun createFromCategoria(categoria: Categoria) = CategoriaDTO(categoria.id, categoria.nome)
    }
}