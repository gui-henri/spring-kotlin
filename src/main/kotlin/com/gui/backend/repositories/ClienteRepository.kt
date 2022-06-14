package com.gui.backend.repositories

import com.gui.backend.domain.Cliente
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClienteRepository: JpaRepository<Cliente, Int>