package com.gui.backend.services

import com.gui.backend.domain.Categoria
import com.gui.backend.domain.Cliente
import com.gui.backend.repositories.ClienteRepository
import com.gui.backend.services.exceptions.DataIntegrityException
import com.gui.backend.services.exceptions.ObjectNotFoundException
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class ClienteService(private val repo: ClienteRepository) {

    fun findById(id: Int): Cliente {
        val cliente: Optional<Cliente> = repo.findById(id)
        return cliente.orElseThrow{ObjectNotFoundException("Id não encontrado")}
    }

    fun findAll(): List<Cliente> = repo.findAll()

    fun update(cliente: Cliente, id: Int): Cliente {
        cliente.id = id
        val novoCliente = findById(id)
        uptadeData(novoCliente, cliente)
        return repo.save(novoCliente)
    }

    fun uptadeData(novoCliente: Cliente, cliente: Cliente) {
        novoCliente.nome = cliente.nome
        novoCliente.email = cliente.email
    }

    fun delete(id: Int) {
        findById(id)
        try {
            return repo.deleteById(id)
        }catch (e: DataIntegrityViolationException){
            throw DataIntegrityException("Não é possível excluir cliente pois este possui dependências.")
        }
    }

    fun findPage(page: Int, linesPerPage: Int, orderBy: String, direction: String): Page<Cliente> {
        val pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy)
        return repo.findAll(pageRequest)
    }
}