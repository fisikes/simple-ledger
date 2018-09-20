package org.dork.ledger.controller

import org.dork.ledger.domain.Goods
import org.dork.ledger.repository.GoodsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GoodsController {

    @Autowired
    lateinit var goodsRepository :GoodsRepository

    @GetMapping("/goodsList")
    fun goodsList(): String {


        return goodsRepository.findAll().toString()
    }

    @GetMapping("/add")
    fun add(): String {
        val goods = Goods("土豆粉", 12.1)
        //entityManager.persist(goods)
        val result = goodsRepository.save(goods)
        println(result)
        return "will show goods list"
    }
}