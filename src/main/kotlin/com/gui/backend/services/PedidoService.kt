package com.gui.backend.services

import com.gui.backend.domain.Categoria
import com.gui.backend.domain.Pedido
import com.gui.backend.repositories.PedidoRepository
import com.gui.backend.services.exceptions.ObjectNotFoundException
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class PedidoService(private val repo: PedidoRepository) {

    fun findById(id: Int): Pedido {
        val pedido: Optional<Pedido> = repo.findById(id)

        return pedido.orElseThrow{ObjectNotFoundException("Id não encontrado")}
    }
}