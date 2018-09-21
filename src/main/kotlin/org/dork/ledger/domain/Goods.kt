package org.dork.ledger.domain

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id


@Entity
data class Goods(val name: String = "", // 商品名称
                 val price: Double, // 商品价格
                 val createTime: LocalDateTime = LocalDateTime.now(),// 创建时间
                 val updateTime: LocalDateTime = LocalDateTime.now(), // 更新时间
                 @Id @GeneratedValue val id: Int? = null//注意这里要把id定义在后边。
)