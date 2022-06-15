package com.gui.backend.domain

import com.gui.backend.domain.enums.EstadoPagamento
import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
abstract class Pagamento (
    @Id
    var id: Int? = null,
    var estadoPagamento: Int? = null,

    @OneToOne
    @JoinColumn(name = "pedido_id")
    @MapsId
    var pedido: Pedido? = null
)