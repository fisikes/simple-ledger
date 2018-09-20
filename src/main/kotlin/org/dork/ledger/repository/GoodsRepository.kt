package org.dork.ledger.repository

import org.dork.ledger.domain.Goods
import org.springframework.data.repository.CrudRepository

interface GoodsRepository : CrudRepository<Goods, Int> {
    // fun findAll(): Iterable<Goods>
}