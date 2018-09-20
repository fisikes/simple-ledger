package org.dork.ledger

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SimpleLedgerApplication

fun main(args: Array<String>) {
    runApplication<SimpleLedgerApplication>(*args)
}
