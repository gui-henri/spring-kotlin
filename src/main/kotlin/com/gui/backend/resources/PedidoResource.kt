package com.gui.backend.resources

import com.gui.backend.domain.Pedido
import com.gui.backend.services.PedidoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/pedidos"])
class PedidoResource(private val service: PedidoService) {

    @GetMapping(value = ["/{id}"])
    fun findById(@PathVariable id: Int): ResponseEntity<Pedido> {
        val obj: Pedido = service.findById(id)

        return ResponseEntity.ok().body(obj)
    }

}