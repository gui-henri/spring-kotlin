package com.gui.backend.repositories

import com.gui.backend.domain.Cidade
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CidadeRepository: JpaRepository<Cidade, Int>