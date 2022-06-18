package com.gui.backend.repositories

import com.gui.backend.domain.ItemPedido
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ItemPedidoRepository: JpaRepository<ItemPedido, Int>