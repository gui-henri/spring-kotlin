package com.gui.backend.config

import com.gui.backend.domain.*
import com.gui.backend.domain.enums.TipoCliente
import com.gui.backend.repositories.*
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Configuration

@Configuration
class TestDataConfig(
    val categoryRepository: CategoriaRepository,
    val produtoRepository: ProdutoRepository,
    val cidadeRepository: CidadeRepository,
    val estadoRepository: EstadoRepository,
    val clienteRepository: ClienteRepository,
    val enderecoRepository: EnderecoRepository
    ): CommandLineRunner {

    override fun run(vararg args: String?) {
        val cat = Categoria(null, "Informática")
        val cat2 = Categoria(null, "Escritório")

        val prod = Produto(null, "Computador", 2000.0)
        val prod2 = Produto(null, "Impressora", 800.0)
        val prod3 = Produto(null, "Mouse", 60.0)

        val estado = Estado(null, "Minas Gerais")
        val estado2 = Estado(null, "São Paulo")

        val cit = Cidade(null, "Uberlândia", estado)
        val cit2 = Cidade(null, "São Paulo", estado2)
        val cit3 = Cidade(null, "Campinas", estado)

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

        val cliente = Cliente(
            null,
            "Sarah",
            "sarah@slutmail.com",
            "123.123.321-73",
            TipoCliente.PESSOA_FISICA.id
        )

        cliente.listaTelefone.addAll(listOf("69696969", "24242424"))

        val endereco = Endereco(
            null,
            "Rua Flores",
            "331",
            "Casa",
            "Catembozé",
            "33333-510",
            cliente,
            cit
        )

        val endereco2 = Endereco(
            null,
            "Avenida Matos",
            "441",
            "Apartamento",
            "Fruteiro",
            "511111-320",
            cliente,
            cit2
        )

        cliente.listaEndereco.addAll(listOf(endereco, endereco2))

        clienteRepository.save(cliente)
        enderecoRepository.saveAll(listOf(endereco, endereco2))
    }
}