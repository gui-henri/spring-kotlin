package com.gui.backend.resources

import com.gui.backend.domain.Categoria
import com.gui.backend.services.CategoriaService
import com.gui.backend.services.exceptions.ObjectNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping(value = ["/categorias"])
class CategoriaResource(private val service: CategoriaService) {

    @GetMapping(value = ["/{id}"])
    fun findById(@PathVariable id: Int): ResponseEntity<Categoria> {
        val obj: Categoria = try {
            service.findById(id)
        } catch (e: ObjectNotFoundException) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, e.localizedMessage, e)
        }
        return ResponseEntity.ok().body(obj)
    }

}