package com.gui.backend.services

import com.gui.backend.domain.Cliente
import com.gui.backend.repositories.ClienteRepository
import com.gui.backend.services.exceptions.ObjectNotFoundException
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class ClienteService(private val repo: ClienteRepository) {

    fun findById(id: Int): Cliente {
        val cliente: Optional<Cliente> = repo.findById(id)

        return cliente.orElseThrow{ObjectNotFoundException("Id não encontrado")}
    }
}