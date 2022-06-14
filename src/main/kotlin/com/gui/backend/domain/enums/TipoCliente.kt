package com.gui.backend.domain.enums

enum class TipoCliente(val id: Int, val descricao: String) {
    PESSOA_FISICA(1, "Pessoa Física"),
    PESSOA_JURIDICA(2, "Pessoa Jurídica");

    companion object {
        fun toEnum(id: Int): TipoCliente {

            for (tipo in TipoCliente.values()) {
                if (id == tipo.id){
                    return tipo
                }
            }
            throw IllegalArgumentException("Id inválido: $id")
        }
    }
}