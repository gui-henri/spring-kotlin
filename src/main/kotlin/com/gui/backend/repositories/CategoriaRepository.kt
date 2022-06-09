package com.gui.backend.repositories


import com.gui.backend.domain.Categoria
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoriaRepository: JpaRepository<Categoria, Int>