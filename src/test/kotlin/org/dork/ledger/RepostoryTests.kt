package org.dork.ledger

import org.dork.ledger.domain.Goods
import org.dork.ledger.repository.GoodsRepository
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@DataJpaTest
class RepositoryTests(@Autowired val entityManager: TestEntityManager,
                      @Autowired val simpleRepository: GoodsRepository) {

//    @Test
//    fun `save one`() {
//        val goods = Goods("土豆粉", 12.1)
//        //entityManager.persist(goods)
//        simpleRepository.save(goods)
//    }
//
//    @Test
//    fun `get all`() {
//        val result = simpleRepository.findAll()
//        println(result)
//    }
}