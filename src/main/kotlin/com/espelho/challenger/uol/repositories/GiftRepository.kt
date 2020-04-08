package com.espelho.challenger.uol.repositories

import com.espelho.challenger.uol.entities.GiftEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface GiftRepository : JpaRepository<GiftEntity, UUID> {
    fun findByProductId(productId: UUID): Optional<List<GiftEntity>>
    fun findByProductName(productName: String): Optional<List<GiftEntity>>
}