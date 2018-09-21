package org.dork.ledger.controller

import org.dork.ledger.R
import org.dork.ledger.domain.Goods
import org.dork.ledger.repository.GoodsRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.persistence.EntityManager

@RestController
class GoodsController(private val repository: GoodsRepository, private val entityManager: EntityManager) {

    @GetMapping("/goodsList")
    fun goodsList(): Page<Goods> {

        println(System.getProperty("user.dir"))
        return repository.findAll(PageRequest.of(0, 10))
    }

    /**
     * 添加一条商品
     */
    @PostMapping("/add")
    fun add(@RequestBody goods: Goods): R {

        val result = repository.save(goods)
        return R.ok(mapOf("result" to result))
    }

    /**
     * 通过名称查找商品
     */
    @GetMapping("/findByName")
    fun findByName(@RequestBody goodsParams: GoodsParams): Page<Goods> {

        // 开始页码， 从0开始。 容量
        return repository.findByName(goodsParams.name,
                PageRequest.of(
                        goodsParams.page - 1,
                        goodsParams.pageSize,
                        Sort.by(Sort.Direction.ASC, "id"))
        )
    }

}

data class GoodsParams(val page: Int = 1,
                       val pageSize: Int = 10,
                       val name: String,
                       val gtPrice: Double, // great than
                       val ltPrice: Double // less than
)