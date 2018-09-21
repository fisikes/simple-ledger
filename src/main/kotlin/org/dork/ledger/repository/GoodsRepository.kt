package org.dork.ledger.repository

import org.dork.ledger.domain.Goods
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository

interface GoodsRepository : CrudRepository<Goods, Int> {

    fun findAll(pageable: Pageable): Page<Goods>

    fun findByName(name: String,pageable: Pageable): Page<Goods>
}