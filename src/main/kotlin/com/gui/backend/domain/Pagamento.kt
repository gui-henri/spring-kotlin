package com.gui.backend.domain

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore
import com.gui.backend.domain.enums.EstadoPagamento
import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
abstract class Pagamento (
    @Id
    var id: Int? = null,
    var estadoPagamento: String? = null,

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "pedido_id")
    @MapsId
    var pedido: Pedido? = null
)