package com.espelho.challenger.uol.services

import com.espelho.challenger.uol.entities.PriceRuleEntity
import com.espelho.challenger.uol.repositories.PriceRuleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class PriceRuleService(@Autowired private val priceRuleRepository: PriceRuleRepository) {
    fun save(priceRule: PriceRuleEntity): PriceRuleEntity {
        return this.priceRuleRepository.save(priceRule);
    }

    fun delete(id : UUID) {
        return this.priceRuleRepository.deleteById(id);
    }

    fun getAll(): MutableList<PriceRuleEntity> {
        return this.priceRuleRepository.findAll();
    }

    fun getById(id: UUID): Optional<PriceRuleEntity> {
        return this.priceRuleRepository.findById(id);
    }

    fun getByProductId(shippingCompanyId: UUID): Optional<List<PriceRuleEntity>> {
        return this.priceRuleRepository.findByShippingCompanyId(shippingCompanyId);
    }
}