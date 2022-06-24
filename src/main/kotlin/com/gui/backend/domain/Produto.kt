package com.gui.backend.domain

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinColumns
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.OneToMany

@Entity
class Produto(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    var nome: String? = null,
    var preco: Double? = null,

    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "PRODUTO_CATEGORIA",
        joinColumns = [JoinColumn(name = "produto_id")],
        inverseJoinColumns = [JoinColumn(name = "categoria_id")]
    )
    val categorias: MutableList<Categoria> = mutableListOf(),

    @JsonIgnore
    @OneToMany(mappedBy = "id.produto")
    var itens: MutableSet<ItemPedido> = mutableSetOf(),
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Produto

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id ?: 0
    }
}