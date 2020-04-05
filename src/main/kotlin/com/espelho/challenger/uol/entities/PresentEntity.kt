package com.espelho.challenger.uol.entities

import java.util.*
import javax.persistence.*

@Entity(name = "present")
data class PresentEntity(
        @Id
        @Column
        val id: UUID = UUID.randomUUID(),
        @Column
        val distance: Double = 0.0,
        @ManyToOne
        @JoinColumn(name = "id_product")
        val product : ProductEntity = ProductEntity()) {
}