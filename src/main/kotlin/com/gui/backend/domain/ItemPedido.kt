package com.gui.backend.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import com.gui.backend.domain.pks.ItemPedidoPK
import javax.persistence.EmbeddedId
import javax.persistence.Entity

@Entity
data class ItemPedido(

    @JsonIgnore
    @EmbeddedId
    var id: ItemPedidoPK = ItemPedidoPK(),
    var desconto: Double? = null,
    var quantitade: Int? = null,
    var preco: Double? = null
) {
    companion object {
        fun createIdFrom(pedido: Pedido, produto: Produto): ItemPedidoPK = ItemPedidoPK(pedido, produto)
    }
    
    fun getProduto(): Produto? {
        return id.produto
    }
}