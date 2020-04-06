package com.espelho.challenger.uol.services

import com.espelho.challenger.uol.entities.PresentEntity
import com.espelho.challenger.uol.entities.PriceRuleEntity
import com.espelho.challenger.uol.entities.SendEntity
import com.espelho.challenger.uol.repositories.SendRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.ArrayList

@Service
class SendService(@Autowired private val sendRepository: SendRepository,
                  @Autowired private val priceRuleService: PriceRuleService) {

    private fun save(send: SendEntity) {
        this.sendRepository.save(send);
    }

    fun createSends(present: PresentEntity) {
        val priceRules: ArrayList<PriceRuleEntity> = this.getPriceRules(present.product.weight)
        priceRules.forEach() { priceRule ->
            run {
                this.save(SendEntity( UUID.randomUUID(), present,
                        priceRule, this.calculatePrice(present, priceRule)))
            }
        }
    }

    fun update(present: PresentEntity) {

    }

    private fun calculatePrice(present: PresentEntity, priceRule: PriceRuleEntity): Double {
        return priceRule.fixedValue + (present.product.weight * present.distance * priceRule.distanceValue)
    }

    private fun getPriceRules(weight: Double): ArrayList<PriceRuleEntity> {
        val priceRules = ArrayList<PriceRuleEntity>()
        this.priceRuleService.getAll().forEach { priceRule ->
            run {
                if (weight >= priceRule.weightMin && weight <= priceRule.weightMax) {
                    priceRules.add(priceRule)
                }
            }
        }
        return priceRules
    }

    fun delete(id : UUID) {
        return this.sendRepository.deleteById(id);
    }

    fun getAll(): MutableList<SendEntity> {
        return this.sendRepository.findAll();
    }

    fun getById(id: UUID): Optional<SendEntity> {
        return this.sendRepository.findById(id);
    }

}