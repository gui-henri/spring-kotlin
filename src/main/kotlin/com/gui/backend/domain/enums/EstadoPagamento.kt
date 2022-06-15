package com.gui.backend.domain.enums

enum class EstadoPagamento(val id: Int, val descricao: String) {
    PENDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(3, "Cancelado")
}