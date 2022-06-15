package com.gui.backend.repositories


import com.gui.backend.domain.Pedido
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PedidoRepository: JpaRepository<Pedido, Int>