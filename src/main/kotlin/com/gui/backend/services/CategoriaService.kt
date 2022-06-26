package com.gui.backend.services

import com.gui.backend.domain.Categoria
import com.gui.backend.repositories.CategoriaRepository
import com.gui.backend.services.exceptions.DataIntegrityException
import com.gui.backend.services.exceptions.ObjectNotFoundException
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.stereotype.Service
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

@Service
class CategoriaService(private val repo: CategoriaRepository) {

    fun findById(id: Int): Categoria {
        val categoria: Optional<Categoria> = repo.findById(id)
        return categoria.orElseThrow{ObjectNotFoundException("Id não encontrado")}
    }

    fun findAll(): List<Categoria> = repo.findAll()

    fun insert(categoria: Categoria): Categoria {
        categoria.id = null
        return repo.save(categoria)
    }

    fun update(categoria: Categoria, id: Int): Categoria {
        categoria.id = id
        findById(id)
        return repo.save(categoria)
    }

    fun delete(id: Int) {
        findById(id)
        try {
            return repo.deleteById(id)
        }catch (e: DataIntegrityViolationException){
            throw DataIntegrityException("Não é possível excluir categoria que possui produtos")
        }
    }

}