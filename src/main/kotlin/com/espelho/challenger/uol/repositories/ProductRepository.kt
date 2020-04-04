package com.espelho.challenger.uol.repositories

import com.espelho.challenger.uol.entities.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProductRepository : JpaRepository<ProductEntity, UUID> {
    fun findByName(name: String) : Optional<List<ProductEntity>>
}