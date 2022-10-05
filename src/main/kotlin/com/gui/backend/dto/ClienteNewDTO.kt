package com.gui.backend.dto

data class ClienteNewDTO (
    var nome: String? = null,
    var email: String? = null,
    var cpfOuCnpj: String? = null,
    var tipo: String? = null,

    var logradouro: String? = null,
    var numero: String? = null,
    var complemento: String? = null,
    var bairro: String? = null,
    var cep: String? = null,

    var telefone: String,
    var telefone2: String? = null,
    var telefone3: String? = null,

    var cidadeId: Int? = null
)