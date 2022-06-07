package com.gui.backend.resources

import com.gui.backend.CategoriaService
import com.gui.backend.domain.Categoria
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/categorias"])
class CategoriaResource(private val service: CategoriaService) {

    @GetMapping(value = ["/{id}"])
    fun findById(@PathVariable id: Int): ResponseEntity<Categoria> {
        return ResponseEntity.ok().body(service.buscar(id))
    }

}