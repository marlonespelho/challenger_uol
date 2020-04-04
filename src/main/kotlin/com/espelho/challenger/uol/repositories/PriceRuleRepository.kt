package com.espelho.challenger.uol.repositories

import com.espelho.challenger.uol.entities.PriceRuleEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PriceRuleRepository : JpaRepository<PriceRuleEntity, UUID> {
    fun findByShippingCompanyId(shippingCompanyId: UUID): Optional<List<PriceRuleEntity>>
}