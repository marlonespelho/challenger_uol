package com.espelho.challenger.uol.entities

import java.util.*
import javax.persistence.*

@Entity(name = "price_rule")
class PriceRuleEntity (
        @Id
        @Column
        private val id: UUID = UUID.randomUUID(),
        @ManyToOne
        @JoinColumn(name = "id_shipping_company")
        private val shippingCompany: ShippingCompanyEntity,
        @Column(name = "weight_min")
        private val weightMin: Double,
        @Column(name = "weight_max")
        private val weightMax: Double,
        @Column(name = "fixed_value")
        private val fixedValue: Double,
        @Column(name = "distance_value")
        private val distanceValue: Double
        ) {
}