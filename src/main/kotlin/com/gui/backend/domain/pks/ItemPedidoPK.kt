package com.gui.backend.domain.pks

import com.gui.backend.domain.Pedido
import com.gui.backend.domain.Produto
import javax.persistence.Embeddable
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Embeddable
class ItemPedidoPK (
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    var pedido: Pedido? = null,

    @ManyToOne
    @JoinColumn(name = "produto_id")
    var produto: Produto? = null,

): java.io.Serializable {
     override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ItemPedidoPK

        if (pedido != other.pedido) return false
        if (produto != other.produto) return false

        return true
    }

    override fun hashCode(): Int {
        var result = pedido?.hashCode() ?: 0
        result = 31 * result + (produto?.hashCode() ?: 0)
        return result
    }
}