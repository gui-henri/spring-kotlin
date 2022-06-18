package com.gui.backend.domain

import com.gui.backend.domain.enums.EstadoPagamento
import javax.persistence.Entity

@Entity
class PagamentoComCartao(
    id: Int? = null,
    estadoPagamento: String? = null,
    pedido: Pedido? = null,
    var numeroDeParcelas: Int? = null

): Pagamento(id, estadoPagamento, pedido)