package com.gui.backend.domain

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
data class Estado(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    var nome: String? = null,

    @JsonBackReference
    @OneToMany(mappedBy = "estado")
    val cidades: MutableList<Cidade> = mutableListOf()
)