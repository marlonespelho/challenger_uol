package com.espelho.challenger.uol.entities

import java.util.*
import javax.persistence.*

@Entity(name = "send")
data class SendEntity(
        @Id
        @Column
        val id: UUID = UUID.randomUUID(),
        @ManyToOne
        @JoinColumn(name = "gift")
        val gift: GiftEntity = GiftEntity(),
        @ManyToOne
        @JoinColumn(name = "price_rule")
        val priceRule: PriceRuleEntity = PriceRuleEntity(),
        @Column(name = "send_value")
        val sendValue: Double = 0.0
        ) {
}