package com.espelho.challenger.uol.services

import com.espelho.challenger.uol.entities.GiftEntity
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

    private fun persistSendsByGift(priceRulesAccepted: ArrayList<PriceRuleEntity>, gift: GiftEntity ) {
        priceRulesAccepted.forEach() { priceRule ->
            run {
                val send: SendEntity = SendEntity( UUID.randomUUID(), gift,
                        priceRule, this.calculatePrice(gift, priceRule))
                this.save(send)
            }
        }
    }

    fun createSends(gift: GiftEntity) {
        val priceRulesAccepted: ArrayList<PriceRuleEntity> = this.getPriceRules(this.priceRuleService.getPriceRules() ,gift.product.weight)
        persistSendsByGift(priceRulesAccepted, gift)
    }

    private fun calculatePrice(gift: GiftEntity, priceRule: PriceRuleEntity): Double {
        return priceRule.fixedValue + (gift.product.weight * gift.distance * priceRule.distanceValue)
    }

    private fun getPriceRules(priceRules: List<PriceRuleEntity>, weight: Double): ArrayList<PriceRuleEntity> {
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

    fun delete(id : UUID) {
        return this.sendRepository.deleteById(id);
    }

    fun getSends(): Optional<List<SendEntity>> {
        return this.sendRepository.findByOrderByGiftProductNameAscSendValueAsc()
    }

    fun getSends(id: UUID): Optional<SendEntity> {
        return this.sendRepository.findById(id);
    }

    fun getSendsByProduct(productId: UUID): Optional<List<SendEntity>> {
        return this.sendRepository.findByGiftProductIdOrderByGiftProductNameAscSendValueAsc(productId)
    }

    fun getSendsByProduct(productName: String): Optional<List<SendEntity>> {
        return this.sendRepository.findByGiftProductNameOrderByGiftProductNameAscSendValueAsc(productName)
    }

}