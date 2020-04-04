package com.espelho.challenger.uol.entities

import java.util.*
import javax.persistence.*

@Entity(name = "send")
data class SendEntity(
        @Id
        @Column
        private val id: UUID = UUID.randomUUID(),
        @ManyToOne
        @JoinColumn(name = "present")
        private val present: PresentEntity,
        @ManyToOne
        @JoinColumn(name = "price_rule")
        private val priceRule: PriceRuleEntity,
        @Column(name = "send_value")
        private val sendValue: Double
        ) {
}