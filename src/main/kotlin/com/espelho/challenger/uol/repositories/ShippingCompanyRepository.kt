package com.espelho.challenger.uol.repositories

import com.espelho.challenger.uol.entities.ShippingCompanyEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ShippingCompanyRepository : JpaRepository<ShippingCompanyEntity, UUID> {
    fun findByName(name: String) : Optional<List<ShippingCompanyEntity>>
}