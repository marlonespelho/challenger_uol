package com.espelho.challenger.uol.repositories

import com.espelho.challenger.uol.entities.PresentEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PresentRepository : JpaRepository<PresentEntity, UUID> {
    fun findByProductId(productId: UUID): Optional<List<PresentEntity>>
}