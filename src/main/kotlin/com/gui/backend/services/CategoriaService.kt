package com.gui.backend.services

import com.gui.backend.domain.Categoria
import com.gui.backend.repositories.CategoriaRepository
import com.gui.backend.services.exceptions.ObjectNotFoundException
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class CategoriaService(private val repo: CategoriaRepository) {

    fun findById(id: Int): Categoria {
        val categoria: Optional<Categoria> = repo.findById(id)
        return categoria.orElseThrow{ObjectNotFoundException("Id não encontrado")}
    }

    fun insert(categoria: Categoria): Categoria {
        categoria.id = null
        return repo.save(categoria)
    }
}