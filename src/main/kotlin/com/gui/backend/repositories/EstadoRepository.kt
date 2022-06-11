package com.gui.backend.repositories

import com.gui.backend.domain.Estado
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EstadoRepository: JpaRepository<Estado, Int>