package com.gui.backend

import com.gui.backend.domain.Categoria
import com.gui.backend.repositories.CategoriaRepository
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class CategoriaService(private val repo: CategoriaRepository) {

    fun buscar(id: Int): Categoria? {
        val categoria: Optional<Categoria> = repo.findById(id)
        return categoria.orElse(null)
    }
}