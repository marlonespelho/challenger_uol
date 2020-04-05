package com.espelho.challenger.uol.entities

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "product")
data class ProductEntity(
        @Id
        @Column
        val id: UUID = UUID.randomUUID(),
        @Column(nullable = false)
        val name: String = "",
        @Column(nullable = false)
        val weight: Double = 0.0) {

}