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

    fun getPriceRules(): MutableList<PriceRuleEntity> {
        return this.priceRuleRepository.findAll()
    }

    fun getById(id: UUID): Optional<PriceRuleEntity> {
        return this.priceRuleRepository.findById(id)
    }

    fun getByShippingCompany(shippingCompanyId: UUID): Optional<List<PriceRuleEntity>> {
        return this.priceRuleRepository.findByShippingCompanyId(shippingCompanyId)
    }

    fun getByShippingCompany(shippingCompanyName: String): Optional<List<PriceRuleEntity>> {
        return this.priceRuleRepository.findByShippingCompanyName(shippingCompanyName)
    }

    fun getPriceRules(priceRules: List<PriceRuleEntity>, weight: Double): ArrayList<PriceRuleEntity> {
        val priceRulesAccepted = ArrayList<PriceRuleEntity>()
        priceRules.forEach { priceRule ->
            run {
                if (weight >= priceRule.weightMin && weight <= priceRule.weightMax) {
                    priceRulesAccepted.add(priceRule)
                }
            }
        }
        return priceRulesAccepted
    }
}