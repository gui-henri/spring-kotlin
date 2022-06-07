package com.gui.backend.resources

import com.gui.backend.domain.Categoria
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/categorias"])
class CategoriaResource {

    @GetMapping
    fun findAll(): List<Categoria> = listOf(
        Categoria(1, "eletrônicos"),
        Categoria(2, "facas")
    )
}