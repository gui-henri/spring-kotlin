package com.gui.backend.domain

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
data class Endereco(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    var logradouro: String? = null,
    var numero: String? = null,
    var complemento: String? = null,
    var bairro: String? = null,
    var cep: String? = null,

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    var cliente: Cliente? = null,

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    var cidade: Cidade? = null
)