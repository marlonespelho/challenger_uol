package com.espelho.challenger.uol.repositories

import com.espelho.challenger.uol.entities.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ProductRepository : JpaRepository<ProductEntity, UUID> {
}