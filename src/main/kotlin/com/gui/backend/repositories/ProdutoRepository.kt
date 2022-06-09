package com.gui.backend.repositories

import com.gui.backend.domain.Produto
import org.springframework.data.jpa.repository.JpaRepository

interface ProdutoRepository: JpaRepository<Produto, Int>