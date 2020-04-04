package com.espelho.challenger.uol.entities

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "shipping_company")
class ShippingCompanyEntity(
        @Id
        @Column
        override val id: UUID = UUID.randomUUID(),
        @Column
        override val name: String) : Person {

}