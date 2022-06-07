package com.gui.backend.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Categoria (
     var nome: String = "",
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     var id: Int = 0
) {
     override fun equals(other: Any?): Boolean {
          if (this === other) return true
          if (javaClass != other?.javaClass) return false

          other as Categoria

          if (nome != other.nome) return false

          return true
     }

     override fun hashCode(): Int {
          return nome.hashCode()
     }
}