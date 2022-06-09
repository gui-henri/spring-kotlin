package com.gui.backend.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinColumns
import javax.persistence.JoinTable
import javax.persistence.ManyToMany

@Entity
data class Produto(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    var nome: String? = null,
    var preco: Double? = null,

    @ManyToMany
    @JoinTable(
        name = "PRODUTO_CATEGORIA",
        joinColumns = [JoinColumn(name = "produto_id")],
        inverseJoinColumns = [JoinColumn(name = "categoria_id")]
    )
    var categorias: MutableList<Categoria> = mutableListOf()
)