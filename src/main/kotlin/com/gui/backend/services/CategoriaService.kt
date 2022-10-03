package com.gui.backend.services

import com.gui.backend.domain.Categoria
import com.gui.backend.repositories.CategoriaRepository
import com.gui.backend.services.exceptions.DataIntegrityException
import com.gui.backend.services.exceptions.ObjectNotFoundException
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
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
        val novaCategoria = findById(id)
        updateData(novaCategoria, categoria)
        return repo.save(novaCategoria)
    }

    private fun updateData(novaCategoria: Categoria, categoria: Categoria) {
        novaCategoria.nome = categoria.nome
    }

    fun delete(id: Int) {
        findById(id)
        try {
            return repo.deleteById(id)
        }catch (e: DataIntegrityViolationException){
            throw DataIntegrityException("Não é possível excluir categoria que possui produtos")
        }
    }

    fun findPage(page: Int, linesPerPage: Int, orderBy: String, direction: String): Page<Categoria> {
        val pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy)
        return repo.findAll(pageRequest)
    }

}