package com.gui.backend.config

import com.gui.backend.domain.Categoria
import com.gui.backend.domain.Cidade
import com.gui.backend.domain.Estado
import com.gui.backend.domain.Produto
import com.gui.backend.repositories.CategoriaRepository
import com.gui.backend.repositories.CidadeRepository
import com.gui.backend.repositories.EstadoRepository
import com.gui.backend.repositories.ProdutoRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Configuration

@Configuration
class TestDataConfig(
    val categoryRepository: CategoriaRepository,
    val produtoRepository: ProdutoRepository,
    val cidadeRepository: CidadeRepository,
    val estadoRepository: EstadoRepository
    ): CommandLineRunner {

    override fun run(vararg args: String?) {
        val cat: Categoria = Categoria(null, "Informática")
        val cat2: Categoria = Categoria(null, "Escritório")

        val prod: Produto = Produto(null, "Computador", 2000.0)
        val prod2: Produto = Produto(null, "Impressora", 800.0)
        val prod3: Produto = Produto(null, "Mouse", 60.0)

        val estado: Estado = Estado(null, "Minas Gerais")
        val estado2: Estado = Estado(null, "São Paulo")

        val cit: Cidade = Cidade(null, "Uberlândia", estado)
        val cit2: Cidade = Cidade(null, "São Paulo", estado2)
        val cit3: Cidade = Cidade(null, "Campinas", estado)

        estado.cidades.addAll(listOf(cit))
        estado2.cidades.addAll(listOf(cit2, cit3))

        cat.produtos.addAll(listOf(prod, prod2, prod3))
        cat2.produtos.addAll(listOf(prod2))

        prod.categorias.addAll(listOf(cat))
        prod2.categorias.addAll(listOf(cat, cat2))
        prod3.categorias.addAll(listOf(cat))

        estadoRepository.saveAll(listOf(estado, estado2))
        cidadeRepository.saveAll(listOf(cit, cit2, cit3))
        categoryRepository.saveAll(listOf(cat, cat2))
        produtoRepository.saveAll(listOf(prod, prod2, prod3))
    }
}