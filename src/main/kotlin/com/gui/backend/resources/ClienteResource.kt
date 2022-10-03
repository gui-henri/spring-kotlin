package com.gui.backend.resources


import com.gui.backend.domain.Cliente
import com.gui.backend.dto.CategoriaDTO
import com.gui.backend.dto.ClienteDTO
import com.gui.backend.services.ClienteService
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping(value = ["/clientes"])
class ClienteResource(private val service: ClienteService) {

    @GetMapping(value = ["/{id}"])
    fun findById(@PathVariable id: Int): ResponseEntity<Cliente> {
        val obj: Cliente = service.findById(id)
        return ResponseEntity.ok().body(obj)
    }

    @GetMapping()
    fun findAll(): ResponseEntity<List<ClienteDTO>> {
        val listCliente = service.findAll()
        val listClienteDTO = listCliente.map { cliente -> ClienteDTO.createFromCliente(cliente) }
        return ResponseEntity.ok().body(listClienteDTO)
    }
    @PutMapping(value = ["/{id}"])
    fun update(@Valid @RequestBody clienteDTO: ClienteDTO, @PathVariable id: Int): ResponseEntity<Void> {
        val cliente = Cliente.fromDTO(clienteDTO)
        service.update(cliente, id)
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
    ): ResponseEntity<Page<ClienteDTO>> {
        val list = service.findPage(page, linesPerPage, orderBy, direction)
        val listDto = list.map{ obj -> ClienteDTO.createFromCliente(obj) }
        return ResponseEntity.ok().body(listDto)
    }

}