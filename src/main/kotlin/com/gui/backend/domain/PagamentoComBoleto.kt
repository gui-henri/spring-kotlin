package com.gui.backend.domain

import com.gui.backend.domain.enums.EstadoPagamento
import java.util.Date
import javax.persistence.Entity

@Entity
class PagamentoComBoleto(
    id: Int? = null,
    estadoPagamento: Int? = null,
    pedido: Pedido? = null,
    var dataVencimento: Date? = null,
    var dataPagamento: Date? = null
): Pagamento(id, estadoPagamento, pedido)