package com.gui.backend.repositories


import com.gui.backend.domain.Pagamento
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PagamentoRepository: JpaRepository<Pagamento, Int>