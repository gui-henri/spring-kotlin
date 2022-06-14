package com.gui.backend.repositories

import com.gui.backend.domain.Endereco
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EnderecoRepository: JpaRepository<Endereco, Int>