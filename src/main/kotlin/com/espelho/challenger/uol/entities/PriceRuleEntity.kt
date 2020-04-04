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
        private val shippingCompany: ShippingCompanyEntity = ShippingCompanyEntity(),
        @Column(name = "weight_min")
        private val weightMin: Double = 0.0,
        @Column(name = "weight_max")
        private val weightMax: Double = 0.0,
        @Column(name = "fixed_value")
        private val fixedValue: Double = 0.0,
        @Column(name = "distance_value")
        private val distanceValue: Double = 0.0) {
}