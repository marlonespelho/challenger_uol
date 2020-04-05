package com.espelho.challenger.uol.services

import com.espelho.challenger.uol.entities.ProductEntity
import com.espelho.challenger.uol.entities.ShippingCompanyEntity
import com.espelho.challenger.uol.repositories.ShippingCompanyRepository
import org.springframework.beans.factory.annotation.Autowired
import java.util.*

class ShippingCompanyService(
        @Autowired
        private val shippingCompanyRepository: ShippingCompanyRepository) {
    
    fun save(shippingCompanyEntity: ShippingCompanyEntity): ShippingCompanyEntity {
        return this.shippingCompanyRepository.save(shippingCompanyEntity);
    }

    fun delete(id : UUID) {
        return this.shippingCompanyRepository.deleteById(id);
    }

    fun getAll(): MutableList<ShippingCompanyEntity> {
        return this.shippingCompanyRepository.findAll();
    }

    fun getById(id: UUID): Optional<ShippingCompanyEntity> {
        return this.shippingCompanyRepository.findById(id);
    }

    fun getByName(name: String): Optional<List<ShippingCompanyEntity>> {
        return this.shippingCompanyRepository.findByName(name);
    }
}