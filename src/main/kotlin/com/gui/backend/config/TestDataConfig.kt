package com.gui.backend.config

import com.gui.backend.domain.*
import com.gui.backend.domain.enums.EstadoPagamento
import com.gui.backend.domain.enums.TipoCliente
import com.gui.backend.domain.pks.ItemPedidoPK
import com.gui.backend.repositories.*
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Configuration
import java.text.SimpleDateFormat

@Configuration
class TestDataConfig(
    val categoryRepository: CategoriaRepository,
    val produtoRepository: ProdutoRepository,
    val cidadeRepository: CidadeRepository,
    val estadoRepository: EstadoRepository,
    val clienteRepository: ClienteRepository,
    val enderecoRepository: EnderecoRepository,
    val pedidoRepository: PedidoRepository,
    val pagamentoRepository: PagamentoRepository,
    val itemPedidoRepository: ItemPedidoRepository
    ): CommandLineRunner {

    override fun run(vararg args: String?) {
        val cat = Categoria(null, "Informática")
        val cat2 = Categoria(null, "Escritório")
        val cat3 = Categoria(null, "Cama mesa e banho")
        val cat4 = Categoria(null, "Eletrônicos")
        val cat5 = Categoria(null, "Jardinagem")
        val cat6 = Categoria(null, "Decoração")
        val cat7 = Categoria(null, "Perfumaria")

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
        categoryRepository.saveAll(listOf(cat, cat2, cat3, cat4, cat5, cat6, cat7))
        produtoRepository.saveAll(listOf(prod, prod2, prod3))

        val cliente = Cliente(
            null,
            "Sarah",
            "sarah@slutmail.com",
            "123.123.321-73",
            TipoCliente.PESSOA_FISICA.descricao
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

        val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
        val pedido = Pedido(
            null,
            sdf.parse("30/09/2022 10:32"),
            null,
            cliente,
            endereco
        )

        val pedido2 = Pedido(
            null,
            sdf.parse("10/10/2022 10:32"),
            null,
            cliente,
            endereco2
        )

        val pagamento = PagamentoComCartao(
            null,
            EstadoPagamento.QUITADO.descricao,
            pedido,
            6
        )

        pedido.pagamento = pagamento

        val pagamento2 = PagamentoComBoleto(
            null,
            EstadoPagamento.PENDENTE.descricao,
            pedido2,
            sdf.parse("20/10/2022 00:00"),
            null
        )

        pedido2.pagamento = pagamento2

        cliente.listaDePedidos.addAll(listOf(pedido, pedido2))

        pedidoRepository.saveAll(listOf(pedido, pedido2))
        pagamentoRepository.saveAll(listOf(pagamento, pagamento2))

        val itemPedido = ItemPedido(
            ItemPedido.createIdFrom(pedido, prod),
            0.00,
            1,
            2000.0
        )

        val itemPedido2 = ItemPedido(
            ItemPedido.createIdFrom(pedido, prod3),
            0.00,
            2,
            80.0
        )

        val itemPedido3 = ItemPedido(
            ItemPedido.createIdFrom(pedido2, prod2),
            100.00,
            1,
            800.0
        )

        pedido.itens.addAll(listOf(itemPedido, itemPedido2))
        pedido2.itens.addAll(listOf(itemPedido3))

        prod.itens.add(itemPedido)
        prod2.itens.add(itemPedido3)
        prod3.itens.add(itemPedido2)

        itemPedidoRepository.saveAll(listOf(itemPedido, itemPedido2, itemPedido3))
    }
}