package com.gui.backend.resources

import com.gui.backend.domain.Categoria
import com.gui.backend.dto.CategoriaDTO
import com.gui.backend.services.CategoriaService
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

@RestController
@RequestMapping(value = ["/categorias"])
class CategoriaResource(private val service: CategoriaService) {

    @GetMapping(value = ["/{id}"])
    fun findById(@PathVariable id: Int): ResponseEntity<Categoria> =
        ResponseEntity.ok().body(service.findById(id))

    @GetMapping()
    fun findAll(): ResponseEntity<List<CategoriaDTO>> {
        val listCategoria = service.findAll()
        val listCategoriaDTO = listCategoria.map { categoria -> CategoriaDTO.createFromCategoria(categoria) }
        return ResponseEntity.ok().body(listCategoriaDTO)
    }

    @PostMapping()
    fun insert(@RequestBody categoria: Categoria): ResponseEntity<Void> {
        val novaCategoria = service.insert(categoria)
        val url: URI = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(novaCategoria.id)
            .toUri()
        return ResponseEntity.created(url).build()
    }

    @PutMapping(value = ["/{id}"])
    fun update(@RequestBody categoria: Categoria, @PathVariable id: Int): ResponseEntity<Void> {
        val updatedCat = service.update(categoria, id)
        return ResponseEntity.noContent().build()
    }

    @DeleteMapping(value = ["/{id}"])
    fun deleteByID(@PathVariable id: Int): ResponseEntity<Void> {
        service.delete(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping(value = ["/page"])
    fun findPage(
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "linesPerPage", defaultValue = "24") linesPerPage: Int,
        @RequestParam(value = "orderBy", defaultValue = "nome") orderBy: String,
        @RequestParam(value = "direction", defaultValue = "ASC") direction: String
    ): ResponseEntity<Page<CategoriaDTO>> {
        val list = service.findPage(page, linesPerPage, orderBy, direction)
        val listDto = list.map{ obj -> CategoriaDTO.createFromCategoria(obj) }
        return ResponseEntity.ok().body(listDto)
    }

}