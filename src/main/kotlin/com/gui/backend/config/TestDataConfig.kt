package com.gui.backend.config

import com.gui.backend.domain.Categoria
import com.gui.backend.repositories.CategoriaRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Configuration

@Configuration
class TestDataConfig(val repository: CategoriaRepository): CommandLineRunner {

    override fun run(vararg args: String?) {
        val cat: Categoria = Categoria("Eletrônicos", null)
        val cat2: Categoria = Categoria("Eletrônicos", null)

        repository.saveAll(listOf(cat, cat2))
    }
}