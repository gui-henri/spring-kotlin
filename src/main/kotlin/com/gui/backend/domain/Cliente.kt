package com.gui.backend.domain

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
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

    @JsonManagedReference
    @OneToMany(mappedBy = "cliente")
    var listaEndereco: MutableList<Endereco> = mutableListOf(),

    @ElementCollection
    @CollectionTable(name = "TELEFONE")
    var listaTelefone: MutableSet<String> = mutableSetOf(),

    @JsonBackReference
    @OneToMany(mappedBy = "cliente")
    var listaDePedidos: MutableList<Pedido> = mutableListOf()
)