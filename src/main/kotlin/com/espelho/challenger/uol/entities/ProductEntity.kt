package com.espelho.challenger.uol.entities

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "product")
data class ProductEntity(
        @Id
        @Column
        private val id: UUID = UUID.randomUUID(),
        @Column
        private val name: String = "",
        @Column
        private val weight: Double = 0.0) {
}