package com.espelho.challenger.uol.repositories

import com.espelho.challenger.uol.entities.ShippingCompanyEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ShippingCompanyRepository : JpaRepository<ShippingCompanyEntity, UUID> {

}