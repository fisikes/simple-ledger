package org.dork.ledger.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id


@Entity
data class Goods(val name: String, // 商品名称
                 val price: Double, // 商品价格
                 @Id @GeneratedValue val id: Int? = null//注意这里要把id定义在后边。
)