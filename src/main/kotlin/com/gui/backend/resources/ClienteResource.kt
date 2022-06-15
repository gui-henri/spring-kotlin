package com.gui.backend.resources

import com.gui.backend.domain.Cliente
import com.gui.backend.services.ClienteService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/clientes"])
class ClienteResource(private val service: ClienteService) {

    @GetMapping(value = ["/{id}"])
    fun findById(@PathVariable id: Int): ResponseEntity<Cliente> {
        val obj: Cliente = service.findById(id)

        return ResponseEntity.ok().body(obj)
    }

}