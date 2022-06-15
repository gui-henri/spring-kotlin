package com.gui.backend.domain

import java.util.Date
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToOne

@Entity
data class Pedido (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    var instant: Date? = null,

    @OneToOne(cascade = [CascadeType.ALL], mappedBy = "pedido")
    var pagamento: Pagamento? = null,

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    var cliente: Cliente? = null,

    @ManyToOne
    @JoinColumn(name = "endereco_de_entrega_id")
    var enderecoDeEntrega: Endereco? = null
)