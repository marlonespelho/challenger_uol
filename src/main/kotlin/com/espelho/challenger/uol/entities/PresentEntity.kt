package com.espelho.challenger.uol.entities

import java.util.*
import javax.persistence.*

@Entity(name = "present")
data class PresentEntity(
        @Id
        @Column
        private val id: UUID = UUID.randomUUID(),
        @Column
        private val distance: Double = 0.0,
        @ManyToOne
        @JoinColumn(name = "id_product")
        private val product : ProductEntity = ProductEntity()) {
}