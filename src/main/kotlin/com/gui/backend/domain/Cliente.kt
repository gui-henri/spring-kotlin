package com.gui.backend.domain

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonManagedReference
import com.gui.backend.dto.ClienteDTO
import com.gui.backend.dto.ClienteNewDTO
import javax.persistence.CascadeType
import javax.persistence.CollectionTable
import javax.persistence.ElementCollection
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
data class Cliente(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    var nome: String? = null,
    var email: String? = null,
    var cpfOuCnpj: String? = null,
    var tipo: String? = null,

    @OneToMany(mappedBy = "cliente", cascade = [CascadeType.ALL])
    var listaEndereco: MutableList<Endereco> = mutableListOf(),

    @ElementCollection
    @CollectionTable(name = "TELEFONE")
    var listaTelefone: MutableSet<String> = mutableSetOf(),

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    var listaDePedidos: MutableList<Pedido> = mutableListOf()
) {
    companion object Factory{
        fun fromDTO(clienteDTO: ClienteDTO) = Cliente(clienteDTO.id, clienteDTO.nome, clienteDTO.email)
        fun fromDTO(clienteNewDTO: ClienteNewDTO): Cliente {
            val cliente = Cliente(null,
                clienteNewDTO.nome,
                clienteNewDTO.email,
                clienteNewDTO.cpfOuCnpj,
                clienteNewDTO.tipo
            )
            val cidade = Cidade(clienteNewDTO.cidadeId, null, null)
            val endereco = Endereco(
                null,
                logradouro = clienteNewDTO.logradouro,
                numero = clienteNewDTO.numero,
                complemento = clienteNewDTO.complemento,
                bairro = clienteNewDTO.bairro,
                cep = clienteNewDTO.cep,
                cliente = cliente,
                cidade = cidade
            )

            cliente.listaEndereco.add(endereco)
            cliente.listaTelefone.add(clienteNewDTO.telefone)

            if (clienteNewDTO.telefone2 != null) { cliente.listaTelefone.add(clienteNewDTO.telefone2!!) }
            if (clienteNewDTO.telefone3 != null) { cliente.listaTelefone.add(clienteNewDTO.telefone3!!) }

            return cliente
        }
    }
}