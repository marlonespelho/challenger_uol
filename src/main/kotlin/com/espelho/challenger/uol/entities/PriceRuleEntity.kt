package com.espelho.challenger.uol.entities

import java.util.*
import javax.persistence.*

@Entity(name = "price_rule")
class PriceRuleEntity (
        @Id
        @Column
        val id: UUID = UUID.randomUUID(),
        @ManyToOne
        @JoinColumn(name = "id_shipping_company")
        val shippingCompany: ShippingCompanyEntity = ShippingCompanyEntity(),
        @Column(name = "weight_min")
        val weightMin: Double = 0.0,
        @Column(name = "weight_max")
        val weightMax: Double = 0.0,
        @Column(name = "fixed_value")
        val fixedValue: Double = 0.0,
        @Column(name = "distance_value")
        val distanceValue: Double = 0.0) {
}