package org.dork.ledger.controller

import org.dork.ledger.domain.Goods
import org.dork.ledger.repository.GoodsRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GoodsController(private val repository: GoodsRepository) {

    @GetMapping("/goodsList")
    fun goodsList(): Page<Goods> {

        println(System.getProperty("user.dir"))
        return repository.findAll(PageRequest.of(0, 10))
    }

    /**
     * 添加一条商品
     */
    @GetMapping("/add")
    fun add(): String {
        val goods = Goods("土豆粉", 12.1)
        //entityManager.persist(goods)
        val result = repository.save(goods)
        println(result)
        return "will show goods list"
    }

    /**
     * 通过名称查找商品
     */
    @GetMapping("/findByName")
    fun findByName(name: String): Page<Goods> {
        // 开始页码， 从0开始。 容量
        return repository.findByName(name, PageRequest.of(1, 10, Sort.by(Sort.Direction.ASC, "id")))
    }


}