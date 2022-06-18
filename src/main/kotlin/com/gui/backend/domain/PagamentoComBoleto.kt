package com.gui.backend.domain

import com.fasterxml.jackson.annotation.JsonFormat
import java.util.Date
import javax.persistence.Entity

@Entity
class PagamentoComBoleto(
    id: Int? = null,
    estadoPagamento: String? = null,
    pedido: Pedido? = null,
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    var dataVencimento: Date? = null,
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    var dataPagamento: Date? = null
): Pagamento(id, estadoPagamento, pedido)