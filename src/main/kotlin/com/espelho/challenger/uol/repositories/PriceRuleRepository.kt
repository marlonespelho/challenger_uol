package com.espelho.challenger.uol.repositories

import com.espelho.challenger.uol.entities.PriceRuleEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface PriceRuleRepository : JpaRepository<PriceRuleEntity, UUID> {
}