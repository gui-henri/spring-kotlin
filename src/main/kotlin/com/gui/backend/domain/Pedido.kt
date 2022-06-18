package com.gui.backend.domain

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonManagedReference
import java.util.Date
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.OneToOne

@Entity
class Pedido (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    var instant: Date? = null,

    @JsonManagedReference
    @OneToOne(cascade = [CascadeType.ALL], mappedBy = "pedido")
    var pagamento: Pagamento? = null,

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    var cliente: Cliente? = null,

    @ManyToOne
    @JoinColumn(name = "endereco_de_entrega_id")
    var enderecoDeEntrega: Endereco? = null,

    @OneToMany(mappedBy = "id.pedido")
    var itens: MutableSet<ItemPedido> = mutableSetOf()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Pedido

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id ?: 0
    }
}