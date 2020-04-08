package com.espelho.challenger.uol.entities

import java.util.*
import javax.persistence.*

@Entity(name = "gift")
data class GiftEntity(
        @Id
        @Column
        val id: UUID = UUID.randomUUID(),
        @Column
        val distance: Double = 0.0,
        @ManyToOne
        @JoinColumn(name = "id_product")
        val product : ProductEntity = ProductEntity()) {
}