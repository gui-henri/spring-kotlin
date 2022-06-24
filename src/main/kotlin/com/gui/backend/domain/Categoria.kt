package com.gui.backend.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToMany

@Entity
data class Categoria(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    var nome: String? = null,
    
    @ManyToMany(mappedBy = "categorias")
    val produtos: MutableList<Produto> = mutableListOf()
)