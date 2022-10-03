package com.gui.backend.dto

import com.gui.backend.domain.Cliente
import javax.validation.constraints.Email
import javax.validation.constraints.Size
import javax.validation.constraints.NotEmpty

data class ClienteDTO (
    var id: Int? = null,

    @get:NotEmpty(message = "Preenchimento obrigatório")
    @get:Size(message = "O tamanho deve ser entre 5 e 120 caracteres", min = 5, max = 120)
    var nome: String? = null,

    @get:NotEmpty(message = "Preenchimento obrigatório")
    @get:Email(message = "Email inválido")
    var email: String? = null
) {
    companion object Factory {
        fun createFromCliente(cliente: Cliente) = ClienteDTO(
            id = cliente.id,
            nome = cliente.nome,
            email = cliente.email
        )
    }
}